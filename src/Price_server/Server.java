package Price_server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        // -------- PRICE MAP -------------
        Map<String, Double> priceMap  = new HashMap<>();
        priceMap.put("MT001",2500.00);
        priceMap.put("MT002",1200.00);
        priceMap.put("MT003",350.00);
        priceMap.put("MT004",990.00);
        priceMap.put("ES001",4000.00);
        priceMap.put("ES002",3400.00);
        priceMap.put("ES003",6500.00);
        priceMap.put("ES004",1500.00);
        priceMap.put("MLS001",750.00);
        priceMap.put("MLS002",4500.00);

        // ---------- Discount MAP ----------
        Map <String, Double> discountMap = new HashMap<>();
        discountMap.put("MT001",0.5);
        discountMap.put("MT002",2.5);
        discountMap.put("MT003",0.0);
        discountMap.put("MT004",2.0);
        discountMap.put("ES001",10.0);
        discountMap.put("ES002",7.5);
        discountMap.put("ES003",15.5);
        discountMap.put("ES004",5.0);
        discountMap.put("MLS001",0.0);
        discountMap.put("MLS002",10.0);


        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Price Server Started (Running 24Hours)");

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Branch Connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String itemcode = dataInputStream.readUTF();

                if(priceMap.containsKey(itemcode)){
                    double price = priceMap.get(itemcode);
                    double discount = discountMap.get(itemcode);

                    double finalPrice = price - (price * discount);

                    dataOutputStream.writeUTF("Initial Price:" + price);
                    dataOutputStream.writeUTF("Discount (%):" + discount);
                    dataOutputStream.writeUTF("Final Price: "  + finalPrice);

                } else {
                    dataOutputStream.writeUTF("Invalid itemcode");
                    dataOutputStream.writeUTF("-");
                    dataOutputStream.writeUTF("-");
                }
                socket.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
