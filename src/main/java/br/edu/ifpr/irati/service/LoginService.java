package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.AlunoDAO;
import br.edu.ifpr.irati.dao.ProfessorDAO;
import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Aluno;
import br.edu.ifpr.irati.model.Professor;
import br.edu.ifpr.irati.util.HibernateUtil;
import br.edu.ifpr.irati.util.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class LoginService implements AutenticacaoService{
    public void validar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        ProfessorDAO professorDAO = new ProfessorDAO(session);
        AlunoDAO alunoDAO = new AlunoDAO(session);

        try {
            Professor professor = professorDAO.buscarPorEmailSenha(email, senha);

            Aluno aluno = alunoDAO.buscarPorEmailSenha(email, senha);

            if (professor != null) {
                req.getSession().setAttribute("usuarioLogado", professor);

                String stoken = JwtUtil.gerarToken(professor.getId());
                Cookie token = new Cookie("token", stoken);
                token.setMaxAge(60);
                token.setPath("/"); // Disponível em todo o site
                resp.addCookie(token);

                resp.sendRedirect("../home.jsp");
            } else if (aluno != null) {
                req.getSession().setAttribute("usuarioLogado", aluno);

                String stoken = JwtUtil.gerarToken(aluno.getId());
                Cookie token = new Cookie("token",stoken);
                token.setMaxAge(60);
                token.setPath("/"); // Disponível em todo o site
                resp.addCookie(token);

                resp.sendRedirect("../home.jsp");
            } else {
                resp.sendRedirect("../erroLogin.jsp"); // Redireciona para login com erro
            }
        } catch (PersistenceException | IOException e) {
            resp.sendRedirect("erroLogin.jsp");
        }
    }
}
