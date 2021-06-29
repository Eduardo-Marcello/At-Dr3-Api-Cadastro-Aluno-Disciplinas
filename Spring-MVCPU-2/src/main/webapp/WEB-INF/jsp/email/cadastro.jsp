<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- <link href="<c:url value="../resources/styles/style.css" />" rel="stylesheet">  -->

<title>Cadastro</title>
</head>
<body>
	<div class="container">
		<div class="col-md-6 cadastro">
			<h1>Cadastro de Email</h1>
			<div>
			
				<form action="/email/cadastrar" method="post">
					<div class="form-group">
						<label>Email:</label> 
						<input type="mail" name="mail" id="mail" class="form-control" required="">
					</div>
					
					<div class="form-group">
						<label>Aluno:</label> 
						<select name="aluno.id" class="form-control">
							<c:forEach var="a" items="${alunos}">
								<option value="${a.id}">${a.nomeAluno}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="form-group">
						<input type="submit" id="submit" class="btn-primary"
							value="Cadastrar">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>