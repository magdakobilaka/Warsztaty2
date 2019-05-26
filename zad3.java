import java.util.Scanner;

public class zad3 {

    public static void main(String[] args) {

        GrupDao grupDao = new GrupDao();
        String excercise = getOption();

        if (excercise.equals("add")) {
            String desc = getDescryption();
            Group group = new Group(desc);
            grupDao.create(group);
        } else if (excercise.equals("edit")) {
            int id = getId();
            if (id != 0) {
                Group group = new Group();
                grupDao.create(group);
            }
        } else if (excercise.equals("delete")) {

            int id = getId();
            grupDao.delete(id);

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

