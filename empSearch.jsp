<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee UI</title>
<link rel="stylesheet" type="text/css" href="/resources/css/basestyle.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#empgetform').submit(function(event){
			event.preventDefault();
			var empIdData = document.getElementById('empId1').value;
			var searchradio = $('input[name=search]:checked').val();
			alert("value of radio button"+empIdData +searchradio);
			$.ajax({
				 // url:"http://localhost:8888/SpringMongoREST/Employees/"+empIdData,
				  url:"${home}getEmployee/"+empIdData,
				  type:"GET",
				  success:function(data,status){					
						 alert("ok"+status);
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
	<h3>Search employee Details :</h3>
<div id="SearchDiv">
		<form id="empgetform">
		    Select Search type:<input type="radio" name="search" value="Id" checked> EmpID
  <input type="radio" name="search" value="name"> Emp Name
  <input type="radio" name="search" value="dept"> Emp Department  <br><br>
			Enter Employee Detail:<input type="text" id="empId1" required><br><br>
		    <input type="submit" id="submit" value="GO"><br><br>
		</form>
	</div>
	
	<div id="tablediv">
</div>
</div>
<div id="Portalfooter"></div>
</body>
</html>