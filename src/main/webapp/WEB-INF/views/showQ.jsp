<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
.cards {
		display: flex;
		flex-wrap: wrap;
		gap: 1rem;
		padding-top: 1.5rem;
}

.card {
		display: flex;
		flex-direction: column;
		width: 100%;
		overflow: hidden;
}
</style>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div class="container pt-4">
		<h1>Questions</h1>
		<p>Answers All Question.</p>
		<form action="/SpringMultipleChoice/result" method="post">
			<div class="cards">
				<c:forEach items="${question}" var="q">
					<div class="card">
						<div class="card-body">
							<label style="float: right; margin-left: 20px;">${q.mark } Mark</label>
							<p>${q.question}</p>
							<input type="hidden" name="questionId" value="${q.id}" /> <input
								type="hidden" name="examId" value="${q.examid}" />

							<c:forEach items="${q.answer}" var="ans">
								<input type="radio" name="question_${q.id}" value="${ans.id}"
									class="mx-4" />
								<label> ${ans.answer }</label>
								<br>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
			<br> <br> <input type="submit" value="submit"
				class="btn btn-primary" /><br><br>
		</form>
		<p>...</p>
	</div>
</body>
</html>