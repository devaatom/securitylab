<?php
if($_POST["email"] and $_POST["pass"])
{
	$em = $_POST["email"];
	$pass = $_POST["pass"];
	$server = "localhost";
	$user = "root";
	$dbpass = "";
	$db = "injectiondb";
	$conn = new mysqli($server,$user,$dbpass,$db);
	if($conn->connect_error)
	{
		die("connection failed".$conn->connect_error);
	}
	$sql = "SELECT * from employee where email = '".$em."' AND password = '".$pass."'";
	$res = $conn->query($sql);
	if($res->num_rows>0)
	{
		echo "auth success";
	}
	else
	{
		echo "no details";
	}
}
?>