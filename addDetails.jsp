<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee UI</title>
<link rel="stylesheet" type="text/css" href="../resources/css/basestyle.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#empform').submit(function(event){
			event.preventDefault();
			var empId = document.getElementById('empId').value;
			var deptName = document.getElementById('deptName').value;
			var fname = document.getElementById('fname').value;
			var lname = document.getElementById('lname').value;
			var age = document.getElementById('age').value;
			var salary = document.getElementById('salary').value;
			var gender = document.getElementById('gender').value;
			alert("Inside submit"+empId+" Name "+fname);
			$.ajax({
				  url:"/SpringMongoREST/Employees",
				  type:"POST",
				  data:"{\"empid\":\""+empId+"\",\"fname\":\""+fname+"\",\"department\":\""+deptName+"\",\"gender\":\""+gender+"\",\"lname\":\""+lname+"\",\"age\":\""+age+"\",\"salary\":\""+salary+"\"}",
				  contentType:"application/json;",
				  success:function(data){
					alert("Employee Record inserted");
				  }
			});
		});
	});
</script>
</head>
<body>
<div id="Portalheader"><h2>Home</h2>
</div>
<br><br>
<div id="Poratalbody">
<h3>Add employees</h3>
<div id="formdiv">
		<form id="empform">
			Enter employee id:<input type="text" id="empId" required><br>
			Enter employee first name:<input type="text" id="fname" required><br>
			Enter employee last name:<input type="text" id="lname" required><br>
			Select age :<input type="text" id="age" required><br>
			Salary : <input type="text" id="salary" required><br> 
		    Department Name:<input type="text" id="deptName" required><br> 
		     Gender:<input type="text" id="gender" required><br> 
		    <input type="submit" id="submit" value="GO">
		</form>
	</div>
	<div id="tablediv">
</div>
</div>
<div id="Portalfooter"></div>
</body>
</html>