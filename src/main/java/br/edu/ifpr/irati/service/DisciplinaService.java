package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.*;
import br.edu.ifpr.irati.model.Aluno;
import br.edu.ifpr.irati.model.Disciplina;
import br.edu.ifpr.irati.model.Professor;
import br.edu.ifpr.irati.util.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class DisciplinaService implements Service{
    private DisciplinaDao disciplinaDAO;

    public DisciplinaService(DisciplinaDao disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
    }

    @Override
    public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            System.out.println("Chave recebida: " + req.getParameter("chave"));

            if(req.getParameter("chave") != null){
                Disciplina disciplina = disciplinaDAO.buscarPorChave(req.getParameter("chave"));
                req.getSession().setAttribute("disciplina", disciplina);

                Aluno aluno = (Aluno) req.getSession().getAttribute("usuarioLogado");
                aluno.adicionarDisciplina(disciplina);

                AlunoDAO alunoDAO = new AlunoDAO(HibernateUtil.getSessionFactory().openSession());
                alunoDAO.alterar(aluno);

                resp.sendRedirect("../home.jsp");
            }
            else if (req.getParameter("id") == null){//listar todos
                List<Disciplina> disciplinas = disciplinaDAO.buscarTodos();
                req.getSession().setAttribute("disciplinas", disciplinas);
                resp.sendRedirect("../disciplinas.jsp");
            }else{// listar por id
                Disciplina disciplina = disciplinaDAO.buscarPorId(Integer.parseInt(req.getParameter("id")));
                req.getSession().setAttribute("disciplina", disciplina);
                resp.sendRedirect("../disciplina.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            String chave = req.getParameter("chave");
            String nome = req.getParameter("nome");
            Disciplina disciplina = new Disciplina();
            disciplina.setId(id);
            disciplina.setChave(chave);
            disciplina.setNome(nome);
            disciplinaDAO.alterar(disciplina);
            req.getSession().removeAttribute("disciplina");
            resp.sendRedirect("../disciplina/listar");
        }catch (Exception e){
            throw new ServletException("Dados inválidos");
        }
    }

    @Override
    public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            String chave = req.getParameter("chave");
            String nome = req.getParameter("nome");
            Disciplina disciplina = new Disciplina();
            disciplina.setId(id);
            disciplina.setChave(chave);
            disciplina.setNome(nome);

            Professor professor = (Professor) req.getSession().getAttribute("usuarioLogado");
            disciplina.adicionarProfessor(professor);

            disciplinaDAO.salvar(disciplina);
            resp.sendRedirect("../disciplina/listar");
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException("Dados inválidos");
        }
        resp.getWriter().write("salvar disciplina");
    }

    @Override
    public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            disciplinaDAO.excluir(disciplinaDAO.buscarPorId(Integer.parseInt(req.getParameter("id"))));
            resp.sendRedirect("../disciplina/listar");
        }catch (Exception e){
            resp.sendRedirect("../disciplina/listar");
        }
    }
}
