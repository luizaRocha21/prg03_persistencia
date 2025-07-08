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
import br.com.ifba.curso.dao.CursoDAO;
import br.com.ifba.curso.dao.ICursoDAO;
import br.com.ifba.curso.service.CursoService;
import br.com.ifba.curso.service.ICursoService;
import br.com.ifba.curso.view.CursoListar;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Classe principal que inicia a aplicação
 */
public class Aplicacao {
    
    /**
     * Método principal que configura e inicia o sistema
     */
    public static void main(String[] args) {
        // Executa na thread de interface gráfica do Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Configuração das dependências:
                ICursoDAO dao = new CursoDAO();               // Camada de persistência
                ICursoService service = new CursoService(dao); // Camada de serviço
                CursoController controller = new CursoController(service); // Controlador
                
                // Cria e exibe a tela principal
                new CursoListar(controller).setVisible(true);
                
            } catch (Exception e) {
                // Tratamento de erros na inicialização
                JOptionPane.showMessageDialog(null,
                    "Falha ao iniciar: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
    }
}