package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import modelo.Pecas;

/**
 *
 * @author Igor, Patrick, Wasller
 * 
 */
public abstract class Pecas {

    /* Nome da peca (Ex: peao, rei, etc ) */
    String nome;

    /* Cor da peca (preto/branco) */
    Color cor;

    /* Posicao peca (posicao no tabuleiro) */
    Posicao position;

    /**
    * Cria uma nova instância de peça
     */
    public Pecas(String nome, Color cor) {
        this(nome, cor, new Posicao());
    }

    /**
     *
     * Cria uma nova instância de peça
     */
    public Pecas(String nome, Color cor, Posicao pos) {
        this.nome = nome;
        this.cor = cor;
        this.position = pos;
    }

    /**
     * Retorna a relacão de posições(caminho) a serem percorridas para alcançar
     * o destino
     */
    public abstract ArrayList<Posicao> getPath(Posicao destino);

    public abstract ArrayList<Posicao> getPath(Posicao destino, Tabuleiro tabuleiro);

    public abstract ArrayList<Posicao> getPath(Posicao destino, Xadrez xadrez);

    /**
     *
     * Define a posição da peça no tabuleiro
     */
    public void setPosicao(Posicao pos) {
        this.position = pos;
    }

    /**
     *
     * Pega a posição da peça no tabuleiro
     */
    public Posicao getPosicao() {
        return position;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

}
