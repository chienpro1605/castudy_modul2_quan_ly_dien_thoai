package model;

public abstract class Order {
    private String customerName;
    private String phoneNumber;
    private String address;
    private String dayOrder;

    public Order() {
    }

    public Order(String customerName, String phoneNumber, String address, String dayOrder) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dayOrder = dayOrder;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(String dayOrder) {
        this.dayOrder = dayOrder;
    }

    @Override
    public String toString() {
        return "property.Order{" +
                "customerName='" + customerName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                ", dayOrder='" + dayOrder + '\'' +
                '}';
    }
    public abstract int getTotalPay();
    public String getMonth(){
        String[] month = dayOrder.split("/");
        return month[1];
    }
}
