/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.ContaQ;
import CamadaW.ContaAlteracaoW;
import DTO.Conta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ContaAlteracaoS {
    private ContaAlteracaoW view;

    public ContaAlteracaoS(ContaAlteracaoW view) {
        this.view = view;
    }
    
    public void AlterarLimiteConta() {
        int id = Integer.parseInt(view.getJTextFieldId().getText().trim());
        double limite = Double.parseDouble(view.getJTextFieldLimite().getText().trim());
        
        Conta conta = new Conta(id,Date.valueOf(LocalDate.now()),limite,0.0,"","");
        try {
            Connection conexao = new Conexao().getConnection();
            ContaQ contaDao = new ContaQ(conexao);
            contaDao.Atualizar(conta);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ContaAlteracaoW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AlterarTipoConta() {
        
    }
}
