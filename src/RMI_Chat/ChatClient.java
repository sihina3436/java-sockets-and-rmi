package RMI_Chat;

import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Chat chatServer = (Chat) Naming.lookup("rmi://localhost:1099/Chat");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message: ");
            String msg = sc.nextLine();

            // Send message to server
            chatServer.sendMessage(msg);

            // Request the stored message from server
            String response = chatServer.GetMessage();
            System.out.println("Response from server: " + response);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
