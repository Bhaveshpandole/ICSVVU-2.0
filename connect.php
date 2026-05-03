<?php
$studentName = $_Post['studentName'];
$class = $_Post['class'];
$title = $_Post['title'];
$punchline = $_Post['punchline'];
$objective = $_Post['objective'];
$utility = $_Post['utility'];
$methodology = $_Post['methodology'];
$novelty = $_Post['novelty'];
$department = $_Post['department'];
$area = $_Post['area'];
$brief = $_Post['brief'];

//Database Connection

$conn = new mysqli('localhost','root','','startup');
if($conn->connect_error){
    die('connection Failed : '.$conn->connect_error);
}else{
    $stmt = $conn->prepare("INSTERT INTO startup form(studentName, class, title, punchline, objective, utility, methodology, novelty, department, area, brief)
    values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("sssssssssss",$studentName, $class, $title, $punchline, $objective, $utility, $methodology, $novelty, $department, $area, $brief);
    $stmt->execute();
    echo "form has been submitted...";
    $stmt->close();
    $conn->close();
}
?>