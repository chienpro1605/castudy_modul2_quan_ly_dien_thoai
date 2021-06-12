package services;

import model.Bill;

public interface BillInterFace {
    public void addBill(Bill bill);
    public void displayBill();
    public void seachBill(String name, String phoneNumber);
    public int totalSaleMonth(String month, String year);
}
