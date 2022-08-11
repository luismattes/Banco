/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Luis
 */
public class Movimento {
    private int id;
    private String tipo;
    private double quantidade;
    private int idConta;
    
    public Movimento(String tipo, double quantidade, int idConta) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.idConta = idConta;
    }

    public Movimento(int id, String tipo, double quantidade, int idConta) {
        this.id = id;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.idConta = idConta;
    }

    public Movimento() {
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getTipo() {
        return this.tipo;
    }
    
    public double getQuantidade() {
        return this.quantidade;
    }
    
    public int getIdConta() {
        return this.idConta;
    }
    
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
