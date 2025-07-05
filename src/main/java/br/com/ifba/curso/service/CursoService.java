/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.dao.ICursoDAO;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.exceptions.ServiceException;

/**
 * Camada de serviço para operações com Curso
 */
public class CursoService {
    private final ICursoDAO cursoDAO;
    
    public CursoService(ICursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }
    
    public Curso saveCurso(Curso curso) throws ServiceException {
        try {
            // Validação de negócio
            if(curso.getNome() == null || curso.getNome().trim().isEmpty()) {
                throw new ServiceException("Nome do curso é obrigatório");
            }
            return cursoDAO.save(curso);
        } catch (Exception ex) {
            throw new ServiceException("Erro ao salvar curso: " + ex.getMessage(), ex);
        }
    }
}
