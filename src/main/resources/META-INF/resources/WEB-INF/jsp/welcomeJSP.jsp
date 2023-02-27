<html>
	<head>
	<%@ include file="common/header.jspf" %>
		<title>Welcome Page</title>
	</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
			<h2>Welcome ${name}</h2>
		<hr>
		<div><h4><a href="todo">Manage</a> your todos</h4></div>
	</div>
	<%@ include file="common/footer.jspf" %>
</body>
</html>