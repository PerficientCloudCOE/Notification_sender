<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
.header img {
	float: left;
	width: 300px;
	height: 100px;
	background: #555;
}

.container {
	position: absolute;
	width: 70%;
	height: 40%;
	z-index: 15;
	top: 30%;
	left: 30%;
	margin: -100px 0 0 -150px;
}


</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images\A.jpg">

	<div class="header">
		<img src="images\Perficient logo.jpg" alt="logo" />
	</div>

	<div></div>

	<div class="container" style="padding-top: 60px">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Sign In</div>
					<div
						style="float: right; font-size: 80%; position: relative; top: -10px">
						<a href="#">Forgot password?</a>
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form id="loginform" method="POST" action="login.do"
						class="form-horizontal" role="form">

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="txtUserName" value=""
								placeholder="username or email" />
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="txtPassword"
								placeholder="password" />
						</div>



						<div class="input-group">
							<div class="checkbox">
								<label> <input id="login-remember" type="checkbox"
									name="remember" value="1" /> Remember me
								</label>
							</div>
						</div>


						<div style="margin-top: 10px" class="form-group">
							<div class="col-sm-12 controls">
								<button id="btn-login" value="submit" class="btn btn-success"
									style="width: 30%">Login</button>

								<a href="Register.html">Register</a>

							</div>
						</div>

					</form>
				</div>
			</div>
		</div>

	</div>


	<!-- <div class="footer">
		<img src="images\footer.jpg" alt="logo" />
	</div> -->

</body>
</html>