/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


/**
 *
 * @author Luis
 */
public class Pessoa {
    private String nome_pessoa;
    private String contato;
    private String tipo_pessoa;
    private String cpfCnpj;

    public Pessoa(String cpfCnpj, String nome_pessoa, String contato) {
        this.cpfCnpj = cpfCnpj;
        this.nome_pessoa = nome_pessoa;
        this.contato = contato;
    }
    
    public Pessoa(String cpfCnpj, String nome_pessoa, String contato, 
            String tipo_pessoa) {
        this.cpfCnpj = cpfCnpj;
        this.nome_pessoa = nome_pessoa;
        this.contato = contato;
        this.tipo_pessoa = tipo_pessoa;
    }
    
    public void Set_nome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }
    
    public void Set_contato(String contato) {
        this.contato = contato;
    }
    
    public void Set_tipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }
    
    public String Get_cpf_cnpj() {
        return this.cpfCnpj;
    }
    
    public String Get_nome_pessoa() {
        return this.nome_pessoa;
    }
    
    public String Get_contato() {
        return this.contato;
    }
    
    public String Get_tipo_pessoa() {
        return this.tipo_pessoa;
    }
    
}
