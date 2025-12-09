package RMI_Calculator;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;

public class Cal_server extends UnicastRemoteObject implements Calculator {

    Cal_server() throws RemoteException{
        super();
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        return a / b;
    }



    public static void main(String[] args) {
        try{

            LocateRegistry.createRegistry(1099);

            Cal_server obj = new Cal_server();
            Naming.rebind("rmi://localhost/Cal_server", obj);

            System.out.println("RMI Server ready");

        } catch (Exception exception){
            exception.printStackTrace();

        }
    }
}
