<!DOCTYPE html>
<html>
<head>
<title>Exams Table</title>
<style>
table {
border-collapse: collapse;
width: 100%;
color: #588c7e;
font-family: monospace;
font-size: 25px;
text-align: left;
}
th {
background-color: #588c7e;
color: white;
}
tr:nth-child(even) {background-color: #f2f2f2}
</style>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Sesiune</th>
        <th>An de studiu</th>
        <th>Facultate</th>
        <th>Domeniu/Specializare</th>
        <th>Curs/Materie</th>
        <th>Profesor</th>
    </tr>
<?php
$conn = mysqli_connect("localhost", "sa", "password", "testdb");
// Check connection
if ($conn->connect_error) {
die("Connection failed: " . $conn->connect_error);
}
$sql = "SELECT exams_id, session, yearOfStudy, faculty, domain, course, teacher FROM exams";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
// output data of each row
while($row = $result->fetch_assoc()) {
echo
    "<tr><td>" . $row["exams_id"].
    "</td><td>" . $row["session"] .
    "</td><td>" . $row["yearOfStudy"].
    "</td><td>" . $row["faculty"].
    "</td><td>" . $row["domanin"] .
    "</td><td>" . $row["course"].
    "</td><td>" . $row["teacher"].
    "</td></tr>";
}
echo "</table>";
} else { echo "0 results"; }
$conn->close();
?>
</table>
</body>
</html>