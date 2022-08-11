/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CamadaS;

import CamadaW.PessoaAlteracaoW;
import CamadaW.PessoaCadastroW;
import CamadaW.ContaAlteracaoW;
import CamadaW.ContaCadastroW;
import CamadaW.ContaPesquisaW;
import CamadaW.PessoaExclusaoW;
import CamadaW.PessoaPesquisarW;
import CamadaW.PrincipalW;
import CamadaW.Retirada;
import CamadaW.Transferencia;
import CamadaW.Deposito;
import CamadaW.MovimentoPesquisaW;

/**
 *
 * @author Luis
 */
public class PrincipalS {
    private PrincipalW view;

    public PrincipalS(PrincipalW view) {
        this.view = view;
    }
    
    public void AbrirCadastroCliente() {
        PessoaCadastroW cadastro = new PessoaCadastroW();
        cadastro.setVisible(true);
    }
    
    public void AbrirCadastroConta() {
        ContaCadastroW cadastro = new ContaCadastroW();
        cadastro.setVisible(true);
    }
    
    public void AbrirAlteracaoCliente() {
        PessoaAlteracaoW alteracao = new PessoaAlteracaoW();
        alteracao.setVisible(true);
    }
    
    public void AbrirAlteracaoConta() {
        ContaAlteracaoW alteracao = new ContaAlteracaoW();
        alteracao.setVisible(true);
    }
    
    public void AbrirExclusao() {
        PessoaExclusaoW exclusao = new PessoaExclusaoW();
        exclusao.setVisible(true);
    }
    
    public void AbrirPesquisaCliente() {
        PessoaPesquisarW pesquisa = new PessoaPesquisarW();
        pesquisa.setVisible(true);
    }
    
    public void AbrirPesquisaConta() {
        ContaPesquisaW pesquisa = new ContaPesquisaW();
        pesquisa.setVisible(true);
    }
    
    public void AbrirTransferencia() {
        Transferencia trans = new Transferencia();
        trans.setVisible(true);
    }
    
    public void AbrirRetirada() {
        Retirada ret = new Retirada();
        ret.setVisible(true);
    }
    
    public void AbrirDeposito() {
        Deposito dep = new Deposito();
        dep.setVisible(true);
    }
    
    public void abrirMovPesquisa() {
        MovimentoPesquisaW mov = new MovimentoPesquisaW();
        mov.setVisible(true);
    }
}
