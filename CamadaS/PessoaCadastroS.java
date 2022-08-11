package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.PessoaQ;
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
public class PessoaCadastroS {
    private PessoaCadastroW  view;
    private Valida val;

    public PessoaCadastroS(PessoaCadastroW view) {
        this.view = view;
        this.val = new Valida();
    }
    
    public void CreatePessoa() {
        String cpfCnpj = view.getjTextFieldCpfCnpj().getText().trim();
        String nome = view.getjTextFieldNome().getText().trim();
        String contato = view.getjTextFieldContato().getText().trim();
        String tipo_pessoa = TipoPessoa();
        
        if (nome.split(" ").length <= 1) {
            JOptionPane.showMessageDialog(null, "Nome deve estar completo!");
            return;
        }
        if (tipo_pessoa.equals("f") && !val.validarCPF(cpfCnpj)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return;
        } else if(tipo_pessoa.equals("j") && !val.validarCNPJ(cpfCnpj)) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!");
            return;
        }
        
        Pessoa pessoa = new Pessoa(cpfCnpj,nome,contato,tipo_pessoa);
        try {
            Connection conexao = new Conexao().getConnection();
            PessoaQ pessoaDao = new PessoaQ(conexao);
            pessoaDao.Incluir(pessoa);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaCadastroW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String TipoPessoa() {
        String tipo = null;
        if(view.getjRadioButtonPessoaFisica().isSelected()) {
            tipo = "f";
        }else if(view.getjRadioButtonPessoaJuridica().isSelected()) {
            tipo = "j";
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um tipo de pessoa!");
            }
        return tipo;
    }
    
}
