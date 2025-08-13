package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.Dao;
import br.edu.ifpr.irati.model.Aluno;
import br.edu.ifpr.irati.model.Professor;
import br.edu.ifpr.irati.util.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class AlunoService implements Service{
    private Dao<Aluno> alunoDAO;

    public AlunoService(Dao<Aluno> alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    @Override
    public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            if (req.getParameter("id") == null){//listar todos
                List<Aluno> alunos = alunoDAO.buscarTodos();
                req.getSession().setAttribute("alunos", alunos);
                resp.sendRedirect("../alunos.jsp"); //CRIAR ALUNOS.JSP
            }else{// listar por id
                Aluno aluno = alunoDAO.buscarPorId(Integer.parseInt(req.getParameter("id")));
                req.getSession().setAttribute("aluno", aluno);
                resp.sendRedirect("../aluno.jsp"); //CRIAR ALUNO.JSP
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
            Aluno aluno = new Aluno();
            aluno.setId(id);
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setSenha(senha);
            alunoDAO.alterar(aluno);
            req.getSession().removeAttribute("aluno");
            resp.sendRedirect("../aluno/listar");
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
            Aluno aluno = new Aluno();
            aluno.setId(id);
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setSenha(senha);
            alunoDAO.salvar(aluno);
            resp.sendRedirect("../aluno/listar");
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException("Dados inválidos");
        }
        resp.getWriter().write("salvar aluno");
    }

    @Override
    public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            alunoDAO.excluir(alunoDAO.buscarPorId(Integer.parseInt(req.getParameter("id"))));
            resp.sendRedirect("../aluno/listar");
        }catch (Exception e){
            resp.sendRedirect("../aluno/listar");
        }
    }
}
