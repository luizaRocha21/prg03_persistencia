/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.view;

/**
 *
 * @author luiza
 */

import br.com.ifba.curso.entity.Curso;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class CursoCadastro extends JDialog {
    private final JTextField txtNome;
    private final JTextField txtDescricao;
    private final JTextField txtFornecedor;
    private final JSpinner spnCargaHoraria;
    private Curso curso;

    public CursoCadastro(CursoListar parent, Curso curso) {
        super(parent, true);
        this.curso = curso != null ? curso : new Curso();
        
        setTitle(curso.getId() == null ? "Novo Curso" : "Editar Curso");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        
        txtNome = new JTextField();
        txtDescricao = new JTextField();
        txtFornecedor = new JTextField();
        spnCargaHoraria = new JSpinner();
        
        if (curso != null) {
            txtNome.setText(curso.getNome());
            txtDescricao.setText(curso.getDescricao());
            txtFornecedor.setText(curso.getFornecedor());
            spnCargaHoraria.setValue(curso.getCargaHoraria());
        }
        
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
        curso.setNome(txtNome.getText());
        curso.setDescricao(txtDescricao.getText());
        curso.setFornecedor(txtFornecedor.getText());
        curso.setCargaHoraria((Integer) spnCargaHoraria.getValue());
        
        dispose();
    }
    
    public Curso getCurso() {
        return curso;
    }
}
