package br.edu.ifpr.irati.dao;

import br.edu.ifpr.irati.exception.PersistenceException;
import br.edu.ifpr.irati.model.Disciplina;

public interface DisciplinaDao extends Dao<Disciplina> {
    public Disciplina buscarPorChave(String chave) throws PersistenceException;
}
