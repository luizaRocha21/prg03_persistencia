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
import java.util.List;

/**
 * Contrato para operações de serviço com cursos
 */
public interface ICursoService {
    Curso saveCurso(Curso curso);          // Salva novo curso
    Curso updateCurso(Curso curso);        // Atualiza curso existente
    void deleteCurso(Curso curso);         // Remove curso
    List<Curso> getAllCursos();           // Lista todos cursos
    List<Curso> findByNome(String nome);   // Busca por nome
    Curso findById(Long id);               // Busca por ID
}