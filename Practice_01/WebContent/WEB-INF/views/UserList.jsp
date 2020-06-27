<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="<%=cp %>/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp %>/js/bootstrap.min.js"></script>

</head>
<body>

<div>
	<h1>UserList.jsp</h1>
	<hr />
</div>

<div>
	<table class="table">
		<tr>
			<th>No.</th>
			<th>Name</th>
			<th>Age</th>
			<th>Job</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<c:forEach var="user" items="${userList }">
		<tr>
			<td>${user.userId }</td>
			<td>${user.userName }</td>
			<td>${user.userAge }</td>
			<td>${user.jobName }</td>
			<td><input type="button" value="Delete" class="btn btn-default"></td>
			<td><input type="button" value="Update" class="btn btn-default"></td>
		</tr>
		</c:forEach>
		
	</table>
</div>

<div>
	<input type="button" value="Add" class="btn btn-default">
	
</div>

</body>
</html>