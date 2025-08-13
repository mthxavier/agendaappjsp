<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifpr.irati.model.Professor"%>
<%@page import="br.edu.ifpr.irati.model.Aluno"%>
<%@page import="br.edu.ifpr.irati.model.Disciplina"%>

<%
Object userLog = session.getAttribute("usuarioLogado");
List<Disciplina> disciplinasGrid = new ArrayList<>();
if (userLog instanceof Professor){
    disciplinasGrid = new ArrayList(((Professor) userLog).getDisciplinas());
}else if (userLog instanceof Aluno){
    disciplinasGrid = new ArrayList(((Aluno) userLog).getDisciplinas());
}
if (userLog == null){
    response.sendRedirect("login.jsp");
}
%>
<div class="row">
    <div class="col s1"></div>
    <div class="col s10">
        <div class="row">
            <div class="col s12">
                <%int i = 0;
                  for (Disciplina disciplina: disciplinasGrid){%>
                  <div class="card col s4">
                    <div class="card-image">
                      <img src="assets/imagens/backgrounds/bg<%=i%4+1%>.png">
                      <span class="card-title center"><%=disciplina.getNome()%></span>
                    </div>
                    <div class="card-content">
                      <p> <%=disciplina.getAlunos().size()%> alunos inscritos </p>
                    </div>
                    <div class="card-action">
                      <a href="#">Acessar</a>
                    </div>
                  </div>
                <%i++;
                }%>
            </div>
        </div>
    </div>
</div>