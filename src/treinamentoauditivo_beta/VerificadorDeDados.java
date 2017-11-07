/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Humberto
 */
public class VerificadorDeDados {
    
    private String userNameValido;
    private String emailValido;
    private String senhaValida;
    private String fase="3";
    //private String conteudo;
    private String caminho = "Salvar//SaveFile.ta";
    private Usuario usuarioLogado;
    
    private void Ler(String email, String senha) throws ParseException{
        
        BasicTextEncryptor bte = new BasicTextEncryptor();
        bte.setPassword("codigoCriptografia");
        
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            
            try {
                //this.conteudo = "";
                linha = lerArq.readLine();
                
                while(linha!=null){
                    // Loop onde se captura os dados do arquivo texto e instancia as classes em seus respectivos objetos
                    
                   String userNameDoArquivo = bte.decrypt(linha.split(" ")[0]);
                   String emailDoArquivo = bte.decrypt(linha.split(" ")[1]);
                   String senhaDoArquivo = bte.decrypt(linha.split(" ")[2]);
                   String faseDoArquivo = bte.decrypt(linha.split(" ")[3]);
//                   String userNameDoArquivo = linha.split("/")[0];
//                   String emailDoArquivo = linha.split("/")[1];
//                   String senhaDoArquivo = linha.split("/")[2];
//                   String faseDoArquivo = linha.split("/")[3];
                   
                   
                           if((emailDoArquivo.equals(email)) && (senhaDoArquivo.equals(senha))){
                               
                               
                                   
                                   this.setUserNameValido(userNameDoArquivo);
                                   if(email != null) this.setEmailValido(email);
                                   if(senha != null)this.setSenhaValida(senha);
                                   this.setFase(faseDoArquivo);           
                               
                           } 
                           
                           if((emailDoArquivo.equals(email)) && (senha.equals("TCC_TreinamentoAuditivo"))){
                               
                               if(email != null) this.setEmailValido(email);
                               this.setSenhaValida(senhaDoArquivo);
                           }
                      
                   
                    //conteudo += linha+"\r\n";
                    linha = lerArq.readLine();
                }
                
                
                arq.close();
           
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
               
            }
        } catch (FileNotFoundException ex) {
            //System.out.println("Erro: Arquivo não encontrado!");
           
        }
       
    }

    public String getUserNameValido() {
        return userNameValido;
    }

    public void setUserNameValido(String userNameValido) {
        this.userNameValido = userNameValido;
    }

    public String getEmailValido() {
        return emailValido;
    }

    public void setEmailValido(String emailValido) {
        this.emailValido = emailValido;
    }

    public String getSenhaValida() {
        return senhaValida;
    }

    public void setSenhaValida(String senhaValida) {
        this.senhaValida = senhaValida;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }
    
    private void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }
    public Usuario getUsuarioLogado(){
        return this.usuarioLogado;
    }

    public String salvarCadastro(String userName, String email, String senha, String codigoFase) throws ParseException{
        
        this.Ler(email, senha);
        
        if((this.userNameValido==null) && (this.emailValido==null) && (this.senhaValida==null)){
        
                BasicTextEncryptor bte = new BasicTextEncryptor();
                bte.setPassword("codigoCriptografia");
                
                String userNameCriptografado = bte.encrypt(userName);
                String emailCriptografado = bte.encrypt(email);
                String senhaCriptografada= bte.encrypt(senha);
                String faseCriptografada = bte.encrypt(codigoFase);
//                String userNameCriptografado = userName;
//                String emailCriptografado = email;
//                String senhaCriptografada= senha;
//                String faseCriptografada = fase;
                
            try {
                try (FileWriter arquivo = new FileWriter(caminho, true)) {
                    PrintWriter escreverArquivo = new PrintWriter(arquivo);
                    
                    
                    escreverArquivo.println(userNameCriptografado + " " + emailCriptografado + " " + senhaCriptografada + " " + faseCriptografada);
                    
                     return "Usuario Salvo Com Sucesso";
                    
                }
            }catch(IOException e){
//                System.out.print("erro");
                  return "Erro na gravação dos dados!";
            }

        
    }else {
//    System.out.println("Conta já Cadastrada. ");
       return "Conta já Cadastrada!";
}
    } 
    
    public boolean verificaLogin(String email, String senha) throws ParseException{
       
        this.Ler(email, senha);
        
        if(this.senhaValida!=null){
        Usuario usuario = new Usuario(userNameValido, emailValido, senhaValida, fase);
        
        if(usuario.getSenha() != null) usuario.setLogado(true);
        
        setUsuarioLogado(usuario);
        return usuario.isLogado();
        }
        return false;
    }
    
    public boolean existeEmail(String email) throws ParseException{
        
        this.Ler(email, "TCC_TreinamentoAuditivo");
        
        return this.getEmailValido() != null;
    }
    
    public void salvarFase(Usuario usuario){
        
        String nomeDeUsuario = usuario.getUserName();
        String senha = usuario.getSenha();
        String fase = String.valueOf(usuario.getFase().getCodigo());
        
        salvarEdicao(usuario, nomeDeUsuario, senha, fase);
    }
    
    public void salvarEdicao(Usuario usuario, String edUserName, String edSenha, String edFase){
        String arquivoB = "Salvar//SaveFile_.ta";
        
        
         BasicTextEncryptor bte = new BasicTextEncryptor();
        bte.setPassword("codigoCriptografia");
        
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            
            try {
                
                linha = lerArq.readLine();
                
                while(linha!=null){
                    // Loop onde se captura os dados do arquivo texto e instancia as classes em seus respectivos objetos
                    
                   String userNameDoArquivo = bte.decrypt(linha.split(" ")[0]);
                   String emailDoArquivo = bte.decrypt(linha.split(" ")[1]);
                   String senhaDoArquivo = bte.decrypt(linha.split(" ")[2]);
                   String faseDoArquivo = bte.decrypt(linha.split(" ")[3]);

                   if(usuario.getEmail().equals(emailDoArquivo)){
                       if(edUserName==null)
                           userNameValido=userNameDoArquivo;
                       else
                           userNameValido=edUserName;
                       if(edSenha==null)
                           senhaValida=senhaDoArquivo;
                       else
                           senhaValida=edSenha;
                       emailValido=emailDoArquivo;
                       fase=edFase;
                       escreverNoArquivo(userNameValido, emailValido, senhaValida, fase, arquivoB);
                   }else{
                       escreverNoArquivo(userNameDoArquivo, emailDoArquivo, senhaDoArquivo, faseDoArquivo, arquivoB);
                   }
                   
                    //conteudo += linha+"\r\n";
                    linha = lerArq.readLine();
                }
                              
                arq.close();
                File file = new File(caminho);
                file.delete();
                File fileB = new File(arquivoB);
                fileB.renameTo(file);
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
               
            }
        } catch (FileNotFoundException ex) {
            
           
        }
        
    }
    
    private void escreverNoArquivo(String userName, String email, String senha, String codigoFase, String caminho){
        
        BasicTextEncryptor bte = new BasicTextEncryptor();
                bte.setPassword("codigoCriptografia");
                
                String userNameCriptografado = bte.encrypt(userName);
                String emailCriptografado = bte.encrypt(email);
                String senhaCriptografada= bte.encrypt(senha);
                String faseCriptografada = bte.encrypt(codigoFase);
//                String userNameCriptografado = userName;
//                String emailCriptografado = email;
//                String senhaCriptografada= senha;
//                String faseCriptografada = fase;
                
            try {
                try (FileWriter arquivo = new FileWriter(caminho, true)) {
                    PrintWriter escreverArquivo = new PrintWriter(arquivo);
                    
                    
                    escreverArquivo.println(userNameCriptografado + " " + emailCriptografado + " " + senhaCriptografada + " " + faseCriptografada);
                    
                     
                    
                }
            }catch(IOException e){
//                System.out.print("erro");
                  
            }
    }
    
}
