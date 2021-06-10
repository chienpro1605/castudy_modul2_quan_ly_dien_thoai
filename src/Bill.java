public class Bill extends Order{

    private int idOrder;
    private int idPhone;
    private String phoneName;
    private int price;
    private int amount;
    private int totalPay;
    ManagementPhone manaPhone = new ManagementPhone();

    public Bill() {
    }
    public Bill(String customerName, String phoneNumber, String address, int idPhone,String phoneName, int price, String dayOrder, int idOrder, int amount, int totalPay) {
        super(customerName, phoneNumber, address, dayOrder);
        this.idPhone = idPhone;
        this.idOrder = idOrder;
        this.amount = amount;
        this.phoneName = phoneName;
        this.price = price;
        this.totalPay = totalPay;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdPhone(int idPhone) {
        for (int i = 0; i<manaPhone.getList().size(); i++){
            if (manaPhone.getList().get(i).getIdPhone() == idPhone){
                return manaPhone.getList().get(i).getIdPhone();
            }
        }
        return -1;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getPhoneName(int idPhone) {
        for (int i = 0; i<manaPhone.getList().size(); i++){
            if ((manaPhone.getList().get(i).getIdPhone() == idPhone)){
                return manaPhone.getList().get(i).getName();
            }
        }
        return "mã máy này không tồn tại";
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPrice(int idPhone) {
        for (int i = 0; i<manaPhone.getList().size(); i++){
            if ((manaPhone.getList().get(i).getIdPhone() == idPhone)){
                return manaPhone.getList().get(i).getPrice()*1000;
            }
        }
        return -1;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getTotalPay(){
        return this.amount*getPrice(idPhone);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "customerName='" + getCustomerName() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", address=" + getAddress() +
                ", dayOrder='" + getDayOrder() +
                ", idOrder=" + idOrder +
                ", idPhone=" + getIdPhone(idPhone) +
                ", phoneName=" + getPhoneName(idPhone) +
                ", price=" + getPrice(idPhone) +
                ", amount=" + amount +
                ", totalPay=" + getTotalPay() +
                "} "+"\n";
    }
}
