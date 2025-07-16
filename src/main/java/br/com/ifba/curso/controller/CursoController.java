/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // Esta classe é um controller gerenciado pelo Spring
public class CursoController {
    
    private final ICursoService cursoService;

    @Autowired // Adicione esta anotação
    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    public Curso salvarCurso(Curso curso) {
        return cursoService.saveCurso(curso);
    }

    public Curso atualizarCurso(Curso curso) {
        return cursoService.updateCurso(curso);
    }

    public void removerCurso(Curso curso) {
        cursoService.deleteCurso(curso);
    }

    public List<Curso> listarTodosCursos() {
        return cursoService.getAllCursos();
    }

    public List<Curso> buscarPorNome(String nome) {
        return cursoService.findByNome(nome);
    }

    public Curso buscarPorId(Long id) {
        return cursoService.findById(id);
    }
}