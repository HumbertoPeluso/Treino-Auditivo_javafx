/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class TelaDeCadastroController implements Initializable {



    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Button cadastrar;
    @FXML
    private Button voltar;
    @FXML
    private TextField cadastroNomeUsuario, cadastroEmail;
    @FXML
    private TextField cadastroSenha, repetirSenha;
    private Label msgTelaDeCadastro;
    
    @FXML
    private void cadastrar(ActionEvent evento) throws ParseException{
        
        if((nomeDoUsuarioValido(cadastroNomeUsuario.getText())) && (emailValido(cadastroEmail.getText())) && senhaValida(cadastroSenha.getText(), repetirSenha.getText())){
        VerificadorDeDados gravaCadastro = new VerificadorDeDados();
        
        msgTelaDeCadastro.setText(gravaCadastro.salvarCadastro(cadastroNomeUsuario.getText(), cadastroEmail.getText(), cadastroSenha.getText(), "3"));
        } else{
            msgTelaDeCadastro.setText("Erro no preenchimnto dos dados.");
        }
    }
    
    @FXML
    private void voltar(ActionEvent evento) throws IOException{
        
        Cenario cenario = new Cenario();
        cenario.mudar("telaDeLogin.fxml", evento);
    }
    
    public boolean nomeDoUsuarioValido(String cadastroNomeUsuario){
        
        return cadastroNomeUsuario != null;
    }
    
    public boolean emailValido(String email ){
    
    Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
    Matcher m = p.matcher(email); 
    if (m.find()){
      
      return true;
    }
    else{
      
      return false;
     
 }
   
    }
    
     public boolean senhaValida(String senha, String repetirSenha){
        return senha !=null && senha.equals(repetirSenha);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
