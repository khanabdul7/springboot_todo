<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<%@ include file="common/header.jspf" %>
		<title>TODOs</title>
	</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
	<h3>Welcome ${name}</h3>
	<hr>
	<h1>Your TODOs: </h1>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Completed ?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.expectedDate}</td>
						<td>${todo.isDone}</td>
						<td><a href="delete?id=${todo.id}" class=" btn btn-danger" >Delete</a></td>
						<td><a href="update?id=${todo.id}" class=" btn btn-success" >Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
	</div>
	<%@ include file="common/footer.jspf" %>
</body>
</html>