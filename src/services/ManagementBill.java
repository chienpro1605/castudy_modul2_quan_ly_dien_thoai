package services;

import model.Bill;
import readwritefile.ReadWriteCsvBill;
import services.BillInterFace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManagementBill implements BillInterFace {
   private List<Bill> billList;

    public ManagementBill (){
        try {
           this.billList = ReadWriteCsvBill.readFromBill("billdata.csv");

        }catch (Exception e){
            this.billList = new ArrayList<>();
        }
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }
    @Override
    public void addBill(Bill bill){
        billList.add(bill);
    }
    @Override
    public void displayBill(){
        for (int i = 0; i<billList.size(); i++){
            System.out.println(billList.get(i));
        }
        System.out.println("---------------------");
    }
    @Override
    public void seachBill(String name, String phoneNumber){
        boolean customerName = false;
        boolean checkPhoneNumber = false;
        for (int i = 0; i< billList.size(); i++){
            if (billList.get(i).getCustomerName().equals(name) && billList.get(i).getPhoneNumber().equals(phoneNumber)){
                System.out.println( billList.get(i));
                customerName = true;
                checkPhoneNumber = true;
            }
        }if (!customerName && !checkPhoneNumber){
            System.out.println("không tìm thấy khách hàng này");
        }
    }
    @Override
    public int totalSaleMonth(String month, String year){
        int sum = 0;
        for (int i = 0; i<billList.size(); i++){
            if (billList.get(i).getMonth().equals(month) && billList.get(i).getYear().equals(year)){
                sum+=billList.get(i).getTotalPay();
            }
        }
        return sum;
    }

}
