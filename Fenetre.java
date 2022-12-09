package fenetre;
import socket.*;
import mouse.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame {
    JPanel container;
    JLabel label;
    JLabel label1;
    JTextField jtf;
    JButton but;

    public JPanel get_container() {return this.container;}
    public JLabel get_label() {return this.label;}
    public JLabel get_label1() {return this.label1;}
    public JTextField get_JTF() {return this.jtf;}
    public JButton get_but() {return this.but;}

    public void set_container(JPanel container) {this.container=container;}
    public void set_label(JLabel label) {this.label=label;}
    public void set_label1(JLabel label1) {this.label1=label1;}
    public void set_JTF(JTextField jtf) {this.jtf=jtf;}
    public void set_but(JButton but) {this.but=but;}


    public Fenetre(){

        container = new JPanel();

        jtf = new JTextField();

        label = new JLabel("IP");
        
        but = new JButton("ENVOYER");

        this.setTitle("TRANSFERT DE FICHIER");
        this.setSize(600,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
 
        get_container().setLayout(new BorderLayout());

        JPanel top = new JPanel();

        jtf.setPreferredSize(new Dimension(150, 30));


        top.add(label);
        top.add(jtf);


        top.add(but);

        container.add(top, BorderLayout.NORTH);

        but.addMouseListener(new ListenerOfMouse(but, this));

        this.setContentPane(container);
        this.setVisible(true);
    }
}
