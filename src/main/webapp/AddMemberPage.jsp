<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<script type="text/javascript" src="js/Validate.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
<style>
.header img {
	float: left;
	width: 300px;
	height: 100px;
	background: #555;
}


.container {
  position: absolute;
  z-index: 15;
  top: 30%;
  left: 30%;
  margin: -100px 0 0 -150px;
  padding-top:90px;
}



</style>

<title>Add a member</title>
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
					<form name="AddMemberForm" action="addMember.do" method="post">
						<table>
							<th>Add member page</th>
							<tr>
								<c:if test="${!empty list}">
									<td>Select the group</td>
									<td>:</td>
									<td><div class="form-group">
										<div class="cols-sm-10">
											<div class="input-group" style="padding-left: 50px"><select name="groups">
											<c:forEach items="${list}" var="group">
												<option value="${group.groupId}" name="group" id="group">
													${group.groupName}</option>
											</c:forEach>
								</c:if>
								</td>
							</tr>
							<tr>
								<td>First Name</td>
								<td>:</td>
								<td><div class="form-group">
										<div class="cols-sm-10">
											<div class="input-group" style="padding-left: 50px">
												<span class="input-group-addon"><i
													class="fa fa-user fa" aria-hidden="true"></i></span> <input
													type="text" class="form-control" name="firstname" id="name"
													placeholder="Enter your First Name" style="width: 90%" />
											</div>
										</div>
									</div></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td>:</td>
								<td>

									<div class="form-group">
										<div class="cols-sm-10">
											<div class="input-group" style="padding-left: 50px">
												<span class="input-group-addon"><i
													class="fa fa-user fa" aria-hidden="true"></i></span> <input
													type="text" class="form-control" name="lastname" id="name"
													placeholder="Enter your First Name" style="width: 90%" />
											</div>
										</div>
									</div>


								</td>
							</tr>
							<tr>
								<td>Email</td>
								<td>:</td>
								<td>

									<div class="form-group">
										<div class="cols-sm-10">
											<div class="input-group" style="padding-left: 50px">
												<span class="input-group-addon"><i
													class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
													type="text" required onchange="email_validate(this.value);" class="form-control" name="email" id="email"
													placeholder="Enter your Email" style="width: 90%" />
											<div class="status" id="status"></div>
											</div>
										</div>
									</div>



								</td>
							</tr>
							<tr>
								<td>Mobile No</td>
								<td>:</td>
								<td>
									<div class="form-group">
										<div class="cols-sm-10">
											<div class="input-group" style="padding-left: 50px">
												<span class="input-group-addon"><i
													class="fa fa-user fa" aria-hidden="true"></i></span> <input
													type="text" class="form-control" name="mobNo" id="mobNo"
													placeholder="Enter your First Name" style="width: 90%" />
											</div>
										</div>
									</div>



								</td>
							</tr>
							<tr>
								<td><input type="submit" name="addMember" id="addMember"
									value="Add" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>