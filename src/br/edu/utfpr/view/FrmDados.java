package br.edu.utfpr.view;

import br.edu.utfpr.entidade.Pessoa;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmDados extends JFrame {

    private JTextField tfNome;
    private JTextField tfIdade;
    private JTextField tfEmail;
    private JButton btEnviar;
    private JButton btFechar;
    private Pessoa pessoa;

    public FrmDados() {
 //frame
        super.setTitle("Threads com Interface Gráfica");
        super.setLayout(new GridBagLayout());

 //componentes de entrada de dados
        JLabel lbNome = new JLabel("Nome: ");
        tfNome = new JTextField(50);
        JLabel lbIdade = new JLabel("Idade: ");
        tfIdade = new JTextField(50);
        JLabel lbEmail = new JLabel("E-mail: ");
        tfEmail = new JTextField(50);

//botões
        btEnviar = new JButton("Enviar");
        btFechar = new JButton("Fechar");

//painéis
        JPanel pnBotoes = new JPanel();
        JPanel painel = new JPanel(new GridLayout(7, 1));
        painel.add(lbNome);
        painel.add(tfNome);
        painel.add(lbIdade);
        painel.add(tfIdade);
        painel.add(lbEmail);
        painel.add(tfEmail);
        pnBotoes.add(btEnviar);
        pnBotoes.add(btFechar);

//orgnização dos componentes  usando o GridBagLayout
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
        cons.ipadx = 80;
        cons.gridy = 1;
        super.add(painel, cons);
        cons.gridy = 2;
        super.add(pnBotoes, cons);
        
        btFechar.addActionListener((e) -> {
            System.exit(0);
        });
        
        btEnviar.addActionListener((e) -> {
           pessoa = new Pessoa(tfNome.getText(), Integer.parseInt(tfIdade.getText()),tfEmail.getText());
           DlDados dlDados = new DlDados(this, true, pessoa);
           dlDados.setVisible(true);
        });
        
        
//configuraões do frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 250);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new FrmDados();

    }
}
