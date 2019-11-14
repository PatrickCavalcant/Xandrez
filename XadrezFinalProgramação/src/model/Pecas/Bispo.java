/*
*Peao.java
 * Criado em novembro de 2018

 */

package model.Pecas;

import java.awt.Color;
import java.util.*;
import modelo.Tabuleiro;
import modelo.Xadrez;
import modelo.Pecas;
import modelo.Posicao;


public class Bispo extends Pecas {
    
    /** Cria uma nova instância de bispo*/
    public Bispo(Color cor) {
        super("bispo",cor);
    }
    
    /** Cria uma nova instância de bispo */
    public Bispo(Color cor, Posicao pos) {
        super("bispo",cor,pos);
    }
    
    /* Bispo nao utiliza este metodo */
    public ArrayList <Posicao> getPath(Posicao destino,Tabuleiro board){
        return null;
    }
    
    public Color getCorDaPosicaoDoTabuleiro(int x,int y) {
        if (((x+y)%2) == 0) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }
    
    
    /**
     *  Retorna a relacão de posições(caminho) a
     * serem percorridas para alcançar o destino
     */
    public ArrayList <Posicao> getPath(Posicao destino) {
        
        ArrayList <Posicao> path = null;
        Posicao posicaoAtual = this.getPosicao();
        
        if (!destino.equals(posicaoAtual)) {
            
            /* determina a cor das casas origem e destino */
            Color c1 = this.getCorDaPosicaoDoTabuleiro(posicaoAtual.getX(),posicaoAtual.getY());
            Color c2 = this.getCorDaPosicaoDoTabuleiro(destino.getX(),destino.getY());
            
            /* verifica se as casas tem a mesma cor */
            if (c1 == c2) {
                int l = Math.abs(destino.getX()-posicaoAtual.getX());
                int m = Math.abs(destino.getY()-posicaoAtual.getY());
                /* verifica se é um deslocamento em diagonal */
                if (l == m) {
                    /* - a cada casa q o bispo anda em X, deve andar uma  em Y, seguindo um offset */
                    int offsetX = 1;
                    int offsetY = 1;
                    /* determina a direcao do bispo "cima-baixo" "esquerda-direita" */
                    if (destino.getX() < posicaoAtual.getX()) offsetX *= -1;
                    if (destino.getY() < posicaoAtual.getY()) offsetY *= -1;
                    
                    path = new ArrayList <Posicao> ();
                    int x, y;
                    for (x = posicaoAtual.getX()+offsetX, y = posicaoAtual.getY()+offsetY;
                    x != destino.getX(); x+=offsetX, y+=offsetY) {
                        path.add(new Posicao(x,y));
                    }
                    path.add(new Posicao(x,y));
                }
            }
        }
        return path;
    }
    
    /* Implementar metodos das jogadas possiveis.. getters and setters etc */
    
    public ArrayList<Posicao> getPath(Posicao destino, Xadrez chess) {
        return null;
    }
    
}
