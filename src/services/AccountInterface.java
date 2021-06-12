package services;

import java.io.IOException;

public interface AccountInterface {
    public void registerAccount() throws IOException;
    public boolean checkLogIn(String name, String password);
    public void logIN();

}
