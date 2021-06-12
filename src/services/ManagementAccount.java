package services;

import model.Account;
import readwritefile.ReadWriteAccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementAccount implements AccountInterface{
 private List<Account> accountList;
 public ManagementAccount(){
     try {
         this.accountList = ReadWriteAccount.readAccount("account.csv");
     }catch (Exception e){
         this.accountList = new ArrayList<>();
     }
 }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    @Override
    public void registerAccount() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên tài khoản đăng ký: ");
        String nameAccount;
        do {
            nameAccount = scanner.nextLine();
            if (!ValidatePhone.valid(nameAccount, ValidatePhone.USERNAME_REGEX)){
                System.out.println("sai đinh dạng nhâp lại");
            }else {
                break;
            }
        }while (!ValidatePhone.valid(nameAccount, ValidatePhone.USERNAME_REGEX));
        System.out.println("nhập mật khẩu đăng ký: ");
        String password;
        do {
            password = scanner.nextLine();
            if (!ValidatePhone.valid(password, ValidatePhone.PASSWORD_REGEX)){
                System.out.println("sai định dạng, nhập lại!");
            }else {
                break;
            }

        }while (!ValidatePhone.valid(nameAccount, ValidatePhone.PASSWORD_REGEX));
        System.out.println("nhập email đăng ký: ");
        String email;
        do {
            email = scanner.nextLine();
            if (!ValidatePhone.valid(email, ValidatePhone.EMAIL_REGEX)){
                System.out.println("sai định dạng, nhập lại!");
            }else {
                break;
            }
        }while (!ValidatePhone.valid(nameAccount, ValidatePhone.EMAIL_REGEX));
        Account account = new Account(nameAccount, password, email);
        accountList.add(account);
        ReadWriteAccount.writeAcount("account.csv", accountList);
        System.out.println("bạn đã đăng ký thành công!");

    }
    @Override
    public boolean checkLogIn(String name, String password){
      for (int i = 0; i<accountList.size(); i++){
          if (accountList.get(i).getNameAccount().equals(name) && accountList.get(i).getPassWord().equals(password)){
              return true;
          }

      }
        return false;
 }
    @Override
    public void logIN(){
     Scanner scanner = new Scanner(System.in);
     String name;
     String passWord;
        do {
            System.out.println("nhập userName: ");
            name = scanner.nextLine();
            System.out.println("nhập passWord: ");
            passWord = scanner.nextLine();
            if (checkLogIn(name,passWord)){
                System.out.println("bạn đã đăng nhập thành công: ");
            }else {
                System.err.println("mật khẩu hoặc tên đăng nhập sai!");
            }
        }while (!checkLogIn(name, passWord));
    }
}
