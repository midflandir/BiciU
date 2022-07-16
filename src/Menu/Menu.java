package Menu;
import java.util.Scanner;
public class Menu {

private static Scanner in = new Scanner(System.in);

public static Registerpatient patients = new Registerpatient();
    public static Appoinments appointments = new Appoinments();

    public static MedicineUI meds = new MedicineUI();

    public static Billing bill = new Billing();
    public static void mainmenu(){
        Integer option;
    try {
        System.out.println(" ___________..........___________" +
                "\n" + "BICI - U" +
                "\n" + "1. Register user " +
                "\n" + "2. Borrow Bicycle" +
                "\n" + "3. Return Bicycle" +
                "\n" + "4. Pay tickets" +
                "\n" + "5. Tickets history" +
                "\n" + "6. Exit" +
                "");
        option = Integer.parseInt(in.nextLine());

        options(option);
    }catch (Exception e){
        System.out.println("Wrong option");
        mainmenu();
    }

    }

    public static void options(Integer Option){

        switch (Option) {
            case 1:
                patients.register();
                break;
            case 2:
                appointments.start();
                break;
            case 3:
                bill.start();
                break;
            case 4:
                meds.start();
            break ;
            case 5:
                meds.start();
                break ;

        }
        if(Option != 6) {
            mainmenu();
        }
    }






}
