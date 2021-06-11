import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {
     static final String CAPACITY_REGEX ="^[1-9]{4}[ ][m][A][h]$";//xxxx mAh
     static final String NSX_REGEX ="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";//DD-MM-YYYY
     static final String PHONENUMBER_REGEX = "^[0][2359][0-9]{8}$";
     static final String DAYORDER_REGEX = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
     static final String USERNAME_REGEX = "^[a-zA-Z0-9]*$";
     static final String PASSWORD_REGEX = "^[a-zA-Z0-9||!@#$%^&*>]*$";
     static final String EMAIL_REGEX = "^[a-zA-Z0-9]*[@][g][m][a][i][l][.][a-z]*$";

    public static boolean valid(String str, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
