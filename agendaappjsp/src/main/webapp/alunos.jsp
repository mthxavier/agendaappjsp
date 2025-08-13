<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifpr.irati.model.Aluno" %><%
    List<Aluno> alunos = (List<Aluno>) session.getAttribute("alunos");
    if(alunos == null){
        response.sendRedirect("login.jsp");
    }
%>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listagem de Alunos</title>
    <%@include file="header.jsp"%>
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
            </tr>
            </thead>
            <tbody>
            <%for (Aluno a: alunos){%>
            <tr>
                <td><%=a.getNome()%></td>
                <td><%=a.getEmail()%></td>
                <td>
                    <a class="waves-effect waves-light btn blue" href="aluno/listar?id=<%=a.getId()%>"><i class="material-icons center" title="Editar">create</i></a>
                    <a class="waves-effect waves-light btn red" href="aluno/excluir?id=<%=a.getId()%>"><i class="material-icons center" title="Excluir">delete</i></a>
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
        <a class="waves-effect waves-light btn green" title="Novo Aluno" href="aluno.jsp"><i
                class="material-icons left">person</i> Novo</a>
        <div>
        </div>

        <%@ include file="footer.jsp" %>
</body>
</html>