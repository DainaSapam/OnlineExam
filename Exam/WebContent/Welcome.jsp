<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.exam.DBConnect.DBConnect"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="./css/stylesheet.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link rel="icon" href="./icon.png" type="image/x-icon">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	
</script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<title>Welcome</title>
</head>
<body id="myPage" onload="startTimer()" data-spy="scroll"
	data-target=".navbar" data-offset="50">

	<script type="text/javascript">
		
	</script>

	<%
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate");//HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxie 

		if (session.getAttribute("name") == null) {
			response.sendRedirect("Login.html");
		}
	%>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--<a class="navbar-brand" href="#myPage">Logo</a>-->
				<img src="./logo.jpg" width="100" height="50">
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">SSKVK Singjamei</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<br>
		<h1 class="text-center">Field Technician Computing And Peripheral</h1>


		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-4 text-left">
						Welcome, <b><%=session.getAttribute("name")%></b>
					</div>
					<div class="col-xs-4 text-center" id="time"></div>
					<div class="col-xs-4 text-right">
						<a class="btn btn-primary" href="./Logout">Logout</a>
					</div>
				</div>
			</div>
			<div class="panel-body">
				<span style="color: blue" id="qNo"></span><br>
				<p id="question">
				</p>
				<input id="answer" type="hidden">
				<input id="questionID" type="hidden">
				
					<div class="radio">
						<label id="opt1"></label>
					</div>
					<div class="radio">
						<label id="opt2"></label>
					</div>
					<div class="radio">
						<label id="opt3"></label>
					</div>
					<div class="radio">
						<label id="opt4"></label>
					</div>
				
				<br> <br>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="col-xs-3 text-center"></div>
					<div class="col-xs-3 text-center">
						<button id="next" class="btn btn-primary" value="Submit">Next</button>
					</div>
					<div class="col-xs-3 text-center">
						<button id="prev" class="btn btn-primary" value="Submit">Previous</button>
					</div>
					<div class="col-xs-3 text-center">
						<button id="submit" class="btn btn-primary" value="Submit">Submit</button>
					</div>
				</div>
			</div>
			<%-- <%
				}

					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			%> --%>
		</div>
	</div>
	<script src="./javascripts/exam.js"></script>
	<footer class=" text-center">
		<div class="rows">
			<div class="col-sm-6">Copyright &copy; 2018, Imphal, Manipur</div>
			<div class="col-sm-6 text-right">Designed and Developed By TON
				&amp; BOI-e SOLUTION.</div>
		</div>
		<br> <br>
	</footer>
</body>
</html>