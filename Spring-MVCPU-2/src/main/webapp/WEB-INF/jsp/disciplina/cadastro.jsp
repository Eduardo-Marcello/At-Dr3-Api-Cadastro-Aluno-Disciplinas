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
			<h1>Cadastro da Disciplina</h1>
			<div>
			
				<form action="/disciplina/cadastrar" method="POST">
					<div class="form-group">
						<label>Nome da Disciplina:</label> 
						<input type="text" name="nome" id="nome" class="form-control" required="">
					</div>
					
					<div class="form-group">
						<label>Código:</label>
						 <input type="text" name="codigo" id="codigo" class="form-control" required="">
					</div>
					
					<div class="form-group">
						<label>Aluno:</label> 
						<select name="aluno" class="form-control">
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