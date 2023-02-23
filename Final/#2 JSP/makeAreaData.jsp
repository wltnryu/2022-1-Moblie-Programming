<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
    <%@ page import="org.json.simple.*" %>
		<%
			// JDBC 참조 변수 준비
			String url = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
			String user = "yebbnrjs", pw = "yebbnrjs90";

            String strArea = request.getParameter("area");
            String strDate = request.getParameter("date");

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			// 1) JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2) DB연결(DB url, DB id, DB pw)
			con = DriverManager.getConnection(url, user, pw);

			// 3) SQL문 준비
			if(strArea == "전체"){
                String sql = "SELECT * FROM COVID19DATA WHERE stdDay = ?"
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, strDate);
            } else {
                String sql = "SELECT * FROM COVID19DATA WHERE gubun = ? AND stdDay = ?";
			    pstmt = con.prepareStatement(sql);
                pstmt.setString(1, strArea);
                pstmt.setString(2, strDate);

            }

			// 4) 실행
			rs = pstmt.executeQuery();

            JSONObject jsonObject = new JSONObject();
			JSONArray covidArray = new JSONArray();
			
			//5-1.while문
			while(rs.next()){
				//json object 생성 (import json-simple패키지해야함)
				JSONObject covidInfo = new JSONObject();
				covidInfo.put("stdDay", rs.getString("stdDay"));
				covidInfo.put("gubun", rs.getString("gubun"));
				covidInfo.put("defCnt", rs.getString("defCnt"));
                covidInfo.put("deathCnt", rs.getString("deathCnt"));
                covidInfo.put("overFlowCnt", rs.getString("overFlowCnt"))
                covidInfo.put("localOccCnt", rs.getString("localOccCnt"))
                
				//obj.put("date", rs.getDate("date"));
				
				//5-3.배열한칸에 객체 하나를 저장
				covidArray.add(covidInfo);
			}

            jsonObject.put("covidData", covidArray);
            out.write(jsonObject.toJSONString());
            out.flush();
	  %>