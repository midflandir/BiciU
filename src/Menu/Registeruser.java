package Menu;

import java.util.Scanner;
import java.util.ArrayList;
public class Registeruser {
    private static Scanner in = new Scanner(System.in);
    public static void start(){
        int aux;

        try {
            System.out.println("press 1 to cat or 2 for dog");
            aux = Integer.parseInt(in.nextLine());

        } catch (Exception e) {
            System.out.println("invalid option");
        }
    }
}
