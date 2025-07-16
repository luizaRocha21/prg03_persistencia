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
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.swing.SwingUtilities;

public class Aplicacao {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CursoController controller = context.getBean(CursoController.class);
        
        SwingUtilities.invokeLater(() -> {
            new CursoListar(controller).setVisible(true);
        });
    }
}