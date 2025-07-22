/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.dao.CursoRepository;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CursoService implements ICursoService {
    
    private final CursoRepository cursoRepository;

    @Override
    public Curso saveCurso(Curso curso) {
        log.info("Salvando curso: {}", curso.getNome());
        validarCurso(curso);
        return cursoRepository.save(curso);
    }

    @Override
    public Curso updateCurso(Curso curso) {
        log.info("Atualizando curso ID {}: {}", curso.getId(), curso.getNome());
        validarCurso(curso);
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        log.info("Removendo curso ID {}: {}", curso.getId(), curso.getNome());
        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> getAllCursos() {
        log.info("Buscando todos os cursos");
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> findByNome(String nome) {
        log.info("Buscando cursos por nome: {}", nome);
        return cursoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Curso findById(Long id) {
        log.info("Buscando curso por ID: {}", id);
        return cursoRepository.findById(id).orElse(null);
    }

    private void validarCurso(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())) {
            log.error("Validação falhou: Nome do curso é obrigatório");
            throw new IllegalArgumentException("Nome do curso é obrigatório");
        }
        if (curso.getCargaHoraria() <= 0) {
            log.error("Validação falhou: Carga horária deve ser positiva");
            throw new IllegalArgumentException("Carga horária deve ser positiva");
        }
    }
}