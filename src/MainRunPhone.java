import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainRunPhone {
    public static void main(String[] args) throws IOException {
        Bill bill = new Bill();
        ManagementPhone managementPhone = new ManagementPhone();
        Scanner scanner = new Scanner(System.in);
        ValidatePhone validatePhone = new ValidatePhone();
        ManagementBill managementBill = new ManagementBill();
        ManagementAccount managementAccount = new ManagementAccount();
        System.out.println("Bạn đã có tài khoản chưa? Nếu chưa hãy đăng ký: ");
        System.out.println("1.Đăng nhập      2.Đăng ký");
        int optionAcount = scanner.nextInt();
        scanner.nextLine();
        if (optionAcount == 1){
            managementAccount.logIN();
        }else if (optionAcount == 2){
            managementAccount.registerAccount();
            managementAccount.logIN();
        }else {
            System.out.println("bấm 1 và 2 thôi pạn ơi!");
        }

       // Login.login();
        while (true){
            showMenu();
            int choice =-1;
            while (choice == -1){
                try {
                    choice = scanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("nhập số ý đừng có nhập chữ pạn ơi!");
                }finally {
                    scanner.nextLine();
                }
            }
            switch (choice){
                case 1:
                    System.out.println("nhập vào thông tin điện thoai: ");
                    System.out.println("nhập vào id: ");
                    int id =-1 ;
                    while (id ==-1) {
                        try {
                            id = scanner.nextInt();
                        } catch (InputMismatchException exception) {
                            System.out.println("sai định dạng nhập số nhé!");
                        } finally {
                            scanner.nextLine();
                        }
                    }
                    if (managementPhone.checkExistedId(id)){
                        System.out.println("nhập tên điện thoại cần thêm: ");
                        String name = scanner.nextLine();
                        System.out.println("nhập hãng điện thoại cần thêm: ");
                        String brand = scanner.nextLine();
                        System.out.println("nhập giá điện thoại cần thêm: ");
                        int price = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("nhập dung lượng điện thoại cần thêm: ");
                        String capacity;
                        do {
                            capacity = scanner.nextLine();
                            if (!validatePhone.valid(capacity,validatePhone.CAPACITY_REGEX)){
                                System.out.println("sai định dạng nhập lại đi!");
                            }
                        }while (!validatePhone.valid(capacity,validatePhone.CAPACITY_REGEX));
                        System.out.println("nhập màu điện thoại muốn thêm: ");
                        String color = scanner.nextLine();
                        System.out.println("nhập ngày sản xuất: ");
                        String nsx = "";
                        do {
                            nsx = scanner.nextLine();
                            if (!validatePhone.valid(nsx,validatePhone.NSX_REGEX)){
                                System.out.println("sai định dạng nhập lại đi!");
                            }
                        }while (!validatePhone.valid(nsx,validatePhone.NSX_REGEX));
                        System.out.println("mô tả chi tiết điện thoại: ");
                        String descriptation = scanner.nextLine();
                        System.out.println("nhập trạng thái: 1.đã bán    2.còn hàng");
                        String status = scanner.nextLine();
                        managementPhone.addPhone(new PhoneInforDetail(name, brand, price, id, capacity, color, nsx, descriptation,status));
                    }
                    break;
                case 2:
                    managementPhone.display();
                    break;
                case 3:
                    System.out.println("nhập mã số điện thoại cần update: ");
                    int idPhone = scanner.nextInt();
                    if (managementPhone.findById(idPhone) == -1){
                        System.out.println("không tìm thấy mã điện thoại này");
                    }else {
                        scanner.nextLine();
                        System.out.println("nhập tên điện thoại cần update: ");
                        String name = scanner.nextLine();
                        System.out.println("nhập hãng điện thoại cần update: ");
                        String brand = scanner.nextLine();
                        System.out.println("nhập giá điện thoại cần updae: ");
                        int price = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("nhập dung lượng cần update: ");
                        String capacity1;
                        do {
                            capacity1 = scanner.nextLine();
                            if (!validatePhone.valid(capacity1,validatePhone.CAPACITY_REGEX)){
                                System.out.println("sai định dạng nhập lại đi!");
                            }
                        }while (!validatePhone.valid(capacity1,validatePhone.CAPACITY_REGEX));
                        System.out.println("nhập màu điện điện thoại cần update: ");
                        String color = scanner.nextLine();
                        System.out.println("nhập ngày sản xuất cần update: ");
                        String nsx1 = "";
                        do {
                            nsx1 = scanner.nextLine();
                            if (!validatePhone.valid(nsx1,validatePhone.NSX_REGEX)){
                                System.out.println("sai định dạng nhập lại đi!");
                            }
                        }while (!validatePhone.valid(nsx1,validatePhone.NSX_REGEX));
                        System.out.println("update mô tả điện thoại: ");
                        String description = scanner.nextLine();
                        System.out.println();
                        System.out.println("nhập trạng thái: 1.đã bán    2.còn hàng");
                        String status = scanner.nextLine();
                        managementPhone.editPhone(idPhone, new PhoneInforDetail(name,brand, price, idPhone,capacity1, color, nsx1, description,status));
                    }
                    break;
                case 4:
                    System.out.println("nhập mã điện thoại cần xóa: ");
                    int id2 = scanner.nextInt();
                    if (managementPhone.findById(id2)== -1){
                        System.out.println("mã điện thoại không tồn tại!");
                    }else {
                        managementPhone.deletePhone(id2);
                    }
                    break;
                case 5:
                    System.out.println("bạn muốn tìm kiếm điện thoại theo cách nào??");
                    System.out.println("1.theo mã máy   2.theo tên     3.theo giá");
                    int option = scanner.nextInt();
                    switch (option){
                        case 1:
                            System.out.println("nhập mã máy cần tìm kiếm: ");
                            int id3 = scanner.nextInt();
                            managementPhone.seachById(id3);
                            break;
                        case 2:
                            scanner.nextLine();
                            System.out.println("nhập tên điện thoại cần tìm kiếm: ");
                            String name3 = scanner.nextLine();
                            managementPhone.seachByName(name3);
                            break;
                        case 3:
                            System.out.println("nhập khoảng giá cần tìm kiếm: ");
                            System.out.println("firstprice: ");
                            int firstPrice = scanner.nextInt();
                            System.out.println("lastPrice: ");
                            int lastPrice = scanner.nextInt();
                            managementPhone.seachByPrice(firstPrice, lastPrice);
                            break;
                    }
                    break;
                case 6:
                    System.out.println("bạn muốn sắp xếp danh sách điện thoại theo kiểu gì: ");
                    System.out.println("1.sắp xếp theo giá      2.sắp xếp theo tên      3.sắp xếp theo hãng");
                    int option1 = scanner.nextInt();
                    switch (option1){
                        case 1:
                            managementPhone.sortByPrice();
                            ReadWriteCsv.writeToFile("data.csv", managementPhone.getList());
                            managementPhone.display();
                            break;
                        case 2:
                            managementPhone.sortByName();
                            ReadWriteCsv.writeToFile("data.csv", managementPhone.getList());
                            managementPhone.display();
                            break;
                        case 3:
                            managementPhone.sortByBrand();
                            ReadWriteCsv.writeToFile("data.csv", managementPhone.getList());
                            managementPhone.display();
                            break;
                    }
                    break;
                case 7:
                    ReadWriteCsv.readToFile("data.csv");
                    managementPhone.display();
                    break;
                case 8:
                    System.out.println("tên khách hàng: ");
                    String customerName = scanner.nextLine();
                    System.out.println("số điện thoại khách hàng: ");
                    String phoneNumber;
                    do {
                        phoneNumber = scanner.nextLine();
                        if (!validatePhone.valid(phoneNumber,validatePhone.PHONENUMBER_REGEX)){
                            System.out.println("sai định dạng nhập lại đi!");
                        }
                    }while (!validatePhone.valid(phoneNumber,validatePhone.PHONENUMBER_REGEX));
                    System.out.println("địa chỉ khách hàng: ");
                    String address = scanner.nextLine();
                    System.out.println("nhập mã máy đơn hàng: ");
                    int idPhone4 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("nhập ngày đặt hàng: ");
                    String dayOrDer;
                    do {
                        dayOrDer = scanner.nextLine();
                        if (!validatePhone.valid(dayOrDer,validatePhone.DAYORDER_REGEX)){
                            System.out.println("sai định dạng nhập lại đi!");
                        }
                    }while (!validatePhone.valid(dayOrDer,validatePhone.DAYORDER_REGEX));
                    String namePhone = bill.getPhoneName(idPhone4);
                    int price = bill.getPrice(idPhone4);
                    int totalPrice = bill.getTotalPay();
                    System.out.println("nhập mã đơn hàng: ");
                    int idOrDer = scanner.nextInt();
                    System.out.println("nhập số lượng đặt hàng: ");
                    int amount = scanner.nextInt();
                    managementBill.addBill(new Bill(customerName,phoneNumber, address, idPhone4, namePhone, price, dayOrDer,idOrDer, amount, totalPrice));
                    ReadWriteCsvBill.writeToBill("billdata.csv",managementBill.getBillList(), idPhone4);
                    break;
                case 9:
                    ReadWriteCsvBill.readFromBill("billdata.csv");
                    managementBill.displayBill();
                    break;
                case 10:
                    System.out.println("tổng daonh thu tháng x");
                    String month = scanner.nextLine();
                    System.out.println(managementBill.totalSaleMonth(month));
                    break;
                case 11:
                    System.out.println("nhập tên khách hàng cần tìm kiếm:  ");
                    String name = scanner.nextLine();
                    managementBill.seachBill(name);
                    break;
                case 12:
                    System.out.println("sy iu ơ gên!!");
                    System.exit(0);
            }
        }
    }
    public static void showMenu(){
        System.out.println("=======WELCOME YOU TO THẾ GIỚI DI ĐỘNG====");
        System.out.println("1.thêm mới điện thoại: ");
        System.out.println("2.hiển thị thông tin điện thoại: ");
        System.out.println("3.cập nhật thông tin điện thoại: ");
        System.out.println("4.xóa thông tin điện thoại");
        System.out.println("5.tìm kiếm điện thoại");
        System.out.println("6.sắp xếp danh sách điện thoại");
        System.out.println("7.hiển thị danh sách điện thoại đã lưu");
        System.out.println("8.đặt hàng");
        System.out.println("9.hiển thị các đơn đặt hàng");
        System.out.println("10.tổng doanh thu hằng tháng");
        System.out.println("11.tìm kiếm hóa đơn");
        System.out.println("12.thoát");
    }
}
