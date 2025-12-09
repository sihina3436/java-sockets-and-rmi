package Price_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 5000);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Item Code: ");
            String itemCode = sc.nextLine();

            dataOutputStream.writeUTF(itemCode);

            System.out.println("Response from server: ");
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readUTF());
            System.out.println(dataInputStream.readUTF());

            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
