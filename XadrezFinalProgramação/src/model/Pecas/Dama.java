
package model.Pecas;

import java.awt.Color;
import java.util.*;
import modelo.Tabuleiro;
import modelo.Xadrez;
import modelo.Pecas;
import modelo.Posicao;

public class Dama extends Pecas {
    
    /** Cria uma nova instância da rainha */
    public Dama(Color cor) {
        super("dama",cor);
    }
    
    /** Cria uma nova instância da rainha*/
    public Dama(Color cor, Posicao pos) {
        super("dama",cor,pos);
    }
    
    /**
     *  Retorna a relacão de posições(caminho) a
     * serem percorridas para alcançar o destino
     */
    public ArrayList <Posicao> getPath(Posicao destino){
        
        ArrayList <Posicao> path = null;
        Posicao posicaoAtual = this.getPosicao();
        
        if (!destino.equals(posicaoAtual)) {
            /* verifica se utilizará o movimento de torre */
            if ((destino.getY() == posicaoAtual.getY()) ||
                    (destino.getX() == posicaoAtual.getX()) ){
                Torre r = (new Torre(Color.PINK));
                r.setPosicao(this.getPosicao());
                path = r.getPath(destino);
            } else {
                /* ira utilizar o movimento de bispo */
                Bispo b = (new Bispo(Color.PINK));
                b.setPosicao(this.getPosicao());
                path = b.getPath(destino);
            }
        }
        
        return path;
    }
    
    /* Dama nao utiliza este metodo */
    public ArrayList <Posicao> getPath(Posicao destino,Tabuleiro board) {
        return null;
    }
    public ArrayList<Posicao> getPath(Posicao destino, Xadrez chess) {
        return null;
    }
    
    /* Implementar metodos das jogadas possiveis.. getters and setters etc */
    
}
