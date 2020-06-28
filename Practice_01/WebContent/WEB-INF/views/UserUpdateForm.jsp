<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=cp%>/css/bootstrap.min.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function()
	{
		
		$(".btnSubmit").click(function()
		{
			
			
			$("#userUpdate").submit();
		});
		
	});
	
</script>
</head>
<body>
	<div>
		<h1>UserAddForm.jsp</h1>
		<hr />
	</div>

	<div></div>



	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">

						<form action="userupdate.action" method="post" id="userUpdate">
						ID : <input type="text" class="form-control" name="userId" value="${user.userId }" readonly="readonly"><br>
						이름 : <input type="text" class="form-control" name="userName" value="${user.userName }"><br>
						생년월일: <input type="text" class="form-control" name="userBirth" value="${user.userBirth }"><br>
						<select name="jobId" id="jobId" class="form-control">
							<c:forEach var="job" items="${jobList}">
								<option value="${job.jobId }">${job.jobName }</option>
							</c:forEach>
						</select>
						
						<button type="button" class="btn btn-lg btn-info btnSubmit">Button</button>
						</form>
						
					</div>
				</div>
				
			</div>
		</div>
	</div>


</body>
</html>