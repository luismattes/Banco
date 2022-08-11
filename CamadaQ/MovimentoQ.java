/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaQ;

import DTO.Movimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class MovimentoQ {
    private final Connection connection;

    public MovimentoQ(Connection connection) {
        this.connection = connection;
    }
    
    public void movimento(Movimento mov) throws SQLException {
        String sql = "insert into movimento(tipo, quantidade, id_conta) "
                + "values(?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, mov.getTipo());
        pst.setDouble(2, mov.getQuantidade());
        pst.setInt(3, mov.getIdConta());
        pst.execute();
    }
    
    private ArrayList<Movimento> pesquisa(PreparedStatement pstate) throws SQLException {
        ArrayList<Movimento> movimentos = new ArrayList<>();
        pstate.execute();
        ResultSet resultSet = pstate.getResultSet();
        
        while(resultSet.next()) {
            int id = resultSet.getInt("idMovimento");
            double quantidade = resultSet.getDouble("quantidade");
            String tipo = resultSet.getString("tipo");
            int idConta = resultSet.getInt("id_conta");
            
            Movimento movimento = new Movimento(id, tipo, quantidade, idConta);
            movimentos.add(movimento);
        }
        
        return movimentos;
    }
    
    public ArrayList<Movimento> pesquisarTudo() throws SQLException {
        String sql = "select * from movimento";
        PreparedStatement pst = connection.prepareStatement(sql);
        return pesquisa(pst);
    }
    
    public ArrayList<Movimento> pesquisarIdConta(Movimento mov) throws SQLException {
        String sql = "select * from movimento where id_conta = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setInt(1, mov.getIdConta());
        return pesquisa(pst);
    }
}