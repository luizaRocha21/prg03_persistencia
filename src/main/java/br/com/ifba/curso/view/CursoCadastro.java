/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.view;

/**
 *
 * @author luiza
 */
import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.entity.Curso;
import javax.swing.*;
import java.awt.*;

/**
 * Diálogo para cadastro/edição de cursos
 */

public class CursoCadastro extends JDialog {
    private final JTextField txtNome = new JTextField();
    private final JTextField txtDescricao = new JTextField();
    private final JTextField txtFornecedor = new JTextField();
    private final JSpinner spnCargaHoraria = new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
    private final Curso curso;
    private final CursoController controller;

    public CursoCadastro(JFrame parent, CursoController controller, Curso curso) {
        super(parent, true);
        this.controller = controller;
        this.curso = curso != null ? curso : new Curso();
        initComponents();
    }

    private void initComponents() {
        setTitle(curso.getId() == null ? "Novo Curso" : "Editar Curso");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        
        // Preenche campos se estiver editando
        if (curso.getId() != null) {
            txtNome.setText(curso.getNome());
            txtDescricao.setText(curso.getDescricao());
            txtFornecedor.setText(curso.getFornecedor());
            spnCargaHoraria.setValue(curso.getCargaHoraria());
        }
        
        // Adiciona componentes
        add(new JLabel("Nome:"));
        add(txtNome);
        add(new JLabel("Descrição:"));
        add(txtDescricao);
        add(new JLabel("Fornecedor:"));
        add(txtFornecedor);
        add(new JLabel("Carga Horária:"));
        add(spnCargaHoraria);
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarCurso());
        add(new JLabel());
        add(btnSalvar);
    }
    
    
    private void salvarCurso() {
        try {
            // Atualiza objeto curso
            curso.setNome(txtNome.getText());
            curso.setDescricao(txtDescricao.getText());
            curso.setFornecedor(txtFornecedor.getText());
            curso.setCargaHoraria((Integer) spnCargaHoraria.getValue());
            
            // Salva via controller
            if (curso.getId() == null) {
                controller.salvarCurso(curso);
            } else {
                controller.atualizarCurso(curso);
            }
            
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao salvar: " + ex.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}