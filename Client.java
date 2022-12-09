package socket;
import fenetre.*;
import mouse.*;
import java.io.*;
import java.net.Socket;
import org.w3c.dom.events.MouseEvent;
 
public class Client {
    // Fenetre fe;
    String ip = "";
    // int port;

    public String get_ip() {return this.ip;}
    // public int get_port() {return this.port;}

    public void set_ip(String ip) {this.ip=ip;}
    // public void set_port(int port) {this.port=port;}

    public Client(String ip) {
            set_ip(ip);
            // set_port(port);
        try (
            Socket socket = new Socket(ip, 900)) {
            dataInputStream = new DataInputStream( socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Envoie du fichier au Serveur");
            sendFile("/E:/DOSSIER 2022-2023/S3/RESEAUX/Nouveau dossier/serveur fichier/loi.pdf");
            dataInputStream.close();
            dataInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
 
    public static void sendFile(String path) throws Exception
    {
        int bytes = 0;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        dataOutputStream.writeLong(file.length());
        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer)) != -1) {
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
        fileInputStream.close();
    }
}