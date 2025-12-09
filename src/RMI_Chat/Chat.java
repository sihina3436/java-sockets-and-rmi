package RMI_Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
    void sendMessage(String message) throws RemoteException;
    String GetMessage() throws RemoteException;
}
