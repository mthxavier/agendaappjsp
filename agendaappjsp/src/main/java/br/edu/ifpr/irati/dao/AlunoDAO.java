package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Aluno;
import br.edu.ifpr.irati.model.Professor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class AlunoDAO {
    private Session session;

    public AlunoDAO(Session session){
        this.session = session;
    }

    public void salvar(Aluno aluno) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.persist(aluno);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao salvar um aluno");
        }
    }

    public void alterar(Aluno aluno) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(aluno);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao alterar um aluno");
        }
    }

    public void excluir(Aluno aluno) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.remove(aluno);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao excluir um aluno");
        }
    }

    public Aluno buscarPorId(Serializable id) throws PersistenceException{
        Aluno aluno = null;
        try{
            aluno = (Aluno) session.find(Aluno.class, id);
            return aluno;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por id");
        }
    }

    public Aluno buscarPorEmailSenha(String email, String senha) throws PersistenceException {
        try {
            String hql = "FROM Aluno a WHERE a.email = :email AND a.senha = :senha";
            Query<Aluno> query = session.createQuery(hql, Aluno.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);

            return query.uniqueResult();
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException("Falha ao buscar aluno por email e senha");
        }
    }


    public List<Aluno> buscarTodos() throws PersistenceException{
        try{
            String hql = "from Aluno";
            Query query = session.createQuery(hql, Aluno.class);
            List results = query.getResultList();
            return results;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por alunos.");
        }
    }
}
