<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifpr.irati.model.Professor"%>
<%@page import="br.edu.ifpr.irati.model.Aluno"%>
<%@page import="br.edu.ifpr.irati.model.Disciplina"%>
<%
Professor professor = (Professor) session.getAttribute("professor");
if (professor == null){
    professor = new Professor();
}
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edição de Professor</title>
    <%@ include file="header.jsp"%>
</head>
<body>
    <%if (professor.getId() == 0){%>
      <form action="professor/salvar" method="post">
    <%} else {%>
      <form action="professor/editar" method="post">
    <%}%>
        <div class="row">
            <div class="col s1"></div>
            <div class="col s10">
                <div class="row">
                    <div class="input-field col s8">
                        <input id="id" name="id" type="hidden" value=<%=professor.getId()%>>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s8">
                        <input id="nome" name="nome" type="text" class="validate" value="<%=professor.getNome()%>" required>
                        <label for="nome">Nome</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s8">
                        <input id="email" type="email" name="email" class="validate" value="<%=professor.getEmail()%>" required>
                        <label for="email">E-mail</label>
                    </div>
                </div>
                <div class="row">
                    <div class="switch col s5">
                        <label>
                            Não
                            <input type="checkbox" name="ativo" <%=professor.isAtivo()?"checked":""%>>
                            <span class="lever"></span>
                            Sim
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s8">
                        <input id="senha" type="password" name="senha" class="validate" value="<%=professor.getSenha()%>" required>
                        <label for="senha">Senha</label>
                    </div>
                </div>
                <div class="row">
                    <button class="btn waves-effect waves-light col s2" type="submit" name="action">Salvar
                    </button>
                    <a class="waves-effect waves-effect btn red col s2" href="professores.jsp">Cancelar</a>
                </div>

            </div>
        </div>
    </form>

    <%@ include file="footer.jsp" %>
</body>
</body>
</html>