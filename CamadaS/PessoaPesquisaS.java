/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.PessoaQ;
import CamadaW.PessoaCadastroW;
import CamadaW.PessoaPesquisarW;
import DTO.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import CamadaW.ContaPesquisaW;

/**
 *
 * @author Luis
 */
public class PessoaPesquisaS {
    private PessoaPesquisarW view;

    public PessoaPesquisaS(PessoaPesquisarW view) {
        this.view = view;
    }
    
    public ArrayList<Pessoa> SearchPessoa() {
        String cpf_cnpj = view.getJTextFieldCpfCnpj().getText().trim();
        Pessoa pessoa = new Pessoa(cpf_cnpj,"","");
        ArrayList<Pessoa> people = new ArrayList<Pessoa>();
        try {
            Connection conexao = new Conexao().getConnection();
            PessoaQ pessoaDao = new PessoaQ(conexao);
            if (view.getJTextFieldCpfCnpj().getText().trim().equals("")) {
                people = pessoaDao.PesquisarTudo();
            } else {
                people = pessoaDao.PesquisarId(pessoa);
            }
        }catch(SQLException ex) {
            Logger.getLogger(PessoaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return people;
    }
    
    public void AbrirCadastroConta() {
        ContaPesquisaW cadastro = new ContaPesquisaW();
        cadastro.setVisible(true);
    }
    
    public void gerarPDF(String senha) {
        
    }
}
