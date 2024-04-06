<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>
<title>Todos Page</title>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>
	<div class="container">
		<h1>Your Todos</h1>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.name}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add New</a>
	</div>
<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>