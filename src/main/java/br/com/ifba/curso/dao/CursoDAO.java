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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Realiza operações CRUD no banco de dados.
 */
public class CursoDAO {
    private static final EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("cursoPU");

    // Salva um novo curso
    public void save(Curso curso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
        em.close();
    }

    // Busca todos os cursos
    public List<Curso> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Curso> cursos = em.createQuery("FROM Curso", Curso.class).getResultList();
        em.close();
        return cursos;
    }

    // Busca por ID
    public Curso findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Curso curso = em.find(Curso.class, id);
        em.close();
        return curso;
    }

    // Atualiza um curso
    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
        em.close();
    }

    // Remove um curso
    public void delete(Curso curso) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        curso = em.merge(curso); // Reanexa a entidade se estiver detached
        em.remove(curso);
        em.getTransaction().commit();
        em.close();
    }
}