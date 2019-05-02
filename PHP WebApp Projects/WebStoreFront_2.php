<!--
Developer: John Gallagher
Date: December 2019
Purpose: Develop a PHP Web App that has a customer cart and a checkout.
 -->

<?php
session_start(); 

//Session and Cookie Variables
$username = $_POST["username"];
$password = $_POST["password"];	
$email = $_POST["email"];
$_SESSION['appusername'] = $username;
$_SESSION['appemail'] = $email;
setcookie("username", "$username", time() + (1800), "/"); 


?>
<html>
<head> 
<meta charset="UTF-8">
<title>The CPU DREAM STORE </title>
</head>

<!--Order page with 10 products and Welcome Message-->
<?php 
echo "<h1>Welcome ".$username.",please click on the CPU checkboxes you wish to purchase and then select BUY! </h1>";
?>
<h3> Intel 8th Generation </h3>
<form action="CheckOutCart_4.php" name="checkout" method="post">

<image src="https://proxy.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.techgenyz.com%2Fwp-content%2Fuploads%2F2017%2F08%2F8th-gen-intel-core-processors.jpg&f=1" height=150px width=150px>
<h4>Name: Intel 8th Gen <br> Price: 10.00 </h4>
<input type="checkbox" name="cpu0" value="10.00" >
<br>
<br>

<image src="http://media.bestofmicro.com/E/W/500792/gallery/Broadwell-CPU_w_500.jpg" height=150px width=150px>
<h4>Name: Intel Core I7 <br> Price: 20.00 </h4>
<input type="checkbox" name="cpu1" value="20.00">
<br>
<br>


<image src="https://images.anandtech.com/doci/9877/intel_xeon_lga.jpg" height=150px width=150px>
<h4>Name: Xeon Processor <br> Price: 30.00 </h4>
<input type="checkbox" name="cpu2" value="30.00">
<br>
<br>

<image src="https://images.idgesg.net/images/article/2017/05/intel-core-i9-extreme-edition-100724074-orig.jpg" height=150px width=150px>
<h4>Name: Intel Core i9 <br> Price: 40.00 </h4>
<input type="checkbox" name="cpu3" value="40.00">
<br>
<br>

<image src="https://img12.deviantart.net/bd34/i/2005/177/5/f/intel_inside_pentium_4_by_sirred.jpg" height=150px width=150px>
<h4>Name: Intel Pentium 4 <br> Price: 50.00 </h4>
<input type="checkbox" name="cpu4" value="50.00">
<br>
<br>

<image src="https://www.bhphotovideo.com/images/images1500x1500/intel_bx80677g4600_pentium_g4600_3_6_ghz_1304307.jpg" height=150px width=150px>
<h4>Name: Intel Pentium 3 <br> Price: 60.00 </h4>
<input type="checkbox" name="cpu5" value="60.00">
<br>
<br>

<image src="https://www.servethehome.com/wp-content/uploads/2017/02/AMD-Ryzen-7-Box.jpg" height=150px width=150px>
<h4>Name:Amd Ryzen7 <br> Price: 70.00 </h4>
<input type="checkbox" name="cpu6" value="70.00">
<br>
<br>

<image src="https://static.teknoblog.com/wp-content/uploads/2017/03/amd-ryzen-5-170317.png" height=150px width=150px>
<h4>Name:Amd Ryzen5 <br> Price: 80.00 </h4>
<input type="checkbox" name="cpu7" value="80.00">
<br>
<br>

<image src="https://static2.teknoblog.com/wp-content/uploads/2017/07/amd-ryzen-3-280717.jpg" height=150px width=150px>
<h4>Name: Amd Ryzen3 <br> Price: 90.00 </h4>
<input type="checkbox" name="cpu8" value="90.00">
<br>
<br>

<image src="https://www.evetech.co.za/repository/ProductImages/amd-ryzen-threadripper-cpu-1000px-v1-0003.jpg" height=150px width=150px>
<h4>Name: Amd Ryzen ThreadRipper <br> Price: 100.00 </h4>
<input type="checkbox" name="cpu9" value="100.00">
<br>
<br>


<input type="submit" name="btnsubmit" value="CHECKOUT">
</form> 

</html>
<body>

