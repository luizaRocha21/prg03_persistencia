/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao.generic;

/**
 *
 * @author luiza
 */

import br.com.ifba.infra.persistence.JPAutil;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Implementação genérica de DAO usando JPA
 */
public abstract class GenericDAO<T> implements IGenericDAO<T> {
    protected EntityManager em = JPAutil.getEntityManager();
    private final Class<T> entityClass;
    
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Override
    public T save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }
    
    @Override
    public T update(T entity) {
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        return entity;
    }
    
    @Override
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }
    
    @Override
    public List<T> findAll() {
        return em.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }
    
    @Override
    public T findById(Long id) {  // Note que é Long (objeto), não long (primitivo)
        return em.find(entityClass, id);
    }
}