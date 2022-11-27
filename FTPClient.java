import java.io.FileOutputStream;
import java.io.InputStream; 
import java.net.Socket;

public class FTPClient {
    public static void main(String[] args) throws Exception{
        Socket csocket=new Socket("localhost",9999);
        InputStream is = csocket.getInputStream();
        FileOutputStream fo = new FileOutputStream("D:\\CN-LAB-Exercise-Files\\data.txt");
        byte b[]=new byte[20002];
        is.read(b, 0, b.length);
        fo.write(b, 0, b.length);     
        System.out.println("File saved successfully!");
    }
}
