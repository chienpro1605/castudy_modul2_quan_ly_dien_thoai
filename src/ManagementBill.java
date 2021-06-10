import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManagementBill {
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
    public void addBill(Bill bill){
        billList.add(bill);
    }
    public void displayBill(){
        for (int i = 0; i<billList.size(); i++){
            System.out.println(billList.get(i));
        }
        System.out.println("---------------------");
    }
    public int totalSaleMonth(String month){
        int sum = 0;
        for (int i = 0; i<billList.size(); i++){
            if (billList.get(i).getMonth().equals(month) ){
                sum+=billList.get(i).getTotalPay();
            }
        }
        return sum;
    }
}
