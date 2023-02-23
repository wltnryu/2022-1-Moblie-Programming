<?php
$con=mysqli_connect("sc1.swu.ac.kr:13306","yebbnrjs","yebbnrjs90","yebbnrjs_ts");

if (mysqli_connect_errno($con)) 
{ echo "MySQL접속 실패: " . mysqli_connect_error(); } 

mysqli_set_charset($con,"utf8");

$res = mysqli_query($con, "SELECT * FROM libraryData WHERE USER_NAME = '$_POST[userName]'"); 

$result = array();

while($row = mysqli_fetch_array($res)) 
{ array_push($result, array('USER_NAME'=>$row[0],'USER_ID'=>$row[1],'birthYear'=>$row[2])); }

echo json_encode(array("result"=>$result), JSON_UNESCAPED_UNICODE); 

mysqli_close($con);

?>