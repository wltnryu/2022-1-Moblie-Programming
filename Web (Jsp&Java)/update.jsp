<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<h1>회원 정보 수정</h1>
<form action="updateAct.jsp" method="post">
<mark><i>회원의 이름을 입력하세요.</i></mark><br>
이름: <input type="text" name="userName" ><br /><br /><br />
<mark><i>변경하고자 하는 정보를 입력하세요.</i></mark><br>
ID: <input type="text" name="userID" ><br /><br />
생일: <input type="text" name="userBirth" ><br /><br />
<button type="submit">수정</button>
<button type="button" onclick=" location='select.jsp'">뒤로가기</button>
</form>
</body>
</html>