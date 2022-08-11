/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CamadaS;

import CamadaW.ContaCadastroW;
import CamadaW.ContaPesquisaW;
import CamadaW.InicioW;
import CamadaW.PrincipalW;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Luis
 */
public class InicioS {
    private InicioW view;

    public InicioS(InicioW view) {
        this.view = view;
    }

    public void AbrirCadastro() {
        ContaCadastroW cadastro = new ContaCadastroW();
        cadastro.setVisible(true);
    }
    
    public void AbrirPrincipal() {
        PrincipalW principal = new PrincipalW();
        principal.setVisible(true);
    }
    
    public boolean ValidaConta() {
        String id = this.view.getjTextFieldIdConta().getText();
        String senha = this.view.getjPasswordFieldSenha().getText();
        if (id.isEmpty() || senha.isEmpty()) {
            return false;
        }
        senha = criptografar(senha);
        ContaPesquisaW contaW = new ContaPesquisaW();
        ContaPesquisaS contaS = new ContaPesquisaS(contaW);
        return contaS.SearchContaIdSenha(Integer.parseInt(id), senha).size() > 0;
    }
    
    private String criptografar(String senha) {
        String retorno = "";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            BigInteger bi = new BigInteger(1, md.digest(senha.getBytes()));
            retorno = bi.toString(16);
        } catch(Exception e) {
            
        }
        return retorno;
    }
}
