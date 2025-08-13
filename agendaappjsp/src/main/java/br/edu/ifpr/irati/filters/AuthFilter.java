package br.edu.ifpr.irati.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import br.edu.ifpr.irati.util.JwtUtil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter(urlPatterns = {"/home.jsp",
        "/disciplinas.jsp",
        "/disciplina.jsp",
        "/entrarcurso.jsp"})
public class AuthFilter implements Filter{


    private Cookie getToken(HttpServletRequest httpReq) {
        Cookie[] cookies = httpReq.getCookies();
        Cookie token = null;
        if (cookies != null) {
            for (Cookie c: cookies) {
                if (c.getName().equals("token")) {
                    token = c;
                    break;
                }
            }
        }
        return token;
    }

    public void init(FilterConfig config) throws ServletException{

        System.out.println("*** Inciando o filtro");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Timestamp
        System.out.println("Data e hora: "+ new Date().toString());

        // Endereço IP de origem da requisição
        System.out.println("IP: "+ request.getRemoteHost());

        /*
         * Lógica da aplicação
         *
         * se houver um cookie ativo (há um cookie e ele confere com o banco de dados) permitir o acesso
         * caso negativo, não liberar o acesso - criar link para login.jsp
         *
         */
        Cookie token = getToken((HttpServletRequest) request);

        boolean valido = (token != null) && JwtUtil.validarToken(token.getValue());
        if (valido) {
            chain.doFilter(request, response);
        }else {
            HttpServletResponse httpResp = (HttpServletResponse) response;
            PrintWriter writer = httpResp.getWriter();
            writer.print("<a href=\"login.jsp\">Ir para login.</a>");
        }
        System.out.println("*** Executado após a requisição");
    }

    public void destroy(){
        System.out.println("*** Destruindo o filtro");
    }

}

