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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CursoController {
    
    private final ICursoService cursoService;

    public Curso salvarCurso(Curso curso) {
        log.debug("Iniciando salvamento do curso: {}", curso.getNome());
        try {
            Curso cursoSalvo = cursoService.saveCurso(curso);
            log.info("Curso salvo com sucesso - ID: {}, Nome: {}", cursoSalvo.getId(), cursoSalvo.getNome());
            return cursoSalvo;
        } catch (Exception e) {
            log.error("Falha ao salvar curso: {}", curso.getNome(), e);
            throw e;
        }
    }

    public Curso atualizarCurso(Curso curso) {
        log.debug("Iniciando atualização do curso ID: {}", curso.getId());
        try {
            Curso cursoAtualizado = cursoService.updateCurso(curso);
            log.info("Curso atualizado com sucesso - ID: {}, Nome: {}", cursoAtualizado.getId(), cursoAtualizado.getNome());
            return cursoAtualizado;
        } catch (Exception e) {
            log.error("Falha ao atualizar curso ID: {}", curso.getId(), e);
            throw e;
        }
    }

    public void removerCurso(Curso curso) {
        log.debug("Iniciando remoção do curso ID: {}", curso.getId());
        try {
            cursoService.deleteCurso(curso);
            log.info("Curso removido com sucesso - ID: {}, Nome: {}", curso.getId(), curso.getNome());
        } catch (Exception e) {
            log.error("Falha ao remover curso ID: {}", curso.getId(), e);
            throw e;
        }
    }

    public List<Curso> listarTodosCursos() {
        log.debug("Buscando todos os cursos cadastrados");
        try {
            List<Curso> cursos = cursoService.getAllCursos();
            log.info("Encontrados {} cursos", cursos.size());
            return cursos;
        } catch (Exception e) {
            log.error("Falha ao listar todos os cursos", e);
            throw e;
        }
    }

    public List<Curso> buscarPorNome(String nome) {
        log.debug("Buscando cursos por nome: {}", nome);
        try {
            List<Curso> cursos = cursoService.findByNome(nome);
            log.info("Encontrados {} cursos para o termo '{}'", cursos.size(), nome);
            return cursos;
        } catch (Exception e) {
            log.error("Falha ao buscar cursos por nome: {}", nome, e);
            throw e;
        }
    }

    public Curso buscarPorId(Long id) {
        log.debug("Buscando curso por ID: {}", id);
        try {
            Curso curso = cursoService.findById(id);
            if (curso != null) {
                log.info("Curso encontrado - ID: {}, Nome: {}", id, curso.getNome());
            } else {
                log.warn("Nenhum curso encontrado para o ID: {}", id);
            }
            return curso;
        } catch (Exception e) {
            log.error("Falha ao buscar curso por ID: {}", id, e);
            throw e;
        }
    }
}