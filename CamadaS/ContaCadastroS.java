/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.ContaQ;
import CamadaW.ContaCadastroW;
import DTO.Conta;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ContaCadastroS {
    
    private ContaCadastroW view;

    public ContaCadastroS(ContaCadastroW view) {
        this.view = view;
    }
    
    public void CreateConta() {
        Date data_cadastro = Date.valueOf(LocalDate.now());
        double saldo = Double.parseDouble(view.getJTextFieldSaldo().getText().trim());
        String senha = view.getJPasswordFieldSenha().getText().trim();
        String tipo_conta = TipoConta();
        
        senha = criptografar(senha);
        Conta conta = new Conta(data_cadastro, saldo, 500, tipo_conta, senha);
        try {
            Connection conexao = new Conexao().getConnection();
            ContaQ contaDao = new ContaQ(conexao);
            contaDao.Incluir(conta);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String TipoConta() {
        String tipo = null;
        if(view.getJRadioButtonCP().isSelected()) {
            tipo = "p";
        }else if(view.getJRadioButtonCC().isSelected()) {
            tipo = "c";
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um tipo de pessoa!");
            }
        return tipo;
    }
    
    private String criptografar(String senha) {
        String retorno = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger bi = new BigInteger(1, md.digest(senha.getBytes()));
            retorno = bi.toString(16);
        } catch(Exception e) {
            
        }
        return retorno;
    }
}
