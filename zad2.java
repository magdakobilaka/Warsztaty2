import java.util.Scanner;

public class zad2 {

    public static void main(String[] args) {

  ExerciseDao exerciseDao =new ExerciseDao();
        String excercise= getOption();

        if (excercise.equals("add")) {

            String title = gettitle();
            String desc = getDescryption();
          Exercise exercise =new Exercise(title,desc);
            exerciseDao.create(exercise);
        } else if (excercise.equals("edit")) {
            int id = getId();
            if (id != 0) {
                String title = gettitle();
                String desc = getDescryption();
                Exercise exercise =new Exercise(title,desc);
                exerciseDao.create(exercise);
            }
        } else if (excercise.equals("delete")) {

            int id = getId();
            exerciseDao.delete(id);

        } else if (excercise.equals("quit")) {
            System.exit(0);

        }

    }

    private static String getOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Obcje :  %n , add %n, edit %n, delete %n ,quit %s ");
        return scanner.nextLine();
    }

    private static String gettitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj Tytuł:");
        return scanner.nextLine();
    }

    private static String getDescryption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("PodajOpis:");
        return scanner.nextLine();
    }



    private static int getId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPodaj id: ");
        return scanner.nextInt();
    }

}

