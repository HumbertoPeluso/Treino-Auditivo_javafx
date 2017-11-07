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
public class NotaMusical {
    
    private String caminho;
    private String respostaCerta;
    private Player player;

    public NotaMusical(String caminho, String respostaCerta, Player player) {
        this.caminho = caminho;
        this.respostaCerta = respostaCerta;
        this.player = player;
    }
    
    public void tocar (){
        player.play(this.caminho);
    }

    public String getRespostaCerta() {
        return respostaCerta;
    }
    
}
