<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
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
  height:40%;
  z-index: 15;
  top: 30%;
  left: 30%;
  margin: -100px 0 0 -150px;
  padding-top:40px;
}



</style>
<title>Create Msg Page</title>
</head>
<body background="images\A.jpg">

<div class="header">
	<img src="images\Perficient logo.jpg" alt="logo"/>
	</div>



	<div class="container">
		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<form action="msgMerge.do" method="post">
						<table>
							<tr>
								<td>Enter the content of the Message</td>
								<td>:</td>
								<td>
									<div class="form-group">
										<div class="cols-sm-10">
											<div class="form-group">
												<textarea class="form-control" rows="5" id="txtMsg" name="txtMsg"></textarea>
											</div>
										</div>
									</div>


								</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" name="btnCreateMsg"
									value="Create Message" /></td>
								<td></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>