<?php
session_start();
$_SESSION['time_stamp'] = time();
if($_SESSION['time_stamp'] > 1800) {
	unset($_SESSION['appusername']);
	unset($_SESSION['appemail']);
}
?>

<html>
<h1>THANK YOU FOR THE PURCHASE, PLEASE COME AGAIN! </h1>
<form action="logoutlab.php" method="post" name="logout">
<input name='logout' type="submit" size='50' value="Logout">
</form>
</html>