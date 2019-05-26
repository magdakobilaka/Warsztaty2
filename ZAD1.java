import java.sql.*;
import java.util.Scanner;

public class ZAD1 {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        String user = getOption();

        if (user.equals("add")) {

            String name = getNAME();
            String email = getEmail();
            String paswpord = getPasswordl();
            User user1 = new User(name, email, paswpord);
            userDao.create(user1);
        } else if (user.equals("edit")) {
            int id = getId();
            if (id != 0) {
                String name = getNAME();
                String email = getEmail();
                String paswpord = getPasswordl();
                User user1 = new User(name, email, paswpord);
                userDao.update(user1);
            }
        } else if (user.equals("delete")) {

            int id = getId();
            userDao.delete(id);

        } else if (user.equals("quit")) {
            System.exit(0);

        }

    }


    private static String getOption() {

        UserDao.findall();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Obcje :  %n , add %n, edit %n, delete %n ,quit %s ");
        return scanner.nextLine();
    }

    private static String getNAME() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Imie:");
        return scanner.nextLine();
    }

    private static String getEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Mail:");
        return scanner.nextLine();
    }

    private static String getPasswordl() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Password:");
        return scanner.nextLine();
    }

    private static int getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodaj id: ");
        return scanner.nextInt();
    }

}

