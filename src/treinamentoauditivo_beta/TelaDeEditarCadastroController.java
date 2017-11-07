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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Humberto
 */
public class TelaDeEditarCadastroController implements Initializable {

    private Usuario usuario;
    @FXML
    private Button salvar;
    @FXML
    private TextField cadastroNomeUsuario;
    
    @FXML
    private PasswordField senha;
    @FXML
    private Label msgEdicaoCadastro;
    
    @FXML
    private Button voltar;

    /**
     * Initializes the controller class.
     */
    
    public TelaDeEditarCadastroController(Usuario usuario) {
        
        this.usuario = usuario;
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void botaoSalvar(ActionEvent event) {
        
        String edUserName = cadastroNomeUsuario.getText();
        String edSenha = senha.getText();
        String edFase = String.valueOf(this.usuario.getFase().getCodigo());
        VerificadorDeDados salvar = new VerificadorDeDados();
        salvar.salvarEdicao(usuario, edUserName, edSenha, edFase);
        msgEdicaoCadastro.setText("DadosSalvos!");
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        TelaPreparacaoIniciarController telaPreparacaoIniciar = new TelaPreparacaoIniciarController(this.usuario);
        Cenario cenario = new Cenario();
        cenario.mudar("telaPreparacaoIniciar.fxml", event, telaPreparacaoIniciar);
    }
    
}
