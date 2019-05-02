<!--
John Gallagher
SDEV 300
Professor Muhammad
11-16-2018
 -->

<!--Logout page-->
<?
session_start()
unset($_SESSION['appusername']);
unset($_SESSION['appemail']);
setcookie("username","$username", time() -1800, "/");
?>

<html>
<h1>You are now logged out.	 </h1>
</html>