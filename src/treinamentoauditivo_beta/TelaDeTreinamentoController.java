/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;

/**
 * FXML Controller class
 *
 * @author Humberto
 */
public class TelaDeTreinamentoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Usuario usuario;
    @FXML
    private Button play, continuar, sair;
    
    @FXML
    private Label contadorDeAcertos, msgDeAcertoOuErro;
    
    @FXML
    private ArrayList<ToolBar> listaDeToolBar;
    
    private int contador;
    
    public TelaDeTreinamentoController(Usuario usuario){
        this.usuario = usuario;
        this.usuario.getFase().mudarNota();
       
        
    }

    public Usuario getUsuario() {
        return usuario;
    }   
    
     @FXML
    private void play(ActionEvent event) {
         usuario.getFase().getNotaAtual().tocar();
         habilitarBotoes();         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        contador = Integer.parseInt(contadorDeAcertos.getText());
         for(int i=0; i < qntdeDeToolBar(); i++)
            listaDeToolBar.get(i).setVisible(true);
    }    

    @FXML
    private void botaoC(ActionEvent event) {
       String id = "C";
       verificaResposta(id);
    }

    @FXML
    private void botaoD(ActionEvent event) {
        String id = "D";
       verificaResposta(id);
    }

    @FXML
    private void botaoE(ActionEvent event) {
        String id = "E";
       verificaResposta(id);
    }

    @FXML
    private void botaoG(ActionEvent event) {
        String id = "G";
       verificaResposta(id);
    }

    @FXML
    private void botaoG_Sust(ActionEvent event) {
        String id = "G_Sust";
       verificaResposta(id);
    }

    @FXML
    private void botaoF(ActionEvent event) {
        String id = "F";
       verificaResposta(id);
    }

    @FXML
    private void botaoA(ActionEvent event) {
        String id = "A";
       verificaResposta(id);
    }

    @FXML
    private void botaoB(ActionEvent event) {
        String id = "B";
       verificaResposta(id);
    }

    @FXML
    private void botaoD_Sust(ActionEvent event) {
        String id = "D_Sust";
       verificaResposta(id);
    }

    @FXML
    private void botaoC_Sust(ActionEvent event) {
        String id = "C_Sust";
       verificaResposta(id);
    }

    @FXML
    private void botaoA_Sust(ActionEvent event) {
        String id = "A_Sust";
       verificaResposta(id);
    }
    @FXML
    private void botaoSair(ActionEvent event){
        this.usuario.salvarFase();
        System.exit(0);
        
    }
    @FXML
    private void botaoContinuar(ActionEvent event) {
        
        if((this.usuario.getFase().getCodigo()==24) && (contador==10)){
            for(int i=0; i < qntdeDeToolBar(); i++)
            listaDeToolBar.get(i).setVisible(false);
            
         play.setVisible(false);
         continuar.setVisible(false); 
         msgDeAcertoOuErro.setText("Parabens! Você Finalizou o treino.");
         return;
        }
        if(contador==10){
            int fase = this.usuario.getFase().getCodigo();
            this.usuario.getFase().setCodigo(fase + 3);
            this.usuario.salvarFase();
            
            for(int i=0; i < qntdeDeToolBar(); i++)
            listaDeToolBar.get(i).setVisible(true);
            
           
           contadorDeAcertos.setText(String.valueOf(0));
           this.usuario.getFase().mudarNota();
           play.setDisable(false);
           msgDeAcertoOuErro.setText("");
           continuar.setVisible(false);
            
        }else{
        this.usuario.getFase().mudarNota();
        play.setDisable(false);
        msgDeAcertoOuErro.setText("");
        continuar.setVisible(false);
        return;
        }
        contador=0;
    }
    
  
   private void habilitarBotoes(){
       
       play.setDisable(false);
       for(int i = 0; i < qntdeDeToolBar(); i++)
             listaDeToolBar.get(i).setDisable(false);
       
   }
   
   private void desabilitarBotoes(){
       
       play.setDisable(true);
       for(int i = 0; i < qntdeDeToolBar(); i++)
             listaDeToolBar.get(i).setDisable(true);
       
   }
   private void verificaResposta(String id){
       
        this.desabilitarBotoes();
       if(id.equals(this.usuario.getFase().getNotaAtual().getRespostaCerta())){
           contador ++;
           contadorDeAcertos.setText(String.valueOf(contador));
           if(contador==10){
               continuar.setVisible(true);
               msgDeAcertoOuErro.setText("Parabéns! Você avançou de nível. Clique no Botão para Continuar.");
           } else{
           continuar.setVisible(true);
           msgDeAcertoOuErro.setText("Você Acertou! Clique no Botão para Continuar.");
                       }
       }else{
           contador=0;
           contadorDeAcertos.setText(String.valueOf(contador));
           continuar.setVisible(true);
           msgDeAcertoOuErro.setText("Você Errou! Clique no Botão para Continuar.");
       }
   }
   private int qntdeDeToolBar(){
       
       if(this.usuario.getFase().getCodigo() > 12)
           return 12;
       return this.usuario.getFase().getCodigo();
   }
}
