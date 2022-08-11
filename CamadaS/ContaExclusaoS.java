/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.ContaQ;
import CamadaW.ContaExclusaoW;
import DTO.Conta;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class ContaExclusaoS {
    private ContaExclusaoW view;

    public ContaExclusaoS(ContaExclusaoW view) {
        this.view = view;
    }
    
    public void DeleteConta() {
        int id = Integer.parseInt(view.getjTextFieldEx().getText().trim());
        Conta conta = new Conta(id);
        try {
            Connection conexao = new Conexao().getConnection();
            ContaQ contaDao = new ContaQ(conexao);
            contaDao.Deletar(conta);
            JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ContaExclusaoW.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
