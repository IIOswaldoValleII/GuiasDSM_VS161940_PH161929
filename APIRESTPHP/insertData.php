<?php

include ('db_function.php');
$response = array();
 
//Getting post data 
$name = $_REQUEST['name'];
$age = $_REQUEST['age'];
$mobile = $_REQUEST['mobile'];
$email = $_REQUEST['email'];

if (isset($_REQUEST['name']) && isset($_REQUEST['age']) && isset($_REQUEST['mobile']) && isset($_REQUEST['email'])){
 
	$result=insertData($name,$age,$mobile,$email);
	if ($result) {
        $response["success"] = 1;
        $response["message"] = "Successfully saved"; 
        echo json_encode($response);
    } 
	else {
        $response["success"] = 0;
        $response["message"] = "Oops! An error occurred."; 
        echo json_encode($response);
    }
	
} 
else {
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";  
    echo json_encode($response);
}

/*include 'db_config.php';
$name = $_POST['nombre'];
$age = $_POST['edad'];
$mobile = $_POST['telefono'];
$email = $_POST['email'];

$consulta = "insert into personal values('".$name."','".$age."','".$mobile."','".$email."')";
mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);*/
?>