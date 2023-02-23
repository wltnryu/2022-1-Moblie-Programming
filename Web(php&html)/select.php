<?php
    $servername = "sc1.swu.ac.kr:13306";
    $user = "yebbnrjs";
    $password = "yebbnrjs90";
    $dbname = "yebbnrjs_ts";
    
    $con = mysqli_connect($servername, $user, $password, $dbname);

    /* SELECT 예제 */
    $sql = "SELECT * FROM libraryData";
    if($result = mysqli_query($con, $sql)){
        if(mysqli_num_rows($result) > 0){
            echo "<table>";
                echo "<tr>";
                    echo "<th>이름</th>";
                    echo "<th>ID</th>";
                    echo "<th>생년월일</th>";
                echo "</tr>";
            while($row = mysqli_fetch_array($result)){
                echo "<tr>";
                    echo "<td>" . $row['USER_NAME'] . "</td>";
                    echo "<td>" . $row['USER_ID'] . "</td>";
                    echo "<td>" . $row['birthYear'] . "</td>";
                echo "</tr>";
            }
            echo "</table>";
            // Free result set
            mysqli_free_result($result);
        } else{
            echo "No records matching your query were found.";
        }
    } else{
        echo "ERROR: Could not able to execute $sql. " . mysqli_error($con);
    }
     
    // Close connection
    mysqli_close($con);
    ?>