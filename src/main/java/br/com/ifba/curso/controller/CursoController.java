/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.dao.ICursoDAO;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.ICursoService;
import java.util.List;

/**
 * Controlador responsável por intermediar as operações entre a view e o service
 */
public class CursoController {
    private final ICursoService cursoService;
    
    /**
     * @param cursoService Implementação concreta do serviço de cursos
     */
    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    /**
     * Salva um novo curso
     * @param curso Curso a ser salvo
     * @return Curso salvo com ID gerado
     */
    public Curso salvarCurso(Curso curso) {
        return cursoService.saveCurso(curso);
    }
    
    /**
     * Atualiza um curso existente
     * @param curso Curso com dados atualizados
     * @return Curso atualizado
     */
    public Curso atualizarCurso(Curso curso) {
        return cursoService.updateCurso(curso);
    }
    
    /**
     * Remove um curso do sistema
     * @param curso Curso a ser removido
     */
    public void removerCurso(Curso curso) {
        cursoService.deleteCurso(curso);
    }
    
    /**
     * Lista todos os cursos cadastrados
     * @return Lista de cursos
     */
    public List<Curso> listarTodosCursos() {
        return cursoService.getAllCursos();
    }
    
    /**
     * Busca cursos por nome (busca parcial case-insensitive)
     * @param nome Parte do nome a ser buscado
     * @return Lista de cursos encontrados
     */
    public List<Curso> buscarPorNome(String nome) {
        return cursoService.findByNome(nome);
    }
    
    /**
     * Busca um curso específico pelo ID
     * @param id ID do curso
     * @return Curso encontrado
     */
    public Curso buscarPorId(Long id) {
        return cursoService.findById(id);
    }
}