/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.dao;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    // Método equivalente ao findByNome do DAO
    List<Curso> findByNomeContainingIgnoreCase(String nome);
    
    // Consulta com JPQL explícito
    @Query("SELECT c FROM Curso c WHERE c.cargaHoraria > :minHoras")
    List<Curso> findByCargaHorariaMinima(@Param("minHoras") int minHoras);
}