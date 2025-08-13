package br.edu.ifpr.irati;

import br.edu.ifpr.irati.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}