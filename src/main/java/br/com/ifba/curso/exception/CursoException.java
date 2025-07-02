/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.exception;

/**
 *
 * @author luiza
 */
public class CursoException extends Exception {
    public CursoException(String message) {
        super(message);
    }
    
    public CursoException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CursoException(Throwable cause) {
        super(cause);
    }
}
