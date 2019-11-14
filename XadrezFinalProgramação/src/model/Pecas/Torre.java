

package model.Pecas;

import java.awt.Color;
import java.util.*;
import modelo.Tabuleiro;
import modelo.Xadrez;
import modelo.Pecas;
import modelo.Posicao;

public class Torre extends Pecas {
    
    /* rook attributes */
    boolean naoSeMoveuAinda;
    
    /** criando nova instancia de roque */
    public Torre(Color cor) {
        super("torre",cor);
    }
    
     /** criando nova instancia de roque */
    public Torre(Color cor, Posicao pos) {
        super("torre",cor,pos);
        this.setNaoSeMoveuAinda(true);
    }
    
    public boolean isNaoSeMoveuAinda() {
        return naoSeMoveuAinda;
    }
    
    public void setNaoSeMoveuAinda(boolean naoSeMoveuAinda) {
        this.naoSeMoveuAinda = naoSeMoveuAinda;
    }
    
    
    /**
     *  Retorna a relacão de posições(caminho) a
     * serem percorridas para alcançar o destino
     */
    public ArrayList <Posicao> getPath(Posicao destino){
        ArrayList <Posicao> path = null;
        Posicao posicaoAtual = this.getPosicao();
        if (!destino.equals(posicaoAtual)) {
            int offset = 1;            
            /* verifica se ele nao esta querendo se mover para a mesma
             * posicao atual (no caso da verificacao de xeque-mate */
            
            /* movimento vertical da torre */
            if (destino.getY() == posicaoAtual.getY()) {
                /* cria o caminho */
                path = new ArrayList <Posicao> ();
                
                /* determina a direcao a ser percorrida */
                if (destino.getX() < posicaoAtual.getX()) offset = -1;
                
                /* adiciona as posicoes do caminho */
                int x;
                for (x=posicaoAtual.getX()+offset; x != destino.getX(); x+=offset) {
                    path.add(new Posicao(x,destino.getY()));
                }
                path.add(new Posicao(x,destino.getY()));
            } else if (destino.getX() == posicaoAtual.getX()) {
                /* movimento horizontal da torre */
                /* cria o caminho */
                path = new ArrayList <Posicao> ();
                
                /* determina a direcao a ser percorrida */
                if (destino.getY() < posicaoAtual.getY()) offset*= -1;
                
                /* adiciona as posicoes do caminho */
                int y;
                for (y=posicaoAtual.getY()+offset; y != destino.getY(); y+=offset) {
                    path.add(new Posicao(destino.getX(),y));
                }
                path.add(new Posicao(destino.getX(),y));
            }
        }
        
        if (path != null) {
            this.setNaoSeMoveuAinda(false);
        }
        return path;
    }
    
    /* Torre nao utiliza este metodo */
    public ArrayList <Posicao> getPath(Posicao destino,Tabuleiro board) {
        return null;
    }
    public ArrayList<Posicao> getPath(Posicao destino, Xadrez chess) {
        return null;
    }
    
    /* Implementar metodos das jogadas possiveis.. getters and setters etc */
    
}
