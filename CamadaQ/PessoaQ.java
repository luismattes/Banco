/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaQ;

import DTO.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class PessoaQ {
    private final Connection connection;
    
    public PessoaQ(Connection connection) {
        this.connection = connection;
    }
    
    public void Incluir(Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoa(cpf_cnpj,nome_pessoa,contato,"
                + "tipo_pessoa) values (?,?,?,?)";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1, pessoa.Get_cpf_cnpj());
        pstate.setString(2, pessoa.Get_nome_pessoa());
        pstate.setString(3, pessoa.Get_contato());
        pstate.setString(4, pessoa.Get_tipo_pessoa());
        pstate.execute();
    }
    
    public void Atualizar(Pessoa pessoa) throws SQLException {
        String sql = "update pessoa set nome_pessoa = ?, contato = ? "
                + "where cpf_cnpj = ? ";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1, pessoa.Get_nome_pessoa());
        pstate.setString(2, pessoa.Get_contato());
        pstate.setString(3, pessoa.Get_cpf_cnpj());
        pstate.execute();
    }
    
    public void Deletar(Pessoa pessoa) throws SQLException {
        String sql = "delete from pessoa where cpf_cnpj = ?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1, pessoa.Get_cpf_cnpj());
        pstate.execute();
    }
    
    public ArrayList<Pessoa> PesquisarTudo() throws SQLException {
        String sql = "select * from pessoa";
        PreparedStatement pstate = connection.prepareStatement(sql);
        return Pesquisar(pstate);
    }

    public ArrayList<Pessoa> Pesquisar(PreparedStatement pstate) throws SQLException {
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        pstate.execute();
        ResultSet resultSet = pstate.getResultSet();
        while(resultSet.next()) {
            String cpfCnpj = resultSet.getString("cpf_cnpj");
            String nome = resultSet.getString("nome_pessoa");
            String telefone = resultSet.getString("contato");
            String tipo_pessoa = resultSet.getString("tipo_pessoa");
            
            Pessoa pessoaComDados = new Pessoa(cpfCnpj,nome,telefone,tipo_pessoa);
            pessoa.add(pessoaComDados);
        }
        return pessoa;
    }
    
    public ArrayList<Pessoa> PesquisarId(Pessoa pessoa) throws SQLException {
        String sql = "select * from pessoa where cpf_cnpj = ?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1, pessoa.Get_cpf_cnpj());
        return Pesquisar(pstate);
    }
}
