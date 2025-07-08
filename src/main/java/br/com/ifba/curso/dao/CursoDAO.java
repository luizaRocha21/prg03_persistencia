/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.dao.generic.GenericDAO;
import br.com.ifba.curso.entity.Curso;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 * Implementação do DAO para Curso
 */
public class CursoDAO extends GenericDAO<Curso> implements ICursoDAO {
    
    public CursoDAO() {
        super(Curso.class);  // Passa a classe Curso para o DAO genérico
    }
    
    @Override
    public List<Curso> findByNome(String nome) {
        TypedQuery<Curso> query = em.createQuery(
            "SELECT c FROM Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome)", Curso.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
}