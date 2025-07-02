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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class CursoDAO {
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("cursoPU");

    public void save(Curso curso) throws CursoException {
        EntityManager em = null;
        try {
            if (curso == null) {
                throw new CursoException("O curso não pode ser nulo!");
            }
            
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            handlePersistenceException(ex, "Erro ao salvar curso");
        } finally {
            closeEntityManager(em);
        }
    }

    public List<Curso> findAll() throws CursoException {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Query query = em.createQuery("FROM Curso", Curso.class);
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new CursoException("Erro ao buscar todos os cursos", ex);
        } finally {
            closeEntityManager(em);
        }
    }

    public Curso findById(Long id) throws CursoException {
        if (id == null) {
            throw new CursoException("ID não pode ser nulo");
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            Curso curso = em.find(Curso.class, id);
            if (curso == null) {
                throw new CursoException("Curso com ID " + id + " não encontrado");
            }
            return curso;
        } catch (PersistenceException ex) {
            throw new CursoException("Erro ao buscar curso por ID", ex);
        } finally {
            closeEntityManager(em);
        }
    }

    public void update(Curso curso) throws CursoException {
        if (curso == null || curso.getId() == null) {
            throw new CursoException("Curso ou ID do curso não pode ser nulo");
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            handlePersistenceException(ex, "Erro ao atualizar curso");
        } finally {
            closeEntityManager(em);
        }
    }

    public void delete(Curso curso) throws CursoException {
        if (curso == null || curso.getId() == null) {
            throw new CursoException("Curso ou ID do curso não pode ser nulo");
        }

        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            curso = em.merge(curso);
            em.remove(curso);
            em.getTransaction().commit();
        } catch (PersistenceException ex) {
            handlePersistenceException(ex, "Erro ao remover curso");
        } finally {
            closeEntityManager(em);
        }
    }

    // Métodos auxiliares privados
    private void handlePersistenceException(PersistenceException ex, String message) throws CursoException {
        String detailedMessage = message + ": " + ex.getMessage();
        Throwable cause = ex.getCause();
        
        if (cause != null) {
            detailedMessage += " (Causa: " + cause.getMessage() + ")";
        }
        
        throw new CursoException(detailedMessage, ex);
    }

    private void closeEntityManager(EntityManager em) {
        try {
            if (em != null && em.isOpen()) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        } catch (PersistenceException ex) {
            System.err.println("Erro ao fechar EntityManager: " + ex.getMessage());
        }
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}