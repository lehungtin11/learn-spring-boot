<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Add Todo Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
		<h1>Add Todo</h1>
		<form:form method="post" modelAttribute="todo">
			<label for="description">Description:</label>
			<form:input type="text" name="description" path="description"/>
			<form:errors path="description"/>
			<form:input type="hidden" name="id" path="id"/>
			<form:input type="hidden" name="targetDate" path="targetDate"/>
			<form:input type="hidden" name="done" path="done"/>
			<input type="submit" />
		</form:form>
	</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>