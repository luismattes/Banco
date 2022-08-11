/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.MovimentoQ;
import CamadaW.MovimentoPesquisaW;
import DTO.Movimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class MovimentoPesquisaS {
    
    private MovimentoPesquisaW view;

    public MovimentoPesquisaS(MovimentoPesquisaW view) {
        this.view = view;
    }
    
    public ArrayList<Movimento> Pesquisar() {
        ArrayList<Movimento> movimentos = new ArrayList<>();
        try {
            Connection conexao = new Conexao().getConnection();
            MovimentoQ movimentoDao = new MovimentoQ(conexao);
            if (view.getJTextFieldIdConta().getText().trim().equals("")) {
                movimentos = movimentoDao.pesquisarTudo();
            } else {
                int idConta = Integer.parseInt(view.getJTextFieldIdConta().
                        getText().trim());
                Movimento mov = new Movimento();
                mov.setIdConta(idConta);
                movimentos = movimentoDao.pesquisarIdConta(mov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovimentoPesquisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movimentos;
    }
}
