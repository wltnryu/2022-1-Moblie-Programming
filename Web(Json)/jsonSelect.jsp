<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
    <%@ page import="org.json.simple.*" %>
		<%
			// JDBC 참조 변수 준비
			String url = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
			String user = "yebbnrjs", pw = "yebbnrjs90";

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			// 1) JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2) DB연결(DB url, DB id, DB pw)
			con = DriverManager.getConnection(url, user, pw);

			// 3) SQL문 준비
			String sql = "SELECT * FROM libraryData";
			pstmt = con.prepareStatement(sql);

			// 4) 실행
			rs = pstmt.executeQuery();

			JSONArray arr = new JSONArray();
			
			//5-1.while문
			while(rs.next()){
				//json object 생성 (import json-simple패키지해야함)
				JSONObject obj = new JSONObject();
				obj.put("name", rs.getString("USER_NAME"));
				obj.put("id", rs.getString("USER_ID"));
				obj.put("birth", rs.getString("birthYear"));
				//obj.put("date", rs.getDate("date"));
				
				//5-3.배열한칸에 객체 하나를 저장
				arr.add(obj);
			}
	  %>

	  <%=arr%>