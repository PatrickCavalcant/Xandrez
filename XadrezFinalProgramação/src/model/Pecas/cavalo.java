

package model.Pecas;

import java.awt.Color;
import java.util.*;
import modelo.Tabuleiro;
import modelo.Xadrez;
import modelo.Pecas;
import modelo.Posicao;


public class cavalo extends Pecas {
    
    /**
     * Cria uma nova instância do Knight
     */
    public cavalo(Color cor) {
        super("cavalo",cor);
    }
    
    /**
     * Cria uma nova instância do Knight
     */
    public cavalo(Color cor, Posicao pos) {
        super("cavalo",cor,pos);
    }
    
    /**
     *  Retorna a relacão de posições(caminho) a
     * serem percorridas para alcançar o destino
     */
    public ArrayList <Posicao> getPath(Posicao destino){
        
        ArrayList <Posicao> path = null;
        Posicao posicaoAtual = this.getPosicao();
        if (!destino.equals(posicaoAtual)) {
            
            Color c1 = this.getCorDaPosicaoDoTabuleiro(posicaoAtual.getX(),posicaoAtual.getY());
            Color c2 = this.getCorDaPosicaoDoTabuleiro(destino.getX(),destino.getY());
            
            /* o cavalo sempre muda de cor ao se movimentar */
            if (c1 != c2) {
                int difY = Math.abs(destino.getY()-posicaoAtual.getY());
                int difX = Math.abs(destino.getX()-posicaoAtual.getX());
                
                /* verifica se esta fazendo um L */
                if (((difX==2)&&(difY==1)) || ((difX==1) && (difY ==2))) {
                    path = new ArrayList <Posicao> ();
                    path.add(destino);
                }
            }
        }
        return path;
    }
    
    public Color getCorDaPosicaoDoTabuleiro(int x,int y) {
        if (((x+y)%2) == 0) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }
    
    /* Cavalo nao utiliza este metodo */
    public ArrayList <Posicao> getPath(Posicao destino,Tabuleiro board) {
        return null;
    }
    public ArrayList<Posicao> getPath(Posicao destino, Xadrez chess) {
        return null;
    }
    
    /* Implementar metodos das jogadas possiveis.. getters and setters etc */
    
}
