<%@ page import="br.edu.ifpr.irati.model.Aluno" %>
<%
    Aluno aluno = (Aluno) session.getAttribute("aluno");
    if (aluno == null) {
        aluno = new Aluno();
    }
%>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Edição de Aluno</title>
    <%@include file="header.jsp" %>
</head>
<body>
<%if (aluno.getId() == 0) {%>
<form action="aluno/salvar" method="post">
        <%}else{%>
    <form action="aluno/editar" method="post">
        <%}%>
        <div class="row">
            <div class="col s1"></div>
            <div class="col s10">
                <div class="row">
                    <div class="input-field col s8">
                        <input id="id" name="id" type="hidden" value=<%=aluno.getId()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s8">
                        <input id="nome" name="nome" type="text" class="validate" value="<%=aluno.getNome()%>" required>
                        <label for="nome">Nome</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s8">
                        <input id="email" type="email" name="email" class="validate" value="<%=aluno.getEmail()%>" required>
                        <label for="email">E-mail</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s8">
                        <input id="senha" type="password" name="senha" class="validate" value="<%=aluno.getSenha()%>" required>
                        <label for="senha">Senha</label>
                    </div>
                </div>
                <div class="row">
                    <button class="btn waves-effect waves-light col s2" type="submit" name="action">Salvar
                    </button>
                    <a class="waves-effect waves-effect btn red col s2" href="alunos.jsp">Cancelar</a>
                </div>

            </div>
        </div>
    </form>

    <%@ include file="footer.jsp" %>
</body>
</html>