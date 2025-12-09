package RMI_Calculator;

import java.rmi.Naming;
import java.util.Scanner;

public class Cal_client {
    public static void main(String[] args) {
        try{
            Calculator calculator = (Calculator)  Naming.lookup("rmi://localhost/Cal_server");

            Scanner input = new Scanner(System.in);

            System.out.println("Enter a first number: ");
            int a = input.nextInt();


            System.out.println("Enter a second number: ");
            int b = input.nextInt();

            System.out.println("Result from RMI Server:");

            System.out.println("Addition: " + calculator.add(a, b));
            System.out.println("Subtraction: " + calculator.subtract(a, b));
            System.out.println("Multiplication: " + calculator.multiply(a, b));
            System.out.println("Division: " + calculator.divide(a, b));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
