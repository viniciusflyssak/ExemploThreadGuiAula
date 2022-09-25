package br.edu.utfpr.view;

import br.edu.utfpr.entidade.Pessoa;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DlDados extends JDialog {

    private JButton btEnviar;
    private JProgressBar pb;
    private Pessoa pessoa;
    private Thread thread;

    public DlDados(JFrame parent, boolean modal, Pessoa pessoa) {
        super.setTitle("Enviar dados");
        super.setLayout(new BorderLayout());
        this.pessoa = pessoa;
        
        JLabel lbNome = new JLabel("Nome: ");
        JLabel lbExibirNome = new JLabel("...");
        JLabel lbIdade = new JLabel("Idade: ");
        JLabel lbExibirIdade = new JLabel("... ");
        JLabel lbEmail = new JLabel("E-mail: ");
        JLabel lbExibirEmail = new JLabel("... ");

        JPanel pnDados = new JPanel(new GridLayout(4, 2));
        btEnviar = new JButton("Enviar");
        pb = new JProgressBar(JProgressBar.HORIZONTAL, 1, 100);
        pb.setStringPainted(true);
        pb.setForeground(new Color(50, 200, 20));
        pnDados.add(lbNome);
        pnDados.add(lbExibirNome);
        pnDados.add(lbIdade);
        pnDados.add(lbExibirIdade);
        pnDados.add(lbEmail);
        pnDados.add(lbExibirEmail);

        JPanel pnProgresso = new JPanel(new GridLayout(2, 1));
        pnProgresso.add(btEnviar);
        pnProgresso.add(pb);

        lbExibirNome.setText(pessoa.getNome());
        lbExibirIdade.setText(String.valueOf(pessoa.getIdade()));
        lbExibirEmail.setText(pessoa.getEmail());
        super.add(pnDados, BorderLayout.CENTER);
        super.add(pnProgresso, BorderLayout.SOUTH);
        
        btEnviar.addActionListener((e) -> {
            if ((thread == null) || (thread.isAlive() != true)) { //pode-se utilizar "thread.getState() == Thread.State.TERMINATED" ao invés de "thread.IsAlive" nesse caso
                enviar();
            }else{    
                if (thread.isAlive()){
                    System.out.println("A thread já está em execução!");
                }
            }
        });       

        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setSize(300, 200);
        super.setVisible(true);

    }    
    public void enviar(){
        atualizaBarra();       
    }
    public void atualizaBarra(){        
        thread = new Thread(() -> {
            for (int i = 0; i <= 100; i++) {            
                try {
                    pb.setValue(i);
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Erro: ' + ex.getMessage()");
                }   
            }
        });        
        thread.start();
        }    
    }