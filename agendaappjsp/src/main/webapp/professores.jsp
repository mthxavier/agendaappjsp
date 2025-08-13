<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifpr.irati.model.Professor"%>
<%@page import="br.edu.ifpr.irati.model.Aluno"%>
<%@page import="br.edu.ifpr.irati.model.Disciplina"%>
<%@page import="br.edu.ifpr.irati.service.ProfessorService"%>

<%
List<Professor> professores = (List<Professor>) session.getAttribute("professores");
if (professores == null){
    response.sendRedirect("login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Listagem de Professores</title>
    <%@ include file="header.jsp"%>
</head>
<body>

    <div class="row">
        <div class="col s1"></div>
        <div class="col s10">
            <table class="striped centered responsive-table">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Ativo</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%for (Professor p: professores){%>
                <tr>
                    <td><%=p.getNome()%></td>
                    <td><%=p.getEmail()%></td>
                    <td><%=p.getStatus()%></td>
                    <td>
                        <a class="waves-effect waves-light btn blue" href="professor/listar?id=<%=p.getId()%>"><i class="material-icons center" title="Editar">create</i></a>
                        <a class="waves-effect waves-light btn red" href="professor/excluir?id=<%=p.getId()%>"><i class="material-icons center" title="Excluir">delete</i></a>
                    </td>
                </tr>
                <%}%>
            </tbody>
            </table>
        </div>
    </div>
    <div class="row">
    <div class="col s10">
        <a class="waves-effect waves-light btn green" title="Voltar para Index" href="index.jsp"><i
                class="material-icons left">home</i> Index</a>
    </div>
    <div class="col s2">
        <a class="waves-effect waves-light btn green" title="Novo Professor" href="professor.jsp"><i
                class="material-icons left">person</i> Novo</a>
        <div>
        </div>

    <%@ include file="footer.jsp" %>
</body>
</body>
</html>