<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<h1>Add Todo</h1>
	<form:form method="post" modelAttribute="todo">
		<form:input type="hidden" name="id" path="id" />
		<form:input type="hidden" name="done" path="done" />
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate">Target Date</form:label>
			<form:input type="text" path="targetDate" required="required"
				id="targetDate" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<input type="submit" />
	</form:form>
</div>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
<%@include file="common/footer.jspf"%>