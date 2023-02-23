<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
    <%@ page import="org.json.simple.*" %>
		<%
			// JDBC 참조 변수 준비
			String url = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
			String user = "yebbnrjs", pw = "yebbnrjs90";

            String startDate = request.getParameter("sDate");
            String endDate = request.getParameter("eDate");

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			// 1) JDBC 드라이버 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2) DB연결(DB url, DB id, DB pw)
			con = DriverManager.getConnection(url, user, pw);

			// 3) SQL문 준비
            String sql = "SELECT * FROM COVID19DATA WHERE stdDay >= ? AND stdDay <= ?";
			pstmt = con.prepareStatement(sql);
            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);

			// 4) 실행
			rs = pstmt.executeQuery();

            JSONObject jsonObject = new JSONObject();
			JSONArray covidArray = new JSONArray();
			
			int index = 0;
            int Stdday, Gubun, Defcnt, Deathcnt, Overflowcnt, Localocccnt = 0;
            for(int i = 0; i<covidInfo.length(); i++){ Stdday = Stdday + (int)rs.getString("stdDay"); }
            for(int i = 0; i<covidInfo.length(); i++){ Defcnt = Defcnt + (int)rs.getString("defCnt"); }
            for(int i = 0; i<covidInfo.length(); i++){ Deathcnt = Deathcnt + (int)rs.getString("deathCnt"); }
            for(int i = 0; i<covidInfo.length(); i++){ Overflowcnt = Overflowcnt + (int)rs.getString("overFlowCnt"); }
            for(int i = 0; i<covidInfo.length(); i++){ Localocccnt = Localocccnt + (int)rs.getString("localOccCnt"); }

			//5-1.while문
			while(rs.next()){
				//json object 생성 (import json-simple패키지해야함)
				JSONObject covidInfo = new JSONObject();
				covidInfo.put("stdDay", Stdday);
				covidInfo.put("defCnt", Defcnt);
                covidInfo.put("deathCnt", Deathcnt);
                covidInfo.put("overFlowCnt", Overflowcnt);
                covidInfo.put("localOccCnt", Localocccnt);
                
				//obj.put("date", rs.getDate("date"));
				
				//5-3.배열한칸에 객체 하나를 저장
				covidArray.put(index, covidInfo);
				index++;
			}

			out.prinntln(covidArray);
            jsonObject.put("covidData", covidArray);
            out.write(jsonObject.toJSONString());
            out.flush();
	  %>