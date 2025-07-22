/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.view.CursoListar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.swing.SwingUtilities;

@Slf4j
public class Aplicacao {
    public static void main(String[] args) {
        log.info("Iniciando aplicação");
        try {
            var context = new ClassPathXmlApplicationContext("applicationContext.xml");
            CursoController controller = context.getBean(CursoController.class);
            
            SwingUtilities.invokeLater(() -> {
                log.debug("Criando e exibindo janela principal");
                new CursoListar(controller).setVisible(true);
            });
        } catch (Exception e) {
            log.error("Falha ao iniciar aplicação", e);
        }
    }
}