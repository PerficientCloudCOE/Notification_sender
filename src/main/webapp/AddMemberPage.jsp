<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a member</title>
</head>
<body>
	<form name="AddMemberForm" action="addMember.do" method="post">
		<table>
			<th>Add member page</th>
			<tr>
				<c:if test="${!empty list}">
					<td>Select the group</td>
					<td>:</td>
					<td><select name="groups">
							<c:forEach items="${list}" var="group">
								<option value="${group.groupId}" name="group" id="group">
									${group.groupName}</option>

							</c:forEach>
					</select></td>
				</c:if>
			</tr>
			<tr>
				<td>First Name</td>
				<td>:</td>
				<td><input type="text" name="firstname" id="name" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>:</td>
				<td><input type="text" name="lastname" id="name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td>Mobile No</td>
				<td>:</td>
				<td><input type="text" name="mobNo" id="mobNo" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="addMember" id="addMember"
					value="Add" /></td>
			</tr>
		</table>
	</form>
</body>
</html>