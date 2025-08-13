package br.edu.ifpr.irati.servlet;

import br.edu.ifpr.irati.service.AutenticacaoService;
import br.edu.ifpr.irati.service.LoginService;
import br.edu.ifpr.irati.service.Service;
import br.edu.ifpr.irati.service.ServiceFactory;
import br.edu.ifpr.irati.util.URLParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "controleservlet", urlPatterns = {
        "/professor/listar",
        "/professor/editar",
        "/professor/salvar",
        "/professor/excluir",
        "/aluno/listar",
        "/aluno/excluir",
        "/aluno/editar",
        "/aluno/salvar",
        "/tarefa/listar",
        "/login/validar",
        "/disciplina/listar",
        "/disciplina/editar",
        "/disciplina/salvar",
        "/disciplina/excluir"})
public class ControleServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req,
                           HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String path = req.getServletPath();

            URLParser url = new URLParser(path);
            Service service = ServiceFactory.getService(url.getEntity());
            switch (url.getMethod()) {
                case "listar":
                    service.listar(req, resp);
                    break;
                case "editar":
                    service.editar(req, resp);
                    break;
                case "salvar":
                    service.salvar(req, resp);
                    break;
                case "excluir":
                    service.excluir(req, resp);
                    break;
                case "validar":
                    AutenticacaoService loginService = ServiceFactory.getAutenticacaoService(url.getEntity());
                    loginService.validar(req, resp);
                default:
                    //enviar para uma tela de erro
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }


    }
}
