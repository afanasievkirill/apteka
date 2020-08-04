package ru.eapteka.ones.web.appmanager;

import ru.eapteka.ones.web.model.OrderData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class OrderDataGenerator {


    public void writter(String nameFile, String orderId) {

        try (FileWriter writer = new FileWriter(nameFile + ".csv", false)) {
            writer.write(orderId);

            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void writterOrder(OrderData orderData) {

        try (FileWriter writer = new FileWriter(orderData.getNameFile() + ".csv", false)) {
            writer.write(orderData.getOrderId());

            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public String readerId(String nameFile) {
        char[] buf = new char[256];
        try (FileReader reader = new FileReader(nameFile + ".csv")) {
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String orderId = String.valueOf(buf);
        return orderId;

    }
}
