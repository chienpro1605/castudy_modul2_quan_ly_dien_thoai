package model;

public class Account {
    private String nameAccount;
    private String passWord;
    private String email;

    public Account() {
    }

    public Account(String nameAccount, String passWord, String email) {
        this.nameAccount = nameAccount;
        this.passWord = passWord;
        this.email = email;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "model.Account{" +
                "nameAccount='" + nameAccount + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
