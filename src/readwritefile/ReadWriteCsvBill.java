package readwritefile;

import model.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCsvBill {

    public static void writeToBill(String path, List<Bill> bill, int id) throws IOException {
        Bill bill1 = new Bill();
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "customerName, phoneNumber, address, idPhone, phoneName, price, dayOrder,idOrder, amount, totalpay\n";
        for (int i = 0; i<bill.size(); i++){
            str+=bill.get(i).getCustomerName()+ ","+bill.get(i).getPhoneNumber()+","+bill.get(i).getAddress()+","
                    +bill.get(i).getIdPhone(id)+","+bill.get(i).getPhoneName(id)+","+bill.get(i).getPrice(id)+","
                    +bill.get(i).getDayOrder()+ ","+bill.get(i).getIdOrder()+","+bill.get(i).getAmount()+","+bill.get(i).getTotalPay()+"\n";
            //str+=bill.get(i).toString()+"\n";
        }
        bw.write(str);
        bw.close();
        fw.close();
    }
    public static List<Bill> readFromBill(String path) throws IOException {
        List<Bill> listBill = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while ((line = br.readLine())!=null){
            String[] values = line.split(",");
            listBill.add(new Bill(values[0], values[1],values[2],Integer.parseInt(values[3]) , values[4], Integer.parseInt(values[5]),values[6], Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9])));
        }
        return listBill;
    }
}
