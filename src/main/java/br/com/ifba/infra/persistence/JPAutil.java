/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infra.persistence;

/**
 *
 * @author luiza
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilitário para gerenciamento de conexões JPA/Hibernate
 */
public class JPAutil {
    private static final String PERSISTENCE_UNIT = "cursoPU";
    private static EntityManagerFactory emf;
    
    // Bloco estático para inicialização
    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("Falha ao criar EntityManagerFactory: " + ex.getMessage());
        }
    }
    
    /**
     * Obtém uma nova instância de EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /**
     * Fecha a fábrica de EntityManager
     */
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}