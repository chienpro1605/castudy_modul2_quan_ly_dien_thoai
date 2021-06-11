package readwritefile;

import model.PhoneInforDetail;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCsv {
    public static void writeToFile(String path, List<PhoneInforDetail> phoneInforDetails) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        String str = "name, brand, price, idPhone, capacity, color, nsx, descriptionPhone,status\n";
        for (int i = 0; i< phoneInforDetails.size(); i++){
            str+= phoneInforDetails.get(i).getName() + "," + phoneInforDetails.get(i).getBrand() +"," + phoneInforDetails.get(i).getPrice()
                 +"," + phoneInforDetails.get(i).getIdPhone() +"," + phoneInforDetails.get(i).getCapacity()
                 +"," + phoneInforDetails.get(i).getColor() +"," + phoneInforDetails.get(i).getNsx() +"," + phoneInforDetails.get(i).getDescriptionPhone()+","+phoneInforDetails.get(i).getStatus() + "\n";
        }
        bw.write(str);
        bw.close();
        fw.close();
    }
    public static List<PhoneInforDetail> readToFile(String path) throws IOException {
        List<PhoneInforDetail> product = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String content = br.readLine();
        while ((content = br.readLine())!=null){
            String[] values = content.split(",");
            product.add(new PhoneInforDetail(values[0], values[1],Integer.parseInt( values[2]), Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], values[8]));

        }
        return product;
    }

}
