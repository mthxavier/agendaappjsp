<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifpr.irati.model.Professor"%>
<%@page import="br.edu.ifpr.irati.model.Disciplina"%>
<%@page import="br.edu.ifpr.irati.model.Aluno"%>

<%
Object log = session.getAttribute("usuarioLogado");
String nome = "";
String email = "";
String tipo = "";
List<Disciplina> disciplinas = new ArrayList<>();
if (log instanceof Professor){
    Professor logado = (Professor) log;
    nome = logado.getNome();
    email = logado.getEmail();
    disciplinas = new ArrayList(logado.getDisciplinas());
    tipo = "professor";
}else if (log instanceof Aluno){
    Aluno logado = (Aluno) log;
    nome = logado.getNome();
    email = logado.getEmail();
    disciplinas = new ArrayList(logado.getDisciplinas());
    tipo = "aluno";
}

if (log != null){
%>
<ul id="slide-out" class="sidenav">
    <li>
        <div class="user-view">
            <div class="background">
                <img src="assets/imagens/sala.png">
            </div>
            <span class="white-text name"><%=nome%> (<%=tipo%>)</span>
            <span class="white-text email"><%=email%></span>
        </div>
    </li>
    <li>
        <a href="#!"><i class="material-icons">account_circle</i>Alterar Cadastro</a>
    </li>
    <li>
    <%if (tipo.equals("professor")){%>
        <a href="disciplina/listar"><i class="material-icons">add_circle</i>Criar curso</a>
    <%}else{%>
        <a href="entrarcurso.jsp"><i class="material-icons">add_circle</i>Entrar em um curso</a>
    <%}%>
    </li>
    <li>
        <div class="divider"></div>
    </li>
    <li>
        <a class="subheader">Meus Cursos</a>
    </li>
    <%
    for (Disciplina disciplina: disciplinas){%>
    <li>
        <a href="#!"><%=disciplina.getNome()%></a>
    </li>
    <%}
    %>
    <li>
        <a class="waves-effect" href="index.jsp">Sair</a>
    </li>
  </ul>
  <a href="#" data-target="slide-out" class="sidenav-trigger"><i class="material-icons">menu</i></a>
<%}%>