/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.ContaQ;
import CamadaW.PessoaCadastroW;
import CamadaW.ContaCadastroW;
import CamadaW.ContaPesquisaW;
import DTO.Conta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class ContaPesquisaS {
    private ContaPesquisaW view;

    public ContaPesquisaS(ContaPesquisaW view) {
        this.view = view;
    }
    
    public void abrirContaCadastro() {
        ContaCadastroW cadastro = new ContaCadastroW();
        cadastro.setVisible(true);
    }
    
    public ArrayList<Conta> SearchConta() {
        int id;
        Conta conta;
        ArrayList<Conta> contas = new ArrayList<Conta>();
        try {
            Connection conexao = new Conexao().getConnection();
            ContaQ contaDao = new ContaQ(conexao);
            if (view.getjTextFieldId().getText().equals("")) {
                contas = contaDao.PesquisarTudo();
            } else {
                id = Integer.parseInt(view.getjTextFieldId().getText());
                conta = new Conta(id);
                contas = contaDao.PesquisarId(conta);
            }
        }catch(SQLException ex) {
            Logger.getLogger(PessoaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas;
    }
    
    public ArrayList<Conta> SearchContaIdSenha(int id, String senha) {
        ArrayList<Conta> contas = new ArrayList<Conta>();
        try {
            Connection conexao = new Conexao().getConnection();
            ContaQ contaDao = new ContaQ(conexao);
            contas = contaDao.PesquisarIdSenha(id, senha);
        }catch(SQLException ex) {
            Logger.getLogger(PessoaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas;
    }
}
