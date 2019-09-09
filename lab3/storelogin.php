<?php

	$em = $_POST["email"];
	$pass = $_POST["pass"];
	$server = "localhost";
	$user = "root";
	$dbpass = "";
	$db = "xssdb";
	$conn = new mysqli($server,$user,$dbpass,$db);
	if($conn->connect_error)
	{
		die("connection failed".$conn->connect_error);
	}
	$query = "INSERT INTO employee (email,password) values('".$em."','".$pass."')";
	$r1 = $conn->query($query);
	$sql = "SELECT * from employee where email = '".$em."'";
	$res = $conn->query($sql);
	 while($row = $res->fetch_assoc()) {
        echo $row["email"];
		echo $row["password"];
    }

?>