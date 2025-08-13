package br.edu.ifpr.irati.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.http.Cookie;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "chavesecretaextremamenteseguraelonga2025atualizada";

    public static String gerarToken(int id) {
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static boolean validarToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(SECRET_KEY) // Usa a chave secreta para validar
                    .parseClaimsJws(token); // Se não lançar exceção, o token é válido
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token expirado!");
        } catch (SignatureException | MalformedJwtException e) {
            System.out.println("Token inválido!");
        } catch (Exception e) {
            System.out.println("Erro na validação do token!");
        }
        return false;
    }
}
