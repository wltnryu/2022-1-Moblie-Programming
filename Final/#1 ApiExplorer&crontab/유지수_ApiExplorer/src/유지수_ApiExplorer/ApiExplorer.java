package 유지수_ApiExplorer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.Calendar;
import java.util.GregorianCalendar;

   
public class ApiExplorer {
         
   private static String getTagValue(String tag, Element eElement) {
       NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
       Node nValue = (Node) nlList.item(0);
       if(nValue == null) 
           return null;
       return nValue.getNodeValue();
   }

   

   public static void main(String[] args) throws IOException {
	   
	    Calendar c1 = new GregorianCalendar();
	    c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷 
	    String date = sdf.format(c1.getTime()); // String으로 저장
	   
        StringBuilder urlBuilder = new StringBuilder("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=ejh2bWCVlAdw60rPrL%2FsoJX4EalG%2Fh28%2Fp4sEpd8DtNDlZH%2FcNpP8tTsntOWfM%2FO3Qz74IOKPF4QIwdJoPAqYw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("startCreateDt","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); 
        urlBuilder.append("&" + URLEncoder.encode("endCreateDt","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); 
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        
        int page = 0;   
        
        try{
      	  
      	  Connection con = null;
      	  PreparedStatement pstmt = null; 
      	  String sqlURL = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
      	  String user = "yebbnrjs", pw = "yebbnrjs90";
  				
      	  System.out.println("try : get connection");
      	  Class.forName("org.mariadb.jdbc.Driver");
  	 	  con = DriverManager.getConnection(sqlURL, user, pw);
  	 	  System.out.println("success !");         
  	 	
  	 	
          DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
          Document doc = dBuilder.parse(urlBuilder.toString());
              
          // root tag 
          doc.getDocumentElement().normalize();
          System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
              
              
          NodeList nList = doc.getElementsByTagName("item");
          System.out.println("list num : "+ nList.getLength());
              
          for(int temp = 0; temp < nList.getLength(); temp++){
          	  Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE){

                Element eElement = (Element) nNode;
                
             // 3) SQL
                String sql = "REPLACE INTO COVID19DATA (createDt, deathCnt, defCnt, gubun, gubunCn, gubunEn, incDec, localOccCnt, OverFlowCnt, qurRate, seq, stdDay) "
                      + "VALUES (?, ?, ?, ?,?, ?, ?, ?,?, ?, ?, ?)";

                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, getTagValue("createDt", eElement));
                pstmt.setString(2, getTagValue("deathCnt", eElement));
                pstmt.setString(3, getTagValue("defCnt", eElement));
                pstmt.setString(4, getTagValue("gubun", eElement));
                pstmt.setString(5, getTagValue("gubunCn", eElement));
                pstmt.setString(6,getTagValue("gubunEn", eElement));
                pstmt.setString(7, getTagValue("incDec", eElement));
                pstmt.setString(8, getTagValue("localOccCnt",eElement));
                pstmt.setString(9, getTagValue("overFlowCnt", eElement));
                pstmt.setString(10, getTagValue("qurRate", eElement));
                pstmt.setString(11, getTagValue("seq",eElement));
                pstmt.setString(12, getTagValue("stdDay",eElement));
                 
                // 4) 
                pstmt.executeUpdate();

                page += 1;
                System.out.println("page number : "+page);
              
              
                 }   // for end
              }   // if end
           // while end
           // JDBC 
           pstmt.close();
           con.close();
        } 
        catch (Exception e){   
           e.printStackTrace(); 
        }   // try~catch end 
        
   }   // main end
}   // class end