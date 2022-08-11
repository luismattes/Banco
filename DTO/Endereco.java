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
public class Endereco {
    private String rua;
    private String estado;
    private String cidade;
    private String bairro;
    private String numero;
    private String cep;

    public Endereco(String rua, String estado, String cidade, String bairro, 
            String numero, String cep) {
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }
    
    public void Set_rua(String rua) {
        this.rua = rua;
    }
    
    public void Set_estado(String estado) {
        this.estado = estado;
    }
    
    public void Set_cidade(String cidade) {
        this.cidade = cidade;
    }
    
    public void Set_bairro(String bairro) {
        this.bairro = bairro;
    } 
    
    public void Set_numero(String numero) {
        this.numero = numero;
    }
    
    public void Set_cep(String cep) {
        this.cep = cep;
    }
    
    public String Get_rua() {
        return this.rua;
    }
    
    public String Get_estado() {
        return this.estado;
    }
    
    public String Get_cidade() {
        return this.cidade;
    }
    
    public String Get_bairro() {
        return this.bairro;
    }
    
    public String Get_numero() {
        return this.numero;
    }
    
    public String Get_cep() {
        return this.cep;
    }
}
