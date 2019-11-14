
package model.Pecas;

import java.awt.Color;
import java.util.*;
import modelo.Xadrez;
import modelo.Pecas;
import modelo.Posicao;
import modelo.Tabuleiro;


public class Peao extends Pecas {
    
    /* Peao attributes */
    Posicao posicaoInicial; // atributo que guarda o local de criacao do peao
    // pois nesta posicao, ele pode pular 2 casas
    
    /** Cria uma nova instância de peão */
    public Peao(Color cor) {
        super("peao",cor);
    }
    
    /** Cria uma nova instância de peão */
    public Peao(Color cor, Posicao pos) {
        super("peao",cor,pos);
        this.setPosicaoInicial(pos);
    }
    
    /* Peao nao utiliza este metodo */
    public ArrayList <Posicao> getPath(Posicao destino){
        return null;
    }
    
    /**
     *  Retorna a relacão de posições(caminho) a
     * serem percorridas para alcançar o destino
     */
    public ArrayList <Posicao> getPath(Posicao destino,Tabuleiro board){
        
        ArrayList caminho = null;
        Posicao posicaoAtual = this.getPosicao();
        
        if (!destino.equals(posicaoAtual)) {
            int offset = 1;
            
            if (this.getCor() == Color.WHITE)
                offset *= -1; // passa a andar em direcao para cima do tabuleiro
            
        /* -> testa se a posicao destino pode ser alcancada a partir da origem
         *    - se o peao esta na posicao original (ainda nao foi movido)
         *      entao ele pode pular 2 casas
         *    - ou a posicao destino esta no msm X que a posicao origem
         *    - ou (no caso de comer uma outra peca), a posicao destino pode ser
         *    - 1 casa acima e 1 casa ao lado (desde que exista uma peca em destino)
         * -> Pecas bracas andam para cima (indice menor), pretas o contrario
         */
            
            if ((posicaoAtual.getY() == destino.getY()) && board.isPosicaoNull(destino)) {
                /* movimento vertical, nao vai comer nenhuma peca */
                if (posicaoAtual.equals(this.getPosicaoInicial())) {
                /* ainda nao se moveu, pode entao pular 2 casas (se quiser), basta verificar se
                 * a posicao destino é valida e adicionar no caminho */
                    if (destino.getX() == posicaoAtual.getX()+(offset*2)) {
                        /* o jogador deseja pular 2 casas */
                        caminho = new ArrayList <Posicao>();
                        Posicao pos = new Posicao(posicaoAtual.getX()+offset,posicaoAtual.getY());
                        caminho.add(pos);
                        caminho.add(destino);
                    } else if (destino.getX() == posicaoAtual.getX()+offset) {
                        /* o jogador deseja pular somente 1 casa */
                        caminho = new ArrayList <Posicao>();
                        caminho.add(destino);
                    }
                } else {
                    /* peao ja foi movido, entao pode pular somente 1 casa */
                    if (destino.getX() == posicaoAtual.getX()+offset) {
                        /* verificando se a posicao clicada corresponde a um possivel movimento */
                        caminho = new ArrayList <Posicao>();
                        caminho.add(destino);
                    }
                }
            } else { /* movimento em diagonal, quer comer uma outra peca */
                /* so podera se movimentar 1 casa em X e uma casa em Y */
                if ((destino.getY() == posicaoAtual.getY()+1) || (destino.getY() == posicaoAtual.getY()-1))  {
                    /* a posicao clicada (destino) esta 1 casa de offset em X */
                    if (destino.getX() == posicaoAtual.getX()+offset) {
                        
                    /* a posicao clicada (destino) esta 1 casa de offset em Y, entao
                     * tem q verificar se existe 1 peca de outra cor na posicao destino
                     * caso contrario, n é possivel fazer o movimento, e path = null
                     */
                        Pecas adv;
                        if (((adv = board.getPecaNaPosicao(destino)) != null)&&(adv.getCor() != this.getCor())) {
                            caminho = new ArrayList <Posicao>();
                            caminho.add(destino);
                        }
                    }
                }
            }
        }
        return caminho;
    }
    
    /* Implementar metodos das jogadas possiveis.. getters and setters etc */
    
    public Posicao getPosicaoInicial() {
        return posicaoInicial;
    }
    
    public void setPosicaoInicial(Posicao posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }
    
    public ArrayList<Posicao> getPath(Posicao destino, Xadrez chess) {
        return this.getPath(destino,chess.getTabuleiro());
    }
}
