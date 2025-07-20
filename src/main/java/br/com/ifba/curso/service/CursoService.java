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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CursoService implements ICursoService {
    
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso saveCurso(Curso curso) {
        validarCurso(curso);
        return cursoRepository.save(curso);
    }

    @Override
    public Curso updateCurso(Curso curso) {
        validarCurso(curso);
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public List<Curso> findByNome(String nome) {
        return cursoRepository.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    private void validarCurso(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())) {
            throw new IllegalArgumentException("Nome do curso é obrigatório");
        }
        if (curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("Carga horária deve ser positiva");
        }
    }
}