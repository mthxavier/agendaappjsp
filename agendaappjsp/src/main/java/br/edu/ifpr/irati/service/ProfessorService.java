package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.Dao;
import br.edu.ifpr.irati.dao.GenericDAO;
import br.edu.ifpr.irati.dao.ProfessorDAO;
import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Aluno;
import br.edu.ifpr.irati.model.Disciplina;
import br.edu.ifpr.irati.model.Professor;
import br.edu.ifpr.irati.util.HibernateUtil;
import br.edu.ifpr.irati.util.URLParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService implements Service{

    private Dao<Professor> professorDAO;

    public ProfessorService(Dao<Professor> professorDAO) {
        this.professorDAO = professorDAO;
    }

    @Override
    public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            if (req.getParameter("id") == null){//listar todos
                List<Professor> professores = professorDAO.buscarTodos();
                req.getSession().setAttribute("professores", professores);
                resp.sendRedirect("../professores.jsp");
            }else{// listar por id
                Professor professor = professorDAO.buscarPorId(Integer.parseInt(req.getParameter("id")));
                req.getSession().setAttribute("professor", professor);
                resp.sendRedirect("../professor.jsp");
            }
        }catch (Exception e){
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            System.out.println(req.getParameter("ativo"));
            boolean ativo = req.getParameter("ativo").equals("on")? true: false;
            Professor professor = new Professor();
            professor.setId(id);
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setSenha(senha);
            professor.setAtivo(ativo);
            professorDAO.alterar(professor);
            req.getSession().removeAttribute("professor");
            resp.sendRedirect("../professor/listar");
        }catch (Exception e){
            throw new ServletException("Dados inválidos");
        }
    }

    @Override
    public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            boolean ativo = req.getParameter("ativo").equals("on")? true: false;
            Professor professor = new Professor();
            professor.setId(id);
            professor.setNome(nome);
            professor.setEmail(email);
            professor.setSenha(senha);
            professor.setAtivo(ativo);
            professorDAO.salvar(professor);
            resp.sendRedirect("../professor/listar");
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException("Dados inválidos");
        }
        resp.getWriter().write("salvar professor");
    }

    @Override
    public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            professorDAO.excluir(professorDAO.buscarPorId(Integer.parseInt(req.getParameter("id"))));
            resp.sendRedirect("../professor/listar");
        }catch (Exception e){
            resp.sendRedirect("../professor/listar");
        }
    }
}
