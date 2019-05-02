<!--
Developer: John Gallagher
Date: December 2019
Purpose: Develop a PHP Web App that has a customer cart and a checkout.
 -->

<?php

//Expire Sessions after 30minutes
session_start();
echo "Username:". $_SESSION['appusername']. "<br>";
echo "Email:".$_SESSION['appemail']."<br>";
?>


<!-- The Shopping Cart -->
<html>
<meta charset="UTF-8">

<?php
$cart = 0.00;
echo "Purchase List: <br>";
if(!empty($_POST["cpu0"])) {
	$cpu0 = $_POST["cpu0"];
	global $cart;
	$cart = $cart + $cpu0;
	echo "Intel 8th Gen = $cpu0 <br>";
}

if(!empty($_POST["cpu1"])) {
	$cpu1 = $_POST["cpu1"];
	global $cart;
	$cart = $cart + $cpu1;
	echo "Intel Core I7 = $cpu1 <br>";
}

if(!empty($_POST["cpu2"])) {
	$cpu2 = $_POST["cpu2"];
	global $cart;
	$cart = $cart + $cpu2;
	echo "Xeon Processor = $cpu2 <br>";

}
if(!empty($_POST["cpu3"])) {
	$cpu3 = $_POST["cpu3"];
	global $cart;
	$cart = $cart + $cpu3;
	echo "Intel Core i9 = $cpu3<br>";

}
if(!empty($_POST["cpu4"])) {
	$cpu4 = $_POST["cpu4"];
	global $cart;
	$cart = $cart + $cpu4;
	echo "Intel Pentium 4 = $cpu4 <br>";

}
if(!empty($_POST["cpu5"])) {
	$cpu5 = $_POST["cpu5"];
	global $cart;
	$cart = $cart + $cpu5;
	echo "Intel Pentium 3 = $cpu5 <br>";

}
if(!empty($_POST["cpu6"])) {
	$cpu6 = $_POST["cpu6"];
	global $cart;
	$cart = $cart + $cpu6;
	echo "Amd Ryzen7 = $cpu6 <br>";

}
if(!empty($_POST["cpu7"])) {
	$cpu7 = $_POST["cpu7"];
	global $cart;
	$cart = $cart + $cpu7;
	echo "Amd Ryzen5 =  $cpu7 <br>";

}
if(!empty($_POST["cpu8"])) {
	$cpu8 = $_POST["cpu8"];
	global $cart;
	$cart = $cart + $cpu8;
	echo "Amd Ryzen3 = $cpu8 <br>";

}
if(!empty($_POST["cpu9"])) {
	$cpu9 = $_POST["cpu9"];
	global $cart;
	$cart = $cart + $cpu9;
	echo "Amd Ryzen ThreadRipper = $cpu9 <br>";

}

if($cart > 0.00) {
	echo "Total Cost: $cart.00";
} else {
	echo "Total Cost: Nothing in the cart!";
}
?>

<form name='thankyou' action='ThankYouPage_5.php' method='post'>
<input type="submit" name="purchase" value="PURCHASE">
</form>
</html>
