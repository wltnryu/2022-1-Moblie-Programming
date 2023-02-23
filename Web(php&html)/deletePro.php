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

$sql = "DELETE FROM libraryData WHERE USER_NAME = '$_POST[userName]'";

if (mysqli_query($con, $sql)) {
    echo "회원 정보 삭제 성공!";
} else {
    echo "회원 정보 삭제 실패! : ".mysqli_error($con);
}

mysqli_close($con);
?>