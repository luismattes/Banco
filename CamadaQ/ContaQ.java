/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaQ;

import DTO.Conta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class ContaQ {
    
    private final Connection connection;
    
    public ContaQ(Connection connection) {
        this.connection = connection;
    }
    
    public void Incluir(Conta conta) throws SQLException {
        String sql = "insert into conta(data_cadastro, saldo, limite, tipo_conta,"
                + "senha) values(?,?,?,?,?)";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setDate(1, conta.Get_data_cadastro());
        pstate.setDouble(2, conta.Get_saldo());
        pstate.setDouble(3, conta.Get_limite());
        pstate.setString(4, conta.Get_tipo_conta());
        pstate.setString(5, conta.Get_senha());
        pstate.execute();           
    }
    
    public void Atualizar(Conta conta) throws SQLException {
        String sql = "update conta set data_cadastro = ?, saldo = ?, limite = ?,"
                + " tipo_conta = ?,senha = ? where id_conta = ?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1, conta.Get_data_cadastro().toString());
        pstate.setString(2, conta.Get_saldo() + "");
        pstate.setString(3, conta.Get_limite() + "");
        pstate.setString(4, conta.Get_tipo_conta());
        pstate.setString(5, conta.Get_senha());
        pstate.execute();
    }
    
    public void Deletar(Conta conta) throws SQLException {
        String sql = "delete from conta where id_conta = ?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setInt(1, conta.Get_id_conta());
        pstate.execute();
    }
    
    public ArrayList<Conta> PesquisarTudo() throws SQLException {
        String sql = "select * from conta";
        PreparedStatement pstate = connection.prepareStatement(sql);
        return Pesquisar(pstate);
    }

    private ArrayList<Conta> Pesquisar(PreparedStatement pstate) throws SQLException {
        ArrayList<Conta> conta = new ArrayList<Conta>();
        pstate.execute();
        ResultSet resultSet = pstate.getResultSet();
        while(resultSet.next()) {
            int id_conta = resultSet.getInt("id_conta");
            Date data_cadastro = resultSet.getDate("data_cadastro");
            double saldo = resultSet.getDouble("saldo");
            double limite = resultSet.getDouble("limite");
            String tipo_conta = resultSet.getString("tipo_conta");
            String senha = resultSet.getString("senha");
            
            Conta contaComDados = new Conta(id_conta,data_cadastro,saldo,limite,
            tipo_conta,senha);
            conta.add(contaComDados);
        }
        return conta;
    }
    
    public ArrayList<Conta> PesquisarIdSenha(int id, String senha) throws SQLException {
        String sql = "select * from conta where id_conta = ? and senha = ?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setInt(1, id);
        pstate.setString(2, senha);
        return Pesquisar(pstate);
    }
    
    public ArrayList<Conta> PesquisarId(Conta conta) throws SQLException {
        String sql = "select * from conta where id_conta = ?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setInt(1, conta.Get_id_conta());
        return Pesquisar(pstate);
    }
    
    public void movimento(Conta conta) throws SQLException {
        String sql = "update conta set saldo = ?, limite = ? where id_conta = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setDouble(1, conta.Get_saldo());
        pst.setDouble(2, conta.Get_limite());
        pst.setInt(3, conta.Get_id_conta());
        pst.execute();
    }
    
    public void movimento(Conta conta1, Conta conta2) throws SQLException {
        String sql = "update conta set saldo = ?, limite = ? where id_conta = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setDouble(1, conta1.Get_saldo());
        pst.setDouble(2, conta1.Get_limite());
        pst.setInt(3, conta1.Get_id_conta());
        pst.execute();
        pst.setDouble(1, conta2.Get_saldo());
        pst.setDouble(2, conta2.Get_limite());
        pst.setInt(3, conta2.Get_id_conta());
        pst.execute();
    }
}
