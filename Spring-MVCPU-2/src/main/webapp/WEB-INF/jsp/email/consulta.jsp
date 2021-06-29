<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Consulta</title>
</head>
<body>

	<div class="container">
		<h1>Consulta de Disciplinas</h1>
		<form method="get" action="/email/procura">
			<input type="text" name="keyword"> <input type="submit"
				name="procura">
		</form>
		<h3>
			<a href="/email/cadastro">Nova Disciplina</a>
		</h3>
	</div>

	<table class="table">
		<thead>
			<th>Email</th>
			<th>Id Aluno</th>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="atributo">
				<tr>
					<td>${atributo.mail}</td>
					<td>${atributo.aluno.id}</td>
					<td><a href="/email/alterar?id=${atributo.id}">Alterar</a>
						&nbsp;&nbsp; <a href="/email/excluir?id=${atributo.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>