package Example.Test;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserValidator {
    private static String name = "";
    private static String password = "";
    private static String status;

    public static boolean authenticate(String name, String password) {
        boolean check = false;
        FileAccount fileaccount = new FileAccount();
        List<String[]> logindata = fileaccount.read("logindata.csv");
        String[] tab;
        int i = 0;
        while (check == false) {
            tab = logindata.get(i);
            UserValidator.name = tab[0];
            UserValidator.password = tab[1];
            if (UserValidator.name.equals(name) & UserValidator.password.equals(password)) {
                check = true;
                break;
            }
            i++;
            if (i == logindata.size()) {
                break;
            }
        }
        return check;
    }

    public static boolean checkAccess(String name, String password) {
        boolean check = false;
        FileAccount fileaccount = new FileAccount();
        List<String[]> logindata = fileaccount.read("logindata.csv");
        String[] tab;
        int i = 0;
        while (check == false) {
            tab = logindata.get(i);
            UserValidator.name = tab[0];
            UserValidator.password = tab[1];
            status = tab[2];
            if (UserValidator.name.equals(name) & UserValidator.password.equals(password) & status.equals("administrator")) {
                check = true;
                break;
            }
            i++;
            if (i == logindata.size()) {
                break;
            }
        }
        return check;
    }
}