/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.PessoaQ;
import CamadaW.PessoaCadastroW;
import CamadaW.PessoaExclusaoW;
import DTO.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class PessoaExclusaoS {
    private PessoaExclusaoW view;

    public PessoaExclusaoS(PessoaExclusaoW view) {
        this.view = view;
    }
    
    
    public void DeletePessoa() {
        String cpfCnpj = view.getJTextFieldCpfCnpj().getText().trim();
        Pessoa pessoa = new Pessoa(cpfCnpj,"","");
        try {
            Connection conexao = new Conexao().getConnection();
            PessoaQ pessoaDao = new PessoaQ(conexao);
            pessoaDao.Deletar(pessoa);
            JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
