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
<script type="text/javascript">
	
	

</script>
</head>
<body>
<div>
	<h1>UserAddForm.jsp</h1>
	<hr />
</div>

<div>
	<select name="jobId" id="jobId" class="form-control">
		<c:forEach var="job" items="jobList">
			 <option value="${job.jobId }">${job.jobName }</option> 
			
		</c:forEach>
	</select>
</div>
</body>
</html>