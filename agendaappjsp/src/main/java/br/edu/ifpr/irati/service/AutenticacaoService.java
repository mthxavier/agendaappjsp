package br.edu.ifpr.irati.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AutenticacaoService {
    public void validar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
