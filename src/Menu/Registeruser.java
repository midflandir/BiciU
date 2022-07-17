package Menu;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Registeruser {
    private static Scanner in = new Scanner(System.in);

    public static void start() {
        String userrole;

        System.out.println("press Student (S) or Professor (P)");
        userrole = in.nextLine();
        if (userrole.equals("S") || userrole.equals("P") ) {
            userrole = "S";
            readdata(userrole);
        }
        if (!userrole.equals("S") && !userrole.equals("P")) {
            System.out.println("Wrong Option");
        }

    }
    public static void readdata(String userrole){
        String auxname, auxsurname, auxdni;
        Integer auxage;
        System.out.println("Please enter your DNI");
        auxdni = in.nextLine();
        System.out.println("Please enter your name");
        auxname = in.nextLine();
        System.out.println("Please enter your surname");
        auxsurname = in.nextLine();
        try{
            System.out.println("Please enter your age");
            auxage = Integer.parseInt(in.nextLine());
            if (auxage >= 18){
                register(userrole, auxdni, auxname, auxsurname, auxage);
            }
            if (auxage < 18){
                System.out.println("You must be 18+ years old to be registered");
            }
        }catch(Exception e){
            System.out.println("Error - you must enter your age in numbers");
        }

    }
    public static  void register(String userrole, String auxdni,
                                 String auxname, String auxsurname,
                                 Integer auxage) {

        try {
            FileWriter myWriter = new FileWriter("src/Data/users.txt", true);
            myWriter.append("\n" + userrole + "-" + auxdni + ";" +
                    auxname + " " + auxsurname + ";" +
                    auxage);
            myWriter.close();
            System.out.println("Register Completed! \n" +
                    "ID: " + userrole + "-" + auxdni + "\n" +
                    "Name: " + auxname + " " + auxsurname + "\n" +
                    "Age: " + auxage);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
