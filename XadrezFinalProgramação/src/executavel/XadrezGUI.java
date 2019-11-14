/*
 * XadrezGUI.java
 *
 * Criado em novembro de 2018
 */

package executavel;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import modelo.Xadrez;
import modelo.Posicao;

/**
 *
 * @author Igor, Patrick, Wasller.
 * 
 */
public class XadrezGUI extends javax.swing.JFrame {
    
    
    // Modelo do jogo
    private Xadrez xadrez;
    
    // Tabuleiro da tela
    private TabuleiroGUI pnTabuleiro;
    
   
    
    /** criar novo xadrez */
    public XadrezGUI() {
        this.xadrez = new Xadrez();
        iniciarComponentes();
        
        this.pnTabuleiro = new TabuleiroGUI(this.xadrez);
        
        getContentPane().add(this.pnTabuleiro, java.awt.BorderLayout.CENTER);
        setSize(600,485);
        
        //Inicia Jogo
        this.comecarJogo();
    }
    
    public JLabel getJlbTempo1(){
        return this.jlbTempo1;
    }
    
    public JLabel getJlbTempo2(){
        return this.jlbTempo2;
    }
    
    public JLabel getJlbJogadorDaVez(){
        return this.jlbJogadorAtual;
    }
    
    public void comecarJogo(){
        
        this.xadrez.comecarJogo();
        this.jlbTempo1.setText(this.xadrez.getJogador1().toString());
        this.jlbTempo2.setText(this.xadrez.getJogador2().toString());
        
      
        this.pnTabuleiro = new TabuleiroGUI(this.xadrez);       
        
                     
        this.jlbNome1.setText(this.xadrez.getJogador1().getNome());
        this.jlbNome2.setText(this.xadrez.getJogador2().getNome());
        this.repaint();
    }
    
    public Xadrez getXadrez() {
        return this.xadrez;
    }
    
    
    
    private void iniciarComponentes() {
        this.setResizable(false);
        jLabel3 = new javax.swing.JLabel();
        pnStatus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbNome1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbNome2 = new javax.swing.JLabel();
        jlbTempo1 = new javax.swing.JLabel();
        jlbTempo2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlbJogadorDaVez = new javax.swing.JLabel();
        jlbJogadorAtual = new javax.swing.JLabel();
        mnJogo = new javax.swing.JMenu();
        mnAbout = new javax.swing.JMenu();
        mnIniciar = new javax.swing.JMenuItem();
        mnXadrez = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
       
        mnSair = new javax.swing.JMenuItem();
        
        
        jLabel3.setText("jLabel3");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Jogador 1:");
        
        jlbNome1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jlbNome1.setForeground(new java.awt.Color(153, 0, 0));
        jlbNome1.setText(" ");
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Jogador 2:");
        
        jlbNome2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jlbNome2.setForeground(new java.awt.Color(153, 0, 0));
        jlbNome2.setText(" ");
        
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Jogador da vez:");
        
        jlbJogadorDaVez.setFont(new java.awt.Font("Tahoma", 1, 12));
        
        jlbJogadorAtual.setText(" ");
        
        org.jdesktop.layout.GroupLayout pnStatusLayout = new org.jdesktop.layout.GroupLayout(pnStatus);
        pnStatus.setLayout(pnStatusLayout);
        pnStatusLayout.setHorizontalGroup(
                pnStatusLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(pnStatusLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnStatusLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jLabel1)
                .add(jlbNome1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .add(jlbNome2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel4)
                .add(pnStatusLayout.createSequentialGroup()
                .add(105, 105, 105)
                .add(jlbJogadorDaVez))
                .add(jlbJogadorAtual, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
                );
        pnStatusLayout.setVerticalGroup(
                pnStatusLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(pnStatusLayout.createSequentialGroup()
                .add(23, 23, 23)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jlbNome1)
                .add(18, 18, 18)
                .add(55, 55, 55)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jlbNome2)
                .add(14, 14, 14)
                .add(62, 62, 62)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jlbJogadorAtual)
                .add(40, 40, 40)
                .add(jlbJogadorDaVez)
                .addContainerGap(181, Short.MAX_VALUE))
                );
        getContentPane().add(pnStatus, java.awt.BorderLayout.EAST);
        
        mnJogo.setText("Jogo");
        mnAbout.setText("Sobre");
        mnIniciar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnIniciar.setText("Iniciar");
        mnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIniciarAcaoExecutada(evt);
            }
        });
        
        mnXadrez.setText("Xadrez");
        mnXadrez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnXadrezAcaoExecutada(evt);
            }
        });
        
        mnJogo.add(mnIniciar);
        mnAbout.add(mnXadrez);
        mnJogo.add(jSeparator1);
        mnJogo.add(mnSair);
        
        mnSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairAcaoExecutada(evt);
            }
        });
        
        pack();
    }
    
    private void mnXadrezAcaoExecutada(java.awt.event.ActionEvent evt) {
        String s = " Xadrez \n "+
                   " Alunos: \n     Eduardo Coelho\n     Marcelo Gonzaga\n     Marcelo Kestring\n Disciplina:\n     Tópicos em programação";
        
        javax.swing.JOptionPane.showMessageDialog(this,s);
    }
    
    
    private void mnIniciarAcaoExecutada(java.awt.event.ActionEvent evt) {
        this.comecarJogo();
    }
    
    private void mnVerAcaoExecutada(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this,"Alunos: \n Eduardo Coelho\n Marcelo Gonzaga\n Marcelo Kestring\nDisciplina: Tópicos em programação");
    }
    
    private void mnSairAcaoExecutada(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    /**
     * @param args os argumentos da linha de comando
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XadrezGUI().setVisible(true);
            }
        });
    }
    
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbJogadorAtual;
    private javax.swing.JLabel jlbJogadorDaVez;
    private javax.swing.JLabel jlbNome1;
    private javax.swing.JLabel jlbNome2;
    private javax.swing.JLabel jlbTempo1;
    private javax.swing.JLabel jlbTempo2;
    private javax.swing.JMenuItem mnIniciar;
    private javax.swing.JMenuItem mnXadrez;
    private javax.swing.JMenu mnJogo;
    private javax.swing.JMenu mnAbout;
    private javax.swing.JMenuItem mnSair;
    private javax.swing.JPanel pnStatus;
    
}
