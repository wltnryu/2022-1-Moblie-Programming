<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>

<h1>회원 가입</h1>
<mark><i>회원 정보를 입력하세요.</i></mark><br>
<form action="dataIns.jsp" method="post">
이름: <input type="text" name="userName" ><br /><br />
ID: <input type="text" name="userID" ><br /><br />
<button type="submit">저장</button>
<button type="button" onclick=" location='select.jsp'">뒤로가기</button>
</form>
</body>
</html>