package br.edu.ifpr.irati.service;

import br.edu.ifpr.irati.dao.DisciplinaDao;
import br.edu.ifpr.irati.dao.GenericDAO;
import br.edu.ifpr.irati.dao.ProfessorDAO;
import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Aluno;
import br.edu.ifpr.irati.model.Disciplina;
import br.edu.ifpr.irati.model.Professor;
import br.edu.ifpr.irati.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class ServiceFactory {

    public static Service getService(String nome){
        Session session = HibernateUtil.getSessionFactory().openSession();
        switch (nome){
            case "professor":
                return new ProfessorService(new GenericDAO<>(Professor.class, session));
            case "tarefa":
                return new TarefaService();
            case "aluno":
                return new AlunoService(new GenericDAO<>(Aluno.class, session));
            case "disciplina":
                return new DisciplinaService(new DisciplinaDao() {
                    @Override
                    public Disciplina buscarPorId(Serializable id) throws PersistenceException {
                        return null;
                    }

                    @Override
                    public void salvar(Disciplina disciplina) throws PersistenceException {

                    }

                    @Override
                    public void alterar(Disciplina disciplina) throws PersistenceException {

                    }

                    @Override
                    public void excluir(Disciplina disciplina) throws PersistenceException {

                    }

                    @Override
                    public List<Disciplina> buscarTodos() throws PersistenceException {
                        return List.of();
                    }

                    @Override
                    public Disciplina buscarPorChave(String chave) throws PersistenceException {
                        return null;
                    }
                });
            default:
                break;
        }
        return new TarefaService();

    }

    public static AutenticacaoService getAutenticacaoService(String nome) {
        if ("login".equals(nome)) {
            return new LoginService();
        }
        return null;
    }

}
