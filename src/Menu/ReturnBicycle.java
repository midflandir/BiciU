package Menu;

import Domain.bicycle.Bicycle;
import Domain.bicycle.EnumType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static DAO.DaoBicycles.bicycleisavalible;
import static DAO.DaoBicycles.bicyclenotavalible;
import static DAO.DaoBicycles.readbicycles;
import static DAO.DaoTickets.Ticketgenerator;

public class ReturnBicycle {
    private static Scanner in = new Scanner(System.in);
    public static void start() throws IOException {
        String auxBicycleID, helmet, condition, status;
        System.out.println("Please enter the ticket ID: ");
        auxBicycleID = in.nextLine();
        System.out.println("bicycle has helmet:  Yes NO (Y)/(N)");
        helmet = in.nextLine();
        System.out.println("bicycle is in good condition:  Yes NO (Y)/(N)");
        condition = in.nextLine();
        calculatedebt();
    }



    public static void makebicycleavalible(String Bicycleid) throws IOException {
        List<Bicycle> bicyclelist = new ArrayList<Bicycle>();
        for (int i = 0; i < bicyclelist.size(); i++) {

            if (bicyclelist.get(i).getCode().equals(Bicycleid)){
                bicycleisavalible(bicyclelist.get(i));
            }
        }

    }



    public static void calculatedebt(String userID, String username, Bicycle bicycle) throws IOException {
        bicyclenotavalible(bicycle);
        System.out.println("Bicycle chosen!" + "\n" +
                "Code: " + bicycle.getCode() + "\n" +
                "Type: " + bicycle.getType() + "\n" +
                "Color: " + bicycle.getColor() +
                "\n");

        Ticketgenerator(userID, username, bicycle,  1);

        makebicycleavalible(BicycleID);
    }
}
