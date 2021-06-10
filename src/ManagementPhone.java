import java.io.IOException;
import java.util.*;

public class ManagementPhone implements Phone {
   private List<PhoneInforDetail> list;

    public ManagementPhone() {
        try {
            this.list = ReadWriteCsv.readToFile("data.csv");
        }catch (Exception e){
            this.list = new ArrayList<>();
        }
    }

    public List<PhoneInforDetail> getList() {
        return list;
    }

    public void setList(List<PhoneInforDetail> list) {
        this.list = list;
    }
    @Override
    public void display(){
        System.out.println("danh sách điện thoại: ");
        for (int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------------------------");
    }
    @Override
    public void addPhone(PhoneInforDetail phoneInforDetail) throws IOException {
        list.add(phoneInforDetail);
        ReadWriteCsv.writeToFile("data.csv", list);
        System.out.println("đã thêm thành công điện thoại vào danh sách");
    }
    @Override
    public boolean checkExistedId(int id){
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getIdPhone() == id){
                return false;
            }
        }
        return true;
    }
    @Override
    public int findById(int id){
        for (int i = 0; i<list.size(); i++){
            if (list.get(i).getIdPhone() == id){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void deletePhone(int id) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int index = findById(id);
        if (index == -1){
            System.out.println("không tìm thấy mã máy này");
        }else {
            System.out.println("bạn có chắc chắn muốn xóa không?    1.yes    2.no");
            int option = scanner.nextInt();
            if (option ==1){
                list.remove(index);
                ReadWriteCsv.writeToFile("data.csv", list);
                System.out.println("bạn đã xóa thành công");
                display();
            }else if (option == 2){
                System.out.println("ok k xóa thì thôi!");
            }
        }
    }
    @Override
     public void editPhone(int id, PhoneInforDetail phoneInforDetail) throws IOException {
         if (findById(id) == -1){
             System.out.println("mã máy này k tồn tại");
         }else {
             list.set(findById(id), phoneInforDetail);
             ReadWriteCsv.writeToFile("data.csv", list);
             System.out.println("cập nhật thành công");
         }
     }
     @Override
     public void seachById(int id){
        int index = findById(id);
        if (index == -1){
            System.out.println("mã máy này không tồn tại");
        }else {
            System.out.println(list.get(index).toString());
        }
    }
    @Override
    public void seachByName(String name){
        boolean checkName  = false;
         for (int i = 0; i<list.size(); i++){
             if (list.get(i).getName().equals(name)){
                 System.out.println(list.get(i).toString());
                 checkName = true;
             }
         }
         if (!checkName){
             System.out.println("tên điện thoại này không tồn tại");
         }
    }
    @Override
    public void seachByPrice(int firstPrice, int lastPrice){
        boolean checkPrice = false;
        for (int i = 0; i<list.size(); i++){
            if (firstPrice<= list.get(i).getPrice() && list.get(i).getPrice()<= lastPrice){
                System.out.println(list.get(i).toString());
                checkPrice = true;
            }
        }
        if (!checkPrice){
            System.out.println("không tìm thấy");
        }
    }
    @Override
    public void sortByPrice(){
        Collections.sort(list, new Comparator<PhoneInforDetail>() {
            @Override
            public int compare(PhoneInforDetail o1, PhoneInforDetail o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
    @Override
    public void sortByName(){
        Collections.sort(list, new Comparator<PhoneInforDetail>() {
            @Override
            public int compare(PhoneInforDetail o1, PhoneInforDetail o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    @Override
    public void sortByBrand(){
        Collections.sort(list, new Comparator<PhoneInforDetail>() {
            @Override
            public int compare(PhoneInforDetail o1, PhoneInforDetail o2) {
                int result = o1.getBrand().compareTo(o2.getBrand());
                if (result == 0)
                    return o1.getName().compareTo(o1.getName());
                    return result;
            }
        });
    }
}
