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
		<h1>Consulta de Alunos</h1>
		<form method="get" action="procura">
			<input type="text" name="keyword"> <input type="submit"
				name="procura">
		</form>
		<h3>
			<a href="cadastro">Novo Aluno</a>
		</h3>
	</div>

	<table class="table">
		<thead>
			<th>Nome</th>
			<th>Telefone</th>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="atributo">
				<tr>
					<td>${atributo.nome}</td>
					<td>${atributo.telefone}</td>
					<td><a href="alterar?id=${atributo.id}">Alterar</a>
						&nbsp;&nbsp; <a href="excluir?id=${atributo.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>