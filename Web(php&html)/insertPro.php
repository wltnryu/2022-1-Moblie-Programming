<?php

$servername = "sc1.swu.ac.kr:13306";
$user = "yebbnrjs";
$password = "yebbnrjs90";
$dbname = "yebbnrjs_ts";

$con = mysqli_connect($servername, $user, $password, $dbname);

if (!$con) {
    die("서버와의 연결 실패! : ".mysqli_connect_error());
}
echo "서버와의 연결 성공!";

$sql = "INSERT INTO libraryData (USER_NAME, USER_ID) VALUES ('$_POST[userName]','$_POST[userID]')";

if (mysqli_query($con, $sql)) {
    echo "회원 정보 추가 성공!";
} else {
    echo "회원 정보 추가 실패! : ".mysqli_error($con);
}

mysqli_close($con);
?>