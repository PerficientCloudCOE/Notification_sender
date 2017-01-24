<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select the group</title>
</head>
<body>
${msg.msg}
<form action="createMsg.do" method="post">
<table>
<c:set var="list" value="${msg.listGroups}" scope="session" />
<a href="AddMemberPage.jsp">Add member</a>
<th>Select the recipient groups</th>
<c:if test="${!empty msg.listGroups}">
<div>
<c:forEach items="${msg.listGroups}" var="group">
<tr>
<td><input type="checkbox" value="${group.groupName}" name="groupChBox" id="${group.groupName}"/>${group.groupName}</td>
</tr>
</c:forEach>
</div>
</c:if>
<tr></br>
<td><input type="submit" value="Create Message" name="CrMsgBtn"/></td>
</tr>
</table>
</form>
</body>
</html>