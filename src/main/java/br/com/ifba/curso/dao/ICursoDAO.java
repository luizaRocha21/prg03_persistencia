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
import br.com.ifba.curso.dao.generic.IGenericDAO;
import java.util.List;

/**
 * Interface específica para operações com Curso
 */
public interface ICursoDAO extends IGenericDAO<Curso> {
    List<Curso> findByNome(String nome);  // Busca cursos por nome
}