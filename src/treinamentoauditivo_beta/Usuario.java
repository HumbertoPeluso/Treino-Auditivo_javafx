/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

/**
 *
 * @author Humberto
 */
public class Usuario {
    
    private String userName;
private String email;
private String senha;
private Fase fase = new Fase();
private int codigo;
private boolean logado = false;
private Usuario usuario;

    public Usuario(String userName, String email, String senha, String codigo) {
        this.userName = userName;
        this.email = email;
        this.senha = senha;
        this.codigo =Integer.parseInt(codigo);
        fase.setCodigo(this.codigo);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Fase getFase() {
        return fase;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }
    
  

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    public void salvarFase(){
        VerificadorDeDados salvar = new VerificadorDeDados();
        salvar.salvarFase(this);
    }
    
}
