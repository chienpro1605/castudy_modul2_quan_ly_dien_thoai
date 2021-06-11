package readwritefile;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteAccount {
    public static void writeAcount(String path, List<Account> accounts) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("nameAcount, passWord, email\n");
        for (int i = 0; i<accounts.size(); i++){
           bw.write(accounts.get(i).getNameAccount()+ ","+accounts.get(i).getPassWord()+","+accounts.get(i).getEmail()+"\n");
        }
        bw.close();
        fw.close();
    }
    public static List<Account> readAccount(String path) throws IOException {
        List<Account> newList = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while ((line = br.readLine())!=null){
            String[] str = line.split(",");
            newList.add(new Account(str[0], str[1], str[2]));

        }
        return newList;
    }
}
