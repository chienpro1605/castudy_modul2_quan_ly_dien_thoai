package property;

import property.MobilePhone;

public class PhoneInforDetail extends MobilePhone {
    private final String STATUS_1="đã bán";
    private final String STATUS_2="còn hàng";
    private int idPhone;
    private String capacity;
    private String color;
    private String nsx;
    private String descriptionPhone;
    private String status;
    public PhoneInforDetail() {
    }

    public PhoneInforDetail(String name, String brand, int price, int idPhone, String capacity, String color, String nsx, String descriptionPhone, String status) {
        super(name, brand, price);
        this.idPhone = idPhone;
        this.capacity = capacity;
        this.color = color;
        this.nsx = nsx;
        this.descriptionPhone = descriptionPhone;
        this.status = status;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getDescriptionPhone() {
        return descriptionPhone;
    }

    public void setDescriptionPhone(String descriptionPhone) {
        this.descriptionPhone = descriptionPhone;
    }

    public String getStatus() {
        if (status.equals("1")){
            this.status = STATUS_1;
        }else if (status.equals("2")){
            this.status = STATUS_2;
        }
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "property.PhoneInforDetail{" +
                "name=" +getName() +
                ", brand=" + getBrand() +
                ", price=" + getPrice() +
                ", idPhone=" + idPhone +
                ", capacity='" + getCapacity() + '\'' +
                ", color='" + color + '\'' +
                ", nsx='" + nsx + '\'' +
                ", descriptionPhone='" + descriptionPhone + '\'' +
                ", status="+ status+
                "} ";
    }
}
