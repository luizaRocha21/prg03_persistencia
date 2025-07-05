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
import br.com.ifba.curso.dao.exceptions.DAOException;
import java.util.List;

/**
 * Interface do padrão DAO para a entidade Curso
 */

public interface ICursoDAO {
    Curso save(Curso curso) throws CursoException;
    Curso update(Curso curso) throws CursoException;
    void delete(Curso curso) throws CursoException;
    List<Curso> findAll() throws CursoException;
    Curso findById(Long id) throws CursoException;
}