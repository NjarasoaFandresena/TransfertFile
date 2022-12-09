package mouse;
import socket.*;
import fenetre.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;

public class ListenerOfMouse implements MouseListener
{
    JButton but;
    Fenetre f;
    String ip;

    public String get_ip() {return this.ip;}

    public void set_ip(String ip) {this.ip=ip;}

    public ListenerOfMouse(JButton but, Fenetre f)
    {
        this.but = but;
        this.f = f;
    }

    public ListenerOfMouse(){}

    public ListenerOfMouse(String ip) {
        set_ip(ip);
    }


    public void mouseClicked(MouseEvent e)
    {
        try  
        {
            if(this.but.getText()=="ENVOYER")
            {
                this.set_ip(f.get_JTF().getText());
                Client client = new Client(get_ip());
                System.out.println(get_ip());
            }
        }
        catch (Exception exe) {
            exe.printStackTrace();
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void	mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}