package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Professor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class GenericDAO<T> implements Dao<T> {

    private Session session;
    private final Class classePersistente;

    public GenericDAO(Class classePersistente, Session session){
        this.classePersistente = classePersistente;
        this.session = session;
    }

    @Override
    public T buscarPorId(Serializable id) throws PersistenceException {
        T t = null;
        try{
            t = (T) session.find(classePersistente, id);
            return t;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por id");
        }
    }

    @Override
    public void salvar(T t) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao salvar.");
        }
    }

    @Override
    public void alterar(T t) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao alterar.");
        }
    }

    @Override
    public void excluir(T t) throws PersistenceException {
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.remove(t);
            transaction.commit();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao excluir.");
        }
    }

    @Override
    public List<T> buscarTodos() throws PersistenceException {
        try{
            String hql = "from "+this.classePersistente.getCanonicalName();
            Query query = session.createQuery(hql, this.classePersistente);
            List results = query.getResultList();
            return results;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException("Falha ao buscar por professores.");
        }
    }
}
