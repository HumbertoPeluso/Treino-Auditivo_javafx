/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Humberto
 */
public class TelaPreparacaoIniciarController implements Initializable {


    /**
     * Initializes the controller class.
     */
    private Usuario usuario;
    
   
   @FXML
    private Button iniciar,sair;
    
    public TelaPreparacaoIniciarController(Usuario usuario){
        this.usuario = usuario;
    }
    
    
    @FXML
    private void iniciar(ActionEvent evento) throws IOException{
        TelaDeTreinamentoController telaDeTreinamento = new TelaDeTreinamentoController(this.usuario);
        Cenario cenario = new Cenario();
        cenario.mudar("telaDeTreinamento.fxml", evento, telaDeTreinamento);
        
    }
    @FXML
    private void botaoEditarCadastro(ActionEvent evento) throws IOException{
        
        TelaDeEditarCadastroController telaDeEditarCadastro = new TelaDeEditarCadastroController(this.usuario);
        Cenario cenario = new Cenario();
        cenario.mudar("telaDeEditarCadastro.fxml", evento, telaDeEditarCadastro);
    }
    @FXML
    private void botaoSair(){
        System.exit(0);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
