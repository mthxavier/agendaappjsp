package br.edu.ifpr.irati.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TarefaService implements Service{
    @Override
    public void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("listar tarefas");
    }

    @Override
    public void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void salvar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void excluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
