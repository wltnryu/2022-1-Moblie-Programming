<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
</head>
<body>
<h1>가입 탈퇴</h1>
<mark><i>삭제하고자 하는 회원의 이름을 입력하세요.</i></mark><br>
<form action="deleteAct.jsp" method="post">
이름: <input type="text" name="userName" ><br /><br />
<button type="submit">삭제</button>
<button type="button" onclick=" location='select.jsp'">뒤로가기</button>
</form>
</body>
</html>