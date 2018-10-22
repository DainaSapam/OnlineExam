<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="./icon.png" type="image/x-icon">
<!-- Bootstrap core CSS-->
<link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="./vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="./vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="./css/sb-admin.css" rel="stylesheet">
<title>Add Question</title>
</head>
<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="index.html">Start Bootstrap</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
					class="badge badge-danger">9+</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="alertsDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
					class="badge badge-danger">7</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="messagesDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a> <a
						class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="Dashboard.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i>
					<span>Dashboard</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-folder"></i> <span>Pages</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Add Questions:</h6>
					<a class="dropdown-item" href="Login.html">Login</a> <a
						class="dropdown-item" href="register.html">Register</a> <a
						class="dropdown-item" href="forgot-password.html">Forgot
						Password</a>
					<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">Other Pages:</h6>
					<a class="dropdown-item" href="404.html">404 Page</a> <a
						class="dropdown-item" href="blank.html">Blank Page</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="charts.html">
					<i class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="question.jsp">
					<i class="fas fa-fw fa fa-file"></i> <span>Add Questions</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="AddStudent.jsp">
					<i class="fas fa-fw fa fa-file"></i> <span>Add Students</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="AddCourse.jsp">
					<i class="fas fa-fw fa fa-file"></i> <span>Add Course</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="tables.html">
					<i class="fas fa-fw fa-table"></i> <span>Tables</span>
			</a></li>
		</ul>
		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="Dashboard.jsp">Dashboard</a></li>
					<li class="breadcrumb-item active">Add Questions</li>
				</ol>

				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa fa-file"></i> Add Questions here
					</div>
					<div class="card-body">
						<form action="" id="questionForm" class=" form-horizontal">
							<div class="form-group">
								<label for="question" class="col-sm-4 control-label">Question:</label>
								<div class="col-sm-5">
									<textarea rows="5" cols="5" class="form-control required-icon" name="question" id="question" placeholder="Type your question here"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label for="opt1" class="col-sm-4 control-label">Option
									1:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control required-icon"
										name="opt1" id="opt1" placeholder="option 1">
								</div>
							</div>
							<div class="form-group">
								<label for="opt2" class="col-sm-4 control-label">Option
									2:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control required-icon"
										name="opt2" id="opt2" placeholder="option 2">
								</div>
							</div>
							<div class="form-group">
								<label for="opt3" class="col-sm-4 control-label">Option
									3:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control required-icon"
										name="opt3" id="opt3" placeholder="option 3">
								</div>
							</div>
							<div class="form-group">
								<label for="opt4" class="col-sm-4 control-label">Option
									4:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control required-icon"
										name="opt4" id="opt4" placeholder="option 4">
								</div>
							</div>
							<div class="form-group">
								<label for="answer" class="col-sm-4 control-label">Correct
									Answer:</label>
								<div class="col-sm-4">
									<input type="text" class="form-control required-icon"
										name="answer" id="answer" placeholder="correct answer">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-3">
									<button type="submit" class="btn btn-primary" id="save"
										value="Submit">Save</button>
									<button type="reset" class="btn btn-primary" value="Reset">Reset</button>
								</div>
							</div>
						</form>
						<div id="message"></div>
					</div>
				</div>


				<!-- /.container-fluid -->

				<!-- Sticky Footer -->
				<footer class="sticky-footer">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright SSKVK © 2018, Imphal, Manipur</span>
						</div>
					</div>
				</footer>

			</div>
			<!-- /.content-wrapper -->

		</div>
	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="AdminLogin.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="vendor/chart.js/Chart.min.js"></script>
	<script src="vendor/datatables/jquery.dataTables.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="./javascripts/sb-admin.js"></script>
	<script src="./javascripts/question.js"></script>

	<!-- Demo scripts for this page-->
	<script src="./javascripts/demo/datatables-demo.js"></script>
	<script src="js/demo/chart-area-demo.js"></script>
</body>
</html>