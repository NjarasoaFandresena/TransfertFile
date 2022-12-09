package socket;

import fenetre.*;
import ecouteur.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Serveur {
    // Fenetre fe = new Fenetre();
    // int port;

    // public int get_port() {return this.port;}

    // public void set_port(int port) {this.port=port;}

 
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    
    public static void receiveFile(String fileName) throws Exception
    {
        int bytes = 0;
        FileOutputStream fileOutputStream
            = new FileOutputStream(fileName);
 
        long size = dataInputStream.readLong();
        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;
        }
        System.out.println("Fichier recus");
        fileOutputStream.close();
    }
    
    public static void main(String[] args)
    {

        try (ServerSocket serverSocket = new ServerSocket(900)) {

            
            System.out.println("Serveur est pres pour le Port 900");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connecter");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            receiveFile("/E:/DOSSIER 2022-2023/S3/RESEAUX/Nouveau dossier/fenetre/loi.pdf");
            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}