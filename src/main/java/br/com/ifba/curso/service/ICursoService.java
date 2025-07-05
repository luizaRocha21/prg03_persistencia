/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.exceptions.ServiceException;
import java.util.List;

public interface ICursoService {
    Curso saveCurso(Curso curso) throws ServiceException;
    Curso updateCurso(Curso curso) throws ServiceException;
    void deleteCurso(Curso curso) throws ServiceException;
    List<Curso> getAllCursos() throws ServiceException;
    Curso findById(Long id) throws ServiceException;
}
