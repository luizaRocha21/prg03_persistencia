/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.dao.generic;

/**
 *
 * @author luiza
 */

import java.util.List;

/**
 * Interface genérica para operações CRUD
 * @param <T> Tipo da entidade
 */
public interface IGenericDAO<T> {
    T save(T entity);        // Salva uma entidade
    T update(T entity);      // Atualiza uma entidade
    void delete(T entity);   // Remove uma entidade
    List<T> findAll();       // Lista todas entidades
    T findById(Long id);     // Busca por ID
}
