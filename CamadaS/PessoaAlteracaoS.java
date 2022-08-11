package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.PessoaQ;
import CamadaW.PessoaAlteracaoW;
import CamadaW.PessoaCadastroW;
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
public class PessoaAlteracaoS {
    private PessoaAlteracaoW view;

    public PessoaAlteracaoS(PessoaAlteracaoW view) {
        this.view = view;
    }
    
    public void UpdatePessoa() {
        String cpf_cnpj = view.getJTextFieldCpfCnpj().getText().trim();
        String nome = view.getJTextFieldNome().getText().trim();
        String contato = view.getJTextFieldContato().getText().trim();
        Pessoa pessoa = new Pessoa(cpf_cnpj,nome,contato);
        try {
            Connection conexao = new Conexao().getConnection();
            PessoaQ pessoaDao = new PessoaQ(conexao);
            pessoaDao.Atualizar(pessoa);
            JOptionPane.showMessageDialog(null, "Alteracao salva com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
