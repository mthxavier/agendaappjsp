<%@ page import="br.edu.ifpr.irati.model.Disciplina" %>
<%@ page import="br.edu.ifpr.irati.model.Professor" %>
<%
  Disciplina disciplina = (Disciplina) session.getAttribute("disciplina");
  if (disciplina == null) {
    disciplina = new Disciplina();
  }
  Object log = session.getAttribute("usuarioLogado");
  Professor professor = (Professor) log;
%>

<!doctype html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Criação de Disciplina</title>
  <%@include file="header.jsp" %>
</head>
<body>
<%if (disciplina.getId() == 0) {%>
<form action="disciplina/salvar" method="post">
    <%}else{%>
  <form action="disciplina/editar" method="post">
    <%}%>
    <div class="row">
      <div class="col s1"></div>
      <div class="col s10">
        <div class="row">
          <div class="input-field col s8">
            <input id="id" name="id" type="hidden" value=<%=disciplina.getId()%>>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s8">
            <input id="nome" name="nome" type="text" class="validate" value=<%=disciplina.getNome()%>>
            <label for="nome">Nome</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s8">
            <input id="chave" type="text" name="chave" class="validate" value=<%=disciplina.getChave()%>>
            <label for="chave">Chave</label>
          </div>
        </div>
        <div class="row">
          <button class="btn waves-effect waves-light col s2" type="submit" name="action">Salvar
          </button>
          <a class="waves-effect waves-effect btn red col s2">Cancelar</a>
        </div>

      </div>
    </div>
  </form>

  <%@ include file="footer.jsp" %>
</body>
</html>