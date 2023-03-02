<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<%@ include file="common/header.jspf" %>
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
		<title>Add Todo</title>
	</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	<div class="container">
			<h2>Create New Todo here</h2>
		<hr>
		<form:form method="post" modelAttribute="todo">  <!-- modelAttribute will bind values coming from model to specific input fields i.e: description, id -->
			<fieldset class="mb-3">				
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="mb-3">				
				<form:label path="expectedDate">Target Date</form:label>
				<form:input type="text" path="expectedDate" required="required"/>
				<form:errors path="expectedDate" cssClass="text-warning"/>
			</fieldset>

		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="isDone"/>
		<br/><input type="submit" class="btn btn-success">
		</form:form>
	</div>
	<%@ include file="common/footer.jspf" %>
	<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript">
		$('#expectedDate').datepicker({
		    format: 'yyyy-mm-dd'
		});
	</script>
</body>
</html>