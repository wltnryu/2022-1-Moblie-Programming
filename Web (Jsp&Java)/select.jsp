<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회</title>
<style>
table {
	border-collapse: collapse;
}

th {
	width: 100px;
	background-color: rgb(220, 186, 181);
	border-color: rgb(170, 116, 128);
}

td {
	text-align: center;
}
</style>
</head>
<body>
<h1>회원 정보 조회</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>생년월일</th>
		</tr>
		<%
			String url = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
			String user = "yebbnrjs", pw = "yebbnrjs90";

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "SELECT * FROM libraryData";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String userName = rs.getString("USER_NAME");
				String userID = rs.getString("USER_ID");
				String userBirth = rs.getString("birthYear");
		%>
		<tr>
			<td><%=userName%></td>
			<td><%=userID%></td>
			<td><%=userBirth%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		rs.close();
		pstmt.close();
		con.close();
	%>
	<br />
	<button type="button" onclick=" location='insert.jsp'">가입</button>
	<button type="button" onclick=" location='update.jsp'">수정</button>
	<button type="button" onclick=" location='delete.jsp'">삭제</button>
</body>
</html>