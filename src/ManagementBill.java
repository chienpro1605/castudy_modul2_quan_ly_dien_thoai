import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    public void seachBill(String name){
        boolean customerName = false;
        for (int i = 0; i< billList.size(); i++){
            if (billList.get(i).getCustomerName().equals(name)){
                System.out.println( billList.get(i));
                customerName = true;
            }
        }if (!customerName){
            System.out.println("không tồn tại tên khách hàng này");
        }
    }
    @Override
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
