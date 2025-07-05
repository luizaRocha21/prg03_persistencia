/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.exception.CursoException;
import br.com.ifba.infra.persistence.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 * Implementação concreta do DAO para a entidade Curso usando JPA.
 * Segue o padrão DAO com tratamento de exceções específico.
 */
public class CursoDAO implements ICursoDAO {

    private final EntityManager em;
    
    public CursoDAO() {
        this.em = JPAutil.getEntityManager(); // Injeção de dependência do EntityManager
    }

    /**
     * Salva um novo curso no banco de dados.
     * @param curso Curso a ser persistido
     * @return Curso salvo
     * @throws CursoException Se ocorrer erro na persistência
     */
    @Override
    public Curso save(Curso curso) throws CursoException {
        EntityTransaction transaction = em.getTransaction();
        try {
            validateCurso(curso);
            transaction.begin();
            em.persist(curso);
            transaction.commit();
            return curso;
        } catch (Exception ex) {
            handleTransactionFailure(transaction, "Erro ao salvar curso", ex);
            throw ex; // Re-throw após tratamento
        }
    }

    /**
     * Busca todos os cursos cadastrados.
     * @return Lista de cursos
     * @throws CursoException Se ocorrer erro na consulta
     */
    @Override
    public List<Curso> findAll() throws CursoException {
        try {
            TypedQuery<Curso> query = em.createQuery("FROM Curso", Curso.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new CursoException("Erro ao buscar cursos: " + ex.getMessage(), ex);
        }
    }

    /**
     * Busca um curso por ID.
     * @param id ID do curso
     * @return Curso encontrado
     * @throws CursoException Se não encontrar ou erro na consulta
     */
    @Override
    public Curso findById(Long id) throws CursoException {
        try {
            Curso curso = em.find(Curso.class, id);
            if (curso == null) {
                throw new CursoException("Curso com ID " + id + " não encontrado");
            }
            return curso;
        } catch (Exception ex) {
            throw new CursoException("Erro ao buscar curso por ID: " + ex.getMessage(), ex);
        }
    }

    /**
     * Atualiza um curso existente.
     * @param curso Curso com dados atualizados
     * @return Curso atualizado
     * @throws CursoException Se ocorrer erro na atualização
     */
    @Override
    public Curso update(Curso curso) throws CursoException {
        EntityTransaction transaction = em.getTransaction();
        try {
            validateCurso(curso);
            transaction.begin();
            Curso updated = em.merge(curso);
            transaction.commit();
            return updated;
        } catch (Exception ex) {
            handleTransactionFailure(transaction, "Erro ao atualizar curso", ex);
            throw ex;
        }
    }

    /**
     * Remove um curso do banco de dados.
     * @param curso Curso a ser removido
     * @throws CursoException Se ocorrer erro na remoção
     */
    @Override
    public void delete(Curso curso) throws CursoException {
        EntityTransaction transaction = em.getTransaction();
        try {
            validateCurso(curso);
            transaction.begin();
            Curso attached = em.merge(curso); // Garante que está no contexto de persistência
            em.remove(attached);
            transaction.commit();
        } catch (Exception ex) {
            handleTransactionFailure(transaction, "Erro ao remover curso", ex);
            throw ex;
        }
    }

    // --- Métodos auxiliares privados ---
    
    /**
     * Valida os dados básicos do curso antes de operações no banco
     */
    private void validateCurso(Curso curso) throws CursoException {
        if (curso == null) {
            throw new CursoException("Curso não pode ser nulo");
        }
        if (curso.getId() != null && curso.getId() <= 0) {
            throw new CursoException("ID do curso inválido");
        }
    }

    /**
     * Tratamento centralizado para falhas em transações
     */
    private void handleTransactionFailure(EntityTransaction transaction, String message, Exception ex) throws CursoException {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
        throw new CursoException(message + ": " + ex.getMessage(), ex);
    }
}