package Menu;
import java.util.Scanner;
public class Menu {

private static Scanner in = new Scanner(System.in);

public static Registerpatient patients = new Registerpatient();
    public static Appoinments appointments = new Appoinments();

    public static MedicineUI meds = new MedicineUI();

    public static Billing bill = new Billing();
    public static void mainmenu(){
        Integer opcion;

        System.out.println(" ___________..........___________" +
                "\n" + "Sanipet - Veterinary care center" +
                "\n" + "1. Register patient " +
                "\n" + "2. Appoinments" +
                "\n" + "3. Billing" +
                "\n" + "4. Medicine Stock" +
                "\n" + "5. Exit" +
                "");
        opcion = Integer.parseInt(in.nextLine());

        options(opcion);
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

        }
        if(Option != 5) {
            mainmenu();
        }
    }






}
