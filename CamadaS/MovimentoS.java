/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaQ.Conexao;
import CamadaQ.ContaQ;
import CamadaQ.MovimentoQ;
import CamadaW.Deposito;
import CamadaW.Retirada;
import CamadaW.Transferencia;
import DTO.Conta;
import DTO.Movimento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class MovimentoS {
    private Deposito deposito;
    private Retirada retirada;
    private Transferencia transferencia;

    public MovimentoS(Deposito deposito, Retirada retirada, Transferencia transferencia) {
        this.deposito = deposito;
        this.retirada = retirada;
        this.transferencia = transferencia;
    }
    
    public void deposito() {
        if (deposito != null) {
            int idConta = Integer.parseInt(deposito.getJTextFieldNumConta().
                    getText().trim());
            double valor = Double.parseDouble(deposito.getJTextFieldValor().
                    getText().trim());
            Conta conta = new Conta(idConta);
            Movimento movimento = new Movimento("deposito", valor, idConta);
            try {
                Connection conexao = new Conexao().getConnection();
                ContaQ contaDao = new ContaQ(conexao);
                MovimentoQ movimentoDao = new MovimentoQ(conexao);
                conta = contaDao.PesquisarId(conta).get(0);
                conta.Set_saldo(conta.Get_saldo() + valor);
                contaDao.movimento(conta);
                movimentoDao.movimento(movimento);
                JOptionPane.showMessageDialog(null, "Deposito efetivado!");
            } catch (SQLException ex) {
                Logger.getLogger(MovimentoS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void retirada() {
        if (retirada != null) {
            int idConta = Integer.parseInt(retirada.getJTextFieldIdConta().
                    getText().trim());
            double valor = Double.parseDouble(retirada.getJTextFieldValor().
                    getText().trim());
            Conta conta = new Conta(idConta);
            Movimento movimento = new Movimento("retirada", valor, idConta);
            try {
                Connection conexao = new Conexao().getConnection();
                ContaQ contaDao = new ContaQ(conexao);
                MovimentoQ movimentoDao = new MovimentoQ(conexao);
                conta = contaDao.PesquisarId(conta).get(0);
                if (conta.Get_saldo() + conta.Get_limite() >= valor) {
                    conta.Set_saldo(conta.Get_saldo() - valor);
                    contaDao.movimento(conta);
                    movimentoDao.movimento(movimento);
                    JOptionPane.showMessageDialog(null, "Retirada efetivada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Conta não possui saldo "
                            + "suficiente!\n Saldo atual: " + conta.Get_saldo());
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovimentoS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void transferencia() {
        if (transferencia != null) {
            int idConta1 = Integer.parseInt(transferencia.getJTextFieldConta1().
                    getText().trim());
            double valor = Double.parseDouble(transferencia.getJTextFieldValor().
                    getText().trim());
            int idConta2 = Integer.parseInt(transferencia.getJTextFieldConta2().
                    getText().trim());
            Conta conta1 = new Conta(idConta1);
            Conta conta2 = new Conta(idConta2);
            Movimento movimento1 = new Movimento("transferencia envio", valor, idConta1);
            Movimento movimento2 = new Movimento("transferencia recebida", valor, idConta2);
            try {
                Connection conexao = new Conexao().getConnection();
                ContaQ contaDao = new ContaQ(conexao);
                MovimentoQ movimentoDao = new MovimentoQ(conexao);
                conta1 = contaDao.PesquisarId(conta1).get(0);
                conta2 = contaDao.PesquisarId(conta2).get(0);
                if (conta1.Get_saldo() + conta1.Get_limite() >= valor) {
                    conta1.Set_saldo(conta1.Get_saldo() - valor);
                    conta2.Set_saldo(conta2.Get_saldo() + valor);
                    contaDao.movimento(conta1, conta2);
                    movimentoDao.movimento(movimento1);
                    movimentoDao.movimento(movimento2);
                    JOptionPane.showMessageDialog(null, "Transferencia efetivada!");
                } else {
                    JOptionPane.showMessageDialog(null, "Conta não possui saldo "
                            + "suficiente!\n Saldo atual: " + conta1.Get_saldo());
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovimentoS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
