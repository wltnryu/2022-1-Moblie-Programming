<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 정보 저장</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");

String userName = request.getParameter("userName");
String userID = request.getParameter("userID");
String userBirth = request.getParameter("userBirth");

Connection con = null;
PreparedStatement pstmt = null;
String url = "jdbc:mysql://sc1.swu.ac.kr:13306/yebbnrjs_ts";
String user = "yebbnrjs", pw = "yebbnrjs90";

Class.forName("org.mariadb.jdbc.Driver");

con = DriverManager.getConnection(url, user, pw);

String sql = "UPDATE libraryData SET USER_ID = ?, birthYear = ? WHERE USER_NAME = ?";

pstmt = con.prepareStatement(sql);
pstmt.setString(1, userID);
pstmt.setString(2, userBirth);
pstmt.setString(3, userName);

int rowCount = pstmt.executeUpdate();

pstmt.close();
con.close();
%>
<script>
alert("<%=rowCount %>행 변경 완료!");
location.href = 'update.jsp';
</script>
</body>
</html>