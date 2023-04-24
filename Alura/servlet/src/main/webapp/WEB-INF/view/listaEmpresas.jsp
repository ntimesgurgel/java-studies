<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Java Standard TagLib</title>
</head>
<body>

	Usuario Logado: ${usuarioLogado.login }

	<c:import url="logoutParcial.jsp" />
	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso!
	</c:if>
		
	<a href="/gerenciador/entrada?acao=RedirecionarNovaEmpresa">Adicionar nova empresa</a><br/>
		
	Lista de empresas: <br/>
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/entrada?acao=AtualizaEmpresa&id=${empresa.id }">edit</a>
				<a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id }">remove</a> 
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>