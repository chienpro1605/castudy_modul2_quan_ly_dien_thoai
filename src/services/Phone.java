package services;

import model.PhoneInforDetail;

import java.io.IOException;

public interface Phone {
    public void display();
    public void addPhone(PhoneInforDetail phoneInforDetail) throws IOException;
    public boolean checkExistedId(int id);
    public int findById(int id);
    public void deletePhone(int id) throws IOException;
    public void editPhone(int id, PhoneInforDetail phoneInforDetail) throws IOException;
    public void seachById(int id);
    public void seachByName(String name);
    public void seachByPrice(int firstPrice, int lastPrice);
    public void sortByPrice();
    public void sortByName();
    public void sortByBrand();
}
