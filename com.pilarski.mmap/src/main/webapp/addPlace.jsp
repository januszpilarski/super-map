<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="pl">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Create a place</title>

<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

</head>

<body>

	<div class="container">

		<form:form method="POST" modelAttribute="placeForm"
			class="form-signin">
			<h2 class="form-signin-heading">Create place</h2>
			<spring:bind path="name">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="name" class="form-control"
						placeholder="name" autofocus="true"></form:input>
					<form:errors path="name"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="coordinateX">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="coordinateX" path="coordinateX"
						class="form-control" placeholder="coordinateX"></form:input>
					<form:errors path="coordinateX"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="coordinateY">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="coordinateY" path="coordinateY"
						class="form-control" placeholder="coordinateY"></form:input>
					<form:errors path="coordinateY"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="placeCategory">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:select path="placeCategory" class="form-control">
						<form:option value="NONE" label="Category" />
						<form:options items="${com.pilarski.mmap.domain.PlaceCategory.values()}" />
					</form:select>
					<form:errors path="placeCategory"></form:errors>
				</div>
			</spring:bind>
			
			<spring:bind path="description">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="description" path="description"
						class="form-control" placeholder="description"></form:input>
					<form:errors path="description"></form:errors>
				</div>
			</spring:bind>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>