package RMI_Chat;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServer extends UnicastRemoteObject implements Chat {

    private static final long serialVersionUID = 1L;
    private String message = "No messages yet.";


    protected ChatServer() throws RemoteException {
        super();
    }

    @Override
    public synchronized void sendMessage(String message) throws RemoteException {
        this.message = message;
        System.out.println("Client sent message: " + message);
    }

    @Override
    public synchronized String GetMessage() throws RemoteException {
        return message;
    }

    public static void main(String[] args) {
        try {

            LocateRegistry.createRegistry(1099);

            ChatServer chatServer = new ChatServer();
            Naming.rebind("rmi://localhost:1099/Chat", chatServer);

            System.out.println("Server ready and bound as rmi://localhost:1099/Chat");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
