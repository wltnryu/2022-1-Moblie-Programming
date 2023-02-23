import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class GetResult {
 
 
 public static void saveDB(List<XmlDataVO> xmlList){
  
 }
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  File file = new File("covid19data.xml");
  XmlParser xmlParser = new XmlParser(file);
  List<XmlDataVO> tmp = xmlParser.parse("item");
  
  ConnectDB connectDB = new ConnectDB();
  Connection conn = connectDB.getConnection();
  
  String sql = "INSERT INTO COVID19DATA (createDt, deathCnt, defCnt, gubun, gubunCn, gubunEn, incDec, localOccCnt, overFlowCnt, qurRate, seq, stdDay, updateDt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  try {
   for(int i=0; i<tmp.size() ; i++){
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, tmp.get(i).getcreateDt());
    stmt.setString(2, tmp.get(i).getdeathCnt());
    stmt.setString(3, tmp.get(i).getdefCnt());
    stmt.setString(4, tmp.get(i).getgubun());
    stmt.setString(5, tmp.get(i).getgubunCn());
    stmt.setString(6, tmp.get(i).getgubunEn());
    stmt.setString(7, tmp.get(i).getincDec());
    stmt.setString(8, tmp.get(i).getlocalOccCnt());
    stmt.setString(9, tmp.get(i).getoverFlowCnt());
    // stmt.setString(9, tmp.get(i).getisolClearCnt()); - 2022년 02월 23일까지만 존재하는 데이터
    stmt.setString(10, tmp.get(i).getqurRate());
    stmt.setString(11, tmp.get(i).getseq());
    stmt.setString(12, tmp.get(i).getstdDay());
    stmt.setString(13, tmp.get(i).getupdateDt());
    
    stmt.executeUpdate();
    System.out.println("sucess to save");
   }
  } catch (SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
} 