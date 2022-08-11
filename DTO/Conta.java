/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Luis
 */
public class Conta {
    private int id_conta;
    private Date data_cadastro;
    private double limite;
    private double saldo;
    private String tipo_conta;
    private String senha;

    public Conta(int id_conta, Date data_cadastro, double saldo, double limite, 
            String tipo_conta, String senha) {
        this.id_conta = id_conta;
        this.data_cadastro = data_cadastro;
        this.limite = limite;
        this.saldo = saldo;
        this.tipo_conta = tipo_conta;
        this.senha = senha;
    }

    public Conta(Date data_cadastro, double saldo, double limite, 
            String tipo_conta, String senha) {
        this.data_cadastro = data_cadastro;
        this.limite = limite;
        this.saldo = saldo;
        this.tipo_conta = tipo_conta;
        this.senha = senha;
    }

    public Conta(int id){
        this.id_conta = id;
    }
    
    public void Set_data_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
    
    public void Set_limite(double limite) {
        this.limite = limite;
    }
    
    public void Set_saldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void Set_tipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }
    
    public void Set_senha(String senha) {
        this.senha = senha;
    }
    
    public int Get_id_conta() {
        return this.id_conta;
    }
    
    public Date Get_data_cadastro() {
        return this.data_cadastro;
    }
    
    public double Get_limite() {
        return this.limite;
    }
    
    public double Get_saldo() {
        return this.saldo;
    }
    
    public String Get_tipo_conta() {
        return this.tipo_conta;
    }
    
    public String Get_senha() {
        return this.senha;
    }
}
