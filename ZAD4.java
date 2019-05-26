import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class ZAD4 {

    public static void main(String[] args) {

        SolutionDao solutionDao = new SolutionDao();
        return solutionDao

        String solution = getOption();

        if (solution.equals("add")) {
            int id =1;//nie było w bazie danych zdefinoiowe auto_increment
            String creted = getcreatede();
            String updated = " ";
            int userid = userId();
            int exAMID = excerciseId();
            Solution solution1 = new Solution(id,creted,updated,exAMID,userid);
            solutionDao.create(solution1);

        } else if (solution.equals("delete")) {

            int id = getId();
            solutionDao.delete(id);

        } else if (solution.equals("quit")) {
            System.exit(0);

        }

    }

    private static String getOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Obcje :  %n , add %n, edit %n, delete %n ,quit %s ");
        return scanner.nextLine();
    }

    private static String getcreatede() {
        Date now = new Date();
        LocalDate current = now.toInstant()
                .atZone(ZoneId.systemDefault()) // Specify the correct timezone
                .toLocalDate();
        String time = current.toString();

        return time;
    }


    private static int getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodaj id: ");
        return scanner.nextInt();
    }

    private static int userId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodaj id urzytkownika: ");
        return scanner.nextInt();
    }

    private static int excerciseId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodaj id zadania : ");
        return scanner.nextInt();
    }

}

