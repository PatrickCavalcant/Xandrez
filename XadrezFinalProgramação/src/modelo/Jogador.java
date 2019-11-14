
package modelo;

import java.awt.Color;

/**
 *
 * @author Igor, Patrick, Wasller
 * 
 */
public class Jogador {
    
    /* nNome do jogador */
    public String nome;
    
    /* Cor do jogador */
    public Color cor;
    
    
    /** Cria uma nova instância do Player*/
    
    /**Cria uma nova instância do Player */
    public Jogador( String nome,Color cor) {
        this.setNome(nome);
        this.setCor(cor);
    }

    public Color getCor() {
        return cor;
    }
   
    public String getNome() {
        return nome;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
