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
import br.com.ifba.curso.util.StringUtil;
import java.util.List;

/**
 * Implementação concreta do serviço de cursos
 */
public class CursoService implements ICursoService {
    private final ICursoDAO cursoDAO;
    
    public CursoService(ICursoDAO cursoDAO) {
        this.cursoDAO = cursoDAO;
    }
    
    @Override
    public Curso saveCurso(Curso curso) {
        validarCurso(curso);
        return cursoDAO.save(curso);
    }
    
    @Override
    public Curso updateCurso(Curso curso) {
        validarCurso(curso);
        return cursoDAO.update(curso);
    }
    
    @Override
    public void deleteCurso(Curso curso) {
        cursoDAO.delete(curso);
    }
    
    @Override
    public List<Curso> getAllCursos() {
        return cursoDAO.findAll();
    }
    
    @Override
    public List<Curso> findByNome(String nome) {
        return cursoDAO.findByNome(nome);
    }
    
    @Override
    public Curso findById(Long id) {
        return cursoDAO.findById(id);
    }
    
    /**
     * Valida os dados do curso conforme regras de negócio
     */
    private void validarCurso(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())) {
            throw new IllegalArgumentException("Nome do curso é obrigatório");
        }
        if (curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser positiva");
        }
    }
}