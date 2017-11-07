/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Humberto
 */
public class Fase {
    
    private int codigo;
    private NotaMusical notaAtual;
    private ArrayList<NotaMusical> listaDeNotas = new ArrayList<NotaMusical>();
    private Player player = new Player();

    public Fase() {
        
                NotaMusical c4 = new NotaMusical("Sons//C4.wav", "C", player);
                NotaMusical d4 = new NotaMusical("Sons//D4.wav", "D", player);
                NotaMusical e4 = new NotaMusical("Sons//E4.wav", "E", player);
                NotaMusical f4 = new NotaMusical("Sons//F4.wav", "F", player);
                NotaMusical g4 = new NotaMusical("Sons//G4.wav", "G", player);
                NotaMusical a4 = new NotaMusical("Sons//A4.wav", "A", player);
                NotaMusical b4 = new NotaMusical("Sons//B4.wav", "B", player);
                NotaMusical c4_Sust = new NotaMusical("Sons//C4_Sust.wav", "C_Sust", player);
                NotaMusical d4_Sust = new NotaMusical("Sons//D4_Sust.wav", "D_Sust", player);
                NotaMusical f4_Sust = new NotaMusical("Sons//F4_Sust.wav", "F_Sust", player);
                NotaMusical g4_Sust = new NotaMusical("Sons//G4_Sust.wav", "G_Sust", player);
                NotaMusical a4_Sust = new NotaMusical("Sons//A4_Sust.wav", "A_Sust", player);
                NotaMusical c2 = new NotaMusical("Sons//C2.wav", "C", player);
                NotaMusical d2 = new NotaMusical("Sons//D2.wav", "D", player);
                NotaMusical e2 = new NotaMusical("Sons//E2.wav", "E", player);
                NotaMusical f2 = new NotaMusical("Sons//F2.wav", "F", player);
                NotaMusical g2 = new NotaMusical("Sons//G2.wav", "G", player);
                NotaMusical a2 = new NotaMusical("Sons//A2.wav", "A", player);
                NotaMusical b2 = new NotaMusical("Sons//B2.wav", "B", player);
                NotaMusical c2_Sust = new NotaMusical("Sons//C2_Sust.wav", "C_Sust", player);
                NotaMusical d2_Sust = new NotaMusical("Sons//D2_Sust.wav", "D_Sust", player);
                NotaMusical f2_Sust = new NotaMusical("Sons//F2_Sust.wav", "F_Sust", player);
                NotaMusical g2_Sust = new NotaMusical("Sons//G2_Sust.wav", "G_Sust", player);
                NotaMusical a2_Sust = new NotaMusical("Sons//A2_Sust.wav", "A_Sust", player);
                
                listaDeNotas.add(c4);
                listaDeNotas.add(d4);
                listaDeNotas.add(e4);
                listaDeNotas.add(f4);
                listaDeNotas.add(g4);
                listaDeNotas.add(a4);
                listaDeNotas.add(b4);
                listaDeNotas.add(c4_Sust);
                listaDeNotas.add(d4_Sust);
                listaDeNotas.add(f4_Sust);
                listaDeNotas.add(g4_Sust);
                listaDeNotas.add(a4_Sust);
                listaDeNotas.add(c2);
                listaDeNotas.add(d2);
                listaDeNotas.add(e2);
                listaDeNotas.add(f2);
                listaDeNotas.add(g2);
                listaDeNotas.add(a2);
                listaDeNotas.add(b2);
                listaDeNotas.add(c2_Sust);
                listaDeNotas.add(d2_Sust);
                listaDeNotas.add(f2_Sust);
                listaDeNotas.add(g2_Sust);
                listaDeNotas.add(a2_Sust);
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
        
         
    }

    public NotaMusical getNotaAtual() {
        return notaAtual;
    }


    public ArrayList<NotaMusical> getListaDeNotas() {
        return listaDeNotas;
    }

    public void mudarNota(){
        Random aleatorio = new Random();
        int indice = aleatorio.nextInt(this.getCodigo());
        this.notaAtual = listaDeNotas.get(indice);
      
    }
        
    
}
