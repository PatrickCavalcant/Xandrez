/*
 * TabuleiroGUI.java
 *
 * Criado em novembro de 2018.
 */

package executavel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import modelo.Xadrez;
import modelo.Posicao;
import modelo.Tabuleiro;
import modelo.Pecas;


public class TabuleiroGUI extends javax.swing.JPanel implements MouseListener  {
    
    
    public static final int TAMANHO_LINHA = 440;
    public static final int TAMANHO_COLUNA = 440;
    
    public static final int ALTURA_CELULA = TAMANHO_LINHA/8;
    public static final int LARGURA_CELULA = TAMANHO_COLUNA/8;
    
    public static final String CLARAS = "\\fundo_claro\\";
    public static final String ESCURAS = "\\fundo_escuro\\";
    
    private String caminho;
    
    private Posicao origemJogada = null;
    private Posicao destinoJogada = null;
    
    private Color c1 = Color.white;
    private Color c2 = Color.green;
    
    private Posicao selecionado = null;
    
    private Xadrez xadrez;
    
    /**
     * Creates new form BoardGUI
     */
    public TabuleiroGUI(Xadrez xadrez) {
        
        this.xadrez = xadrez;
        
        
        File f = new File(".");
        this.origemJogada = null;
        this.destinoJogada = null;
        
        this.setCaminho(f.getAbsolutePath()+"\\img");
        
        addMouseListener(this);
        
        inicializarComponentes();
        
    }
    
    /* Pega Seleção */
    public Posicao getSelecionado() {
        return selecionado;
    }
    
    /* Define Seleção */
    public void setSelecionado(Posicao selecionado) {
        this.selecionado = selecionado;
    }
    
    /* Pinta o tabuleiro */
    public void paint(Graphics g){
        
        // Desenha o quadrado principal
        g.fillRect(0,0, TAMANHO_COLUNA, TAMANHO_LINHA);
        
        // Definir tamanho dos quadrados
        int ladoLinha = TAMANHO_LINHA / 8;
        int ladoColuna = TAMANHO_COLUNA / 8;
        
        // Variavel que contem a cor
        String auxColor = this.ESCURAS;
        
        // Variavel que conterá o endereço da imagem
        String imagem;
        
        // Faz o desenho do tabuleiro
        for (int lin=0;lin<8;lin++){
            for (int col=0;col<8;col++){
                if (auxColor == this.CLARAS){
                    auxColor = this.ESCURAS;
                } else{
                    auxColor = this.CLARAS;
                }
                Pecas peca = this.xadrez.getTabuleiro().getPecaNaPosicao(new Posicao(lin,col));
                if (peca == null){
                    imagem = "fundo.jpg";
                }else{
                    if (peca.getCor() == Color.white){
                        imagem = "branca\\"+peca.getNome()+".jpg";
                    }else{
                        imagem = "preta\\"+peca.getNome()+".jpg";
                    }
                }
                // Instrução que faz desenho
                g.drawImage(this.getImage(caminho+auxColor+imagem),1+(col*ladoColuna),1+(lin*ladoLinha),ladoColuna-1,ladoLinha-1,null);
            }
            
            // Alterna a cor da célula
            if (auxColor == this.CLARAS){
                auxColor = this.ESCURAS;
            } else{
                auxColor = this.CLARAS;
            }
        }
        
        // Destaca a peça selecionada
        g.setColor(Color.BLACK);
        if (this.getSelecionado() != null){
            g.drawRect((this.getSelecionado().getY()*ladoLinha),(this.getSelecionado().getX()*ladoColuna), ladoLinha, ladoColuna);
            g.drawRect(1+(this.getSelecionado().getY()*ladoLinha), 1+(this.getSelecionado().getX()*ladoColuna),  ladoLinha-2 ,ladoColuna-2);
        }

 
        
        // Inicializa as posições
        int cX=10;
        int cY=500;
    }
    
    /* Le uma imagem do disco e transforma em BufferedImage */
    public BufferedImage getImage(String caminho){
        
        File inputFile = new File(caminho);
        try {
            BufferedImage imagem = ImageIO.read(inputFile);
            
            return imagem;
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public String getCaminho() {
        return this.caminho;
    }
    
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    public void posicaoClicada(Posicao pos){
        
        if (this.getOrigemJogada() == null) {
            
            if (! this.xadrez.getTabuleiro().isPosicaoNull(pos) ){
                if ((this.xadrez.isTempoDoPrimeiroJogador() && this.xadrez.getTabuleiro().getPecaNaPosicao(pos).getCor() == Color.WHITE)||
                        ((!this.xadrez.isTempoDoPrimeiroJogador()) && this.xadrez.getTabuleiro().getPecaNaPosicao(pos).getCor() == Color.BLACK)){
                    
                    this.setOrigemJogada(pos);
                    this.setSelecionado(pos);
                }
                this.repaint();
            }
        } else {
            if (this.getDestinoJogada() == null){
                if (this.xadrez.getTabuleiro().getPecaNaPosicao(pos) == null ||
                    (this.xadrez.isTempoDoPrimeiroJogador() && this.xadrez.getTabuleiro().getPecaNaPosicao(pos).getCor() == Color.BLACK)||
                    (!this.xadrez.isTempoDoPrimeiroJogador() && this.xadrez.getTabuleiro().getPecaNaPosicao(pos).getCor() == Color.WHITE) ) {
                    
                    this.setDestinoJogada(pos);
                    boolean jogou = this.xadrez.comecar(this.getOrigemJogada(), this.getDestinoJogada());
                    
                    this.setOrigemJogada(null);
                    this.setDestinoJogada(null);
                    if (jogou){
                        this.setSelecionado(null);
                        this.repaint();
                    }
                } else {
                    this.setOrigemJogada(null);
                    this.setDestinoJogada(null);
                }                
            }
        }
    }
    
    public Posicao calcPosicao(int x, int y){
        Posicao pos = new Posicao((int)(x/ALTURA_CELULA),(int)(y/LARGURA_CELULA));
        return pos;
    }
    
    public Posicao getOrigemJogada() {
        return origemJogada;
    }
    
    public Posicao getDestinoJogada() {
        return destinoJogada;
    }
    
    public void setOrigemJogada(Posicao origemJogada) {
        this.origemJogada = origemJogada;
    }
    
    public void setDestinoJogada(Posicao destinoJogada) {
        this.destinoJogada = destinoJogada;
    }
    
    // Metodos da interface MouseListener, redefinidos para a classe TabuleiroGUI:
    
    public void mouseClicked(MouseEvent e) {
        //this.posicaoClicada(this.calcPosicao(e.getX(),e.getY()));
    }
    public void mousePressed(MouseEvent e) {
        if ( ( e.getX()<=this.TAMANHO_COLUNA) && (e.getY()<=this.TAMANHO_LINHA) ){
            this.posicaoClicada(this.calcPosicao(e.getY(),e.getX()));
        }
    }
    public void mouseEntered  (MouseEvent e) {}
    public void mouseExited   (MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
     /** Este método é chamado de dentro do construtor para
      * Inicialize o formulário.
      */
   
    private void inicializarComponentes() {
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(0, 400, Short.MAX_VALUE)
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(0, 300, Short.MAX_VALUE)
                );
    }
}

