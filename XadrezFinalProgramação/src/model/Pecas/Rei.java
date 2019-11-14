
package model.Pecas;

import java.awt.Color;
import java.util.*;
import modelo.Tabuleiro;
import modelo.Xadrez;
import modelo.Pecas;
import modelo.Posicao;

public class Rei extends Pecas {
    
    /*atributos do rei */
    boolean naoSeMoveuAinda;
    
    /** criando nova instancia para o rei */
    public Rei(Color cor) {
        super("rei",cor);
    }
    
    /**criando nova instancia para o rei */
    public Rei(Color cor, Posicao pos) {
        super("rei",cor,pos);
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
    public ArrayList <Posicao> getPath(Posicao destino,Xadrez xadrez){
        ArrayList <Posicao> path = null;
        Posicao posicaoAtual = this.getPosicao();
        
        if (!destino.equals(posicaoAtual)) {
            Tabuleiro tabuleiro = xadrez.getTabuleiro();
            Posicao roque2;
            Posicao roque1;
            Torre torre1 = null;
            Torre torre2 = null;
            Color corRei = this.getCor();
            int offset;
            Pecas pi;
            
            /* verifica os pontos de roque, para Pecas pretas e brancas */
            if (corRei == Color.WHITE) {
                /* rei branco */
                if ( (pi = tabuleiro.getPecaNaPosicao(new Posicao(7,7))) != null && pi instanceof Torre) {
                    torre1 = (Torre) tabuleiro.getPecaNaPosicao(new Posicao(7,7));
                }
                roque1 = new Posicao(7,6);
                if ( (pi = tabuleiro.getPecaNaPosicao(new Posicao(7,0))) != null && pi instanceof Torre) {
                    torre2 = (Torre) pi;
                }
                roque2 = new Posicao(7,2);
            } else { /* rei preto  */
                if ( (pi = tabuleiro.getPecaNaPosicao(new Posicao(0,7))) != null && pi instanceof Torre) {
                    torre1 = (Torre) pi;
                }
                roque1 = new Posicao(0,6);
                if ( (pi = tabuleiro.getPecaNaPosicao(new Posicao(0,0))) != null && pi instanceof Torre) {
                    torre2 = (Torre) pi;
                }
                roque2 = new Posicao(0,2);
            }
            
            
            /* verifica se deseja-se fazer um roque */
            /* verifica se o rei ainda n foi movido */
            if (this.isNaoSeMoveuAinda() && (destino.equals(roque1) ||
                    destino.equals(roque2)) ) {
                
                Tabuleiro cloneBoard = tabuleiro.getTabuleiroClone();
                
                if ((destino.equals(roque1) && corRei == Color.WHITE)) {
                    offset = 1; // vai mover p/ direita, pois é roque 1
                    /* rei branco que fazer roque1 */
                    /* verifica se a torre1 n foi movida ainda */
                    if (torre1 != null && torre1.isNaoSeMoveuAinda()) {
                        /* torre1 n foi movida ainda, pode-se fazer o roque1 */
                        /* verifica se as casas ao redor nao estao ocupadas (1 regra do roque) */
                        if (tabuleiro.isPosicaoNull(new Posicao(7,5)) && tabuleiro.isPosicaoNull(new Posicao(7,6))) {
                        /* - as casas 7,5 e 7,6 ja estao livres, porem nao podem estar sendo atacadas por uma
                         *   peca adversaria (2a regra do roque)
                         */
                            if (!((xadrez.isAtacadaPorPreto(new Posicao(7,5),tabuleiro)) ||
                                    (xadrez.isAtacadaPorPreto(new Posicao(7,6),tabuleiro)))) {
                                /* posicoes nao estao sobe ataque, entao faz-se o roque */
                                tabuleiro.setPosicao(this,new Posicao(7,6));
                                this.setPosicao(new Posicao(7,6));
                                tabuleiro.setPosicao(torre1,new Posicao(7,5));
                                torre1.setPosicao(new Posicao(7,5));
                                tabuleiro.setPosicao(null,posicaoAtual);
                                tabuleiro.setPosicao(null,new Posicao(7,7));
                                path = new ArrayList <Posicao>();
                                path.add(new Posicao(99,99)); // posicao especial de roque
                                return path;
                            }
                        }
                    }
                } else if ((destino.equals(roque1) && corRei == Color.BLACK)) {
                    offset = 1;
                    /* rei preto que fazer roque1 */
                    if (torre1 != null && torre1.isNaoSeMoveuAinda()) {
                        /* torre1 n foi movida ainda, pode-se fazer o roque1 */
                        /* torre1 n foi movida ainda, pode-se fazer o roque1 */
                        /* verifica se as casas ao redor nao estao ocupadas */
                        if (tabuleiro.isPosicaoNull(new Posicao(0,5)) && tabuleiro.isPosicaoNull(new Posicao(0,6))) {
                            if (!((xadrez.isAtacadaPorBranco(new Posicao(0,5),tabuleiro)) ||
                                    (xadrez.isAtacadaPorBranco(new Posicao(0,6),tabuleiro)))) {
                                /* pode fazer o roque */
                                tabuleiro.setPosicao(this,new Posicao(0,6));
                                this.setPosicao(new Posicao(0,6));
                                tabuleiro.setPosicao(torre1,new Posicao(0,5));
                                torre1.setPosicao(new Posicao(0,5));
                                tabuleiro.setPosicao(null,posicaoAtual);
                                tabuleiro.setPosicao(null,new Posicao(0,7));
                                path = new ArrayList <Posicao>();
                                path.add(new Posicao(99,99)); // posicao especial de roque
                                return path;
                            }
                        }
                    }
                } else if ((destino.equals(roque2) && corRei == Color.BLACK)) {
                    offset = -1;
                    /* rei preto que fazer roque2 */
                    if (torre2 != null && torre2.isNaoSeMoveuAinda()) {
                        /* torre1 n foi movida ainda, pode-se fazer o roque2 */
                        /* verifica se as casas ao redor nao estao ocupadas */
                        if (tabuleiro.isPosicaoNull(new Posicao(0,2)) && tabuleiro.isPosicaoNull(new Posicao(0,3)) &&
                                tabuleiro.isPosicaoNull(new Posicao(0,1)) ) {
                            if (!( (xadrez.isAtacadaPorBranco(new Posicao(0,1),tabuleiro)) ||
                                    (xadrez.isAtacadaPorBranco(new Posicao(0,2),tabuleiro)) ||
                                    (xadrez.isAtacadaPorBranco(new Posicao(0,3),tabuleiro)) )) {
                                
                                /* pode fazer o roque */
                                tabuleiro.setPosicao(this,new Posicao(0,2));
                                this.setPosicao(new Posicao(0,2));
                                tabuleiro.setPosicao(torre2,new Posicao(0,3));
                                torre2.setPosicao(new Posicao(0,3));
                                tabuleiro.setPosicao(null,new Posicao(0,0));
                                tabuleiro.setPosicao(null,posicaoAtual);
                                path = new ArrayList <Posicao>();
                                path.add(new Posicao(99,99)); // posicao especial de roque
                                return path;
                            }
                        }
                    }
                } else if ((destino.equals(roque2) && corRei == Color.WHITE)) {
                    offset = -1;
                    /* rei branco que fazer roque2 */
                    if (torre1 != null && torre2.isNaoSeMoveuAinda()) {
                        /* torre1 n foi movida ainda, pode-se fazer o roque2 */
                        /* torre1 n foi movida ainda, pode-se fazer o roque1 */
                        /* verifica se as casas ao redor nao estao ocupadas */
                        if (tabuleiro.isPosicaoNull(new Posicao(7,1)) && tabuleiro.isPosicaoNull(new Posicao(7,2)) &&
                                tabuleiro.isPosicaoNull(new Posicao(7,3)) ) {
                            if (!( (xadrez.isAtacadaPorPreto(new Posicao(7,1),tabuleiro)) ||
                                    (xadrez.isAtacadaPorPreto(new Posicao(7,2),tabuleiro)) ||
                                    (xadrez.isAtacadaPorPreto(new Posicao(7,3),tabuleiro)) )) {
                                /* pode fazer o roque */
                                tabuleiro.setPosicao(this,new Posicao(7,2));
                                this.setPosicao(new Posicao(7,2));
                                tabuleiro.setPosicao(torre2,new Posicao(7,3));
                                torre2.setPosicao(new Posicao(7,3));
                                tabuleiro.setPosicao(null,posicaoAtual);
                                tabuleiro.setPosicao(null,new Posicao(7,0));
                                path = new ArrayList <Posicao>();
                                path.add(new Posicao(99,99)); // posicao especial de roque
                                return path;
                            }
                        }
                    }
                }
                
            } else { /* rei movido.. n faz-se roque */
                int difX = Math.abs(destino.getX()-posicaoAtual.getX());
                int difY = Math.abs(destino.getY()-posicaoAtual.getY());
                
                /* verifica se esta se movendo ao redor da casa atual */
                if ( (((difX==1)&&(difY==0)) || ((difY==1)&&(difX==0))) || ((difX==1)&&(difY==1))) {
                    path = new ArrayList <Posicao> ();
                    path.add(destino);
                }
            }
            if (path != null) {
                this.setNaoSeMoveuAinda(false);
            }
        }
        return path;
    }
    
    
    /* Rei nao utiliza este metodo */
    public ArrayList <Posicao> getPath(Posicao destino) {
        return null;
    }
    public ArrayList <Posicao> getPath(Posicao destino,Tabuleiro board) {
        return null;
    }
    
    /* Implementar metodos das jogadas possiveis.. getters and setters etc */
    
}
