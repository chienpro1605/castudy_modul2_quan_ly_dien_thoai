import java.util.Scanner;

public class Login {
    static Scanner scanner = new Scanner(System.in);
    static void login(){
        System.out.println("===========HELLO PẠN===========");
        System.out.println("user name: ");
        String username = scanner.nextLine();

        System.out.println("password: ");
        String passWord = scanner.nextLine();

        if (username.equals("chaoanhchiendz") && passWord.equals("chien123")){
            System.out.println("bạn đã đăng nhập thành công");
        }else {
            System.err.println("Đăng nhập thất bại!!");
            login();
        }
    }
}