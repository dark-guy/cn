import java.io.FileInputStream; 
import java.io.OutputStream; 
import java.net.ServerSocket; 
import java.net.Socket;

public class FTPServer{
    public static void main(String[] args) throws Exception { 
        ServerSocket ssocket = new ServerSocket(9999); 
        Socket socket = ssocket.accept();
        FileInputStream fr = new FileInputStream("D:\\CN-LAB-Exercise-Files\\sample.txt");
        byte b[]=new byte[2002];
        fr.read(b, 0, b.length);
        OutputStream os = socket.getOutputStream();
        os.write(b, 0, b.length);
        System.out.println("File sent succesfully!");
    }
}