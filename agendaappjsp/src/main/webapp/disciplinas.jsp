<%@ page import="br.edu.ifpr.irati.model.Disciplina" %>
<%@ page import="java.util.List" %>
<%
    List<Disciplina> disciplinas = (List<Disciplina>) session.getAttribute("disciplinas");
    if (disciplinas == null) {
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
    <title>Listagem de Disciplinas</title>
    <%@include file="header.jsp" %>
</head>
<body>
<div class="row">
    <div class="col s1"></div>
    <div class="col s10">
        <table class="striped centered responsive-table">
            <thead>
            <tr>
                <th>Nome</th>
                <th>Chave</th>
            </tr>
            </thead>
            <tbody>
            <%for (Disciplina d : disciplinas) {%>
            <tr>
                <td><%=d.getNome()%>
                </td>
                <td><%=d.getChave()%>
                </td>
                <td>
                    <a class="waves-effect waves-light btn blue" href="disciplina/listar?id=<%=d.getId()%>"><i
                            class="material-icons center" title="Editar">create</i></a>
                    <a class="waves-effect waves-light btn red" href="disciplina/excluir?id=<%=d.getId()%>"><i
                            class="material-icons center" title="Excluir">delete</i></a>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col s10">
        <a class="waves-effect waves-light btn green" title="Voltar para Home" href="home.jsp"><i
                class="material-icons left">home</i> Home</a>
    </div>
    <div class="col s2">
        <a class="waves-effect waves-light btn green" title="Nova Disciplina" href="disciplina.jsp"><i
                class="material-icons left">class</i> Nova</a>
    <div>
</div>

        <%@ include file="footer.jsp" %>
</body>
</html>