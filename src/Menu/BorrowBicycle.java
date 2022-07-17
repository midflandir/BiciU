package Menu;

import Domain.Ticket.Ticket;
import Domain.Users.user;
import Domain.bicycle.Bicycle;
import Domain.bicycle.EnumType;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static DAO.DaoBicycles.bicyclenotavalible;
import static DAO.DaoBicycles.readbicycles;
import static DAO.DaoTickets.readtickets;
import static DAO.Daousers.readusers;
import static DAO.DaoTickets.Ticketgenerator;
public class BorrowBicycle {
    private static Registeruser reguser = new Registeruser();
    private static Scanner in = new Scanner(System.in);
    private static  Integer ticketsize = 0;

    public static void start() throws IOException {

        readtickets();
        String ID, username = "";
        Boolean hasdebt = false, userfind = false;
        System.out.println("Please enter your ID");
        ID = in.nextLine();

        ArrayList<user> Userlist = new ArrayList<user>();
        Userlist = readusers();

        for (int i = 0; i < Userlist.size(); i++) {
        if(Userlist.get(i).getID().equals(ID)) {
            username = Userlist.get(i).getName();
            userfind = true;

        }
        }
        if (!hasdebt(ID) && userfind == true) {
            borrow(ID, username);
        }else {
            System.out.println("The User was not found or user has debt");
        }

}


    public static boolean hasdebt(String userID) {

        List<Ticket> Ticketlist = new ArrayList<Ticket>();
        Ticketlist = readtickets();
        boolean hasdebt = false;
        for (int i = 0; i < Ticketlist.size(); i++) {
            if (Ticketlist.get(i).getAmount() > 0) {
                hasdebt = true;

            }
        }
        ticketsize = Ticketlist.size();
        return hasdebt;
    }






    public static void borrow(String userID, String username) throws IOException {
        String type;
        List<Bicycle> bicyclelist = new ArrayList<Bicycle>();
        boolean thereisabicycle = false;
        System.out.println("Please Choose a bycicle type Mountain (M) - Road (R): ");
        type = in.nextLine();
        if (type.equals("M") || type.equals("R")) {
            bicyclelist = readbicycles();
            findavalible(type, userID, username, bicyclelist);

        }
    }

    public static void findavalible(String type, String userID, String username, List<Bicycle> bicyclelist) throws IOException {
        Bicycle bicycle;
        boolean thereisabicycle = false;
        for (int i = 0; i < bicyclelist.size(); i++) {

            if (type.equals("M") && bicyclelist.get(i).getType().equals(EnumType.Mountain)
                    && bicyclelist.get(i).isIsavalible() == true)
            {
                bicycle = bicyclelist.get(i);
                thereisabicycle = true;
                i = bicyclelist.size();
                maketicket(userID, username, bicycle);

            }
            if (type.equals("R") && bicyclelist.get(i).getType().equals(EnumType.Road)
                    && bicyclelist.get(i).isIsavalible() == true)
            {
                bicycle = bicyclelist.get(i);
                thereisabicycle = true;
                i = bicyclelist.size();
                maketicket(userID, username, bicycle);
            }
        }
        if (thereisabicycle == false && type.equals("M")) {
            System.out.println("There is no Mountain Bicycle available. Choose another one");
        }
        if (thereisabicycle == false && type.equals("R")) {
            System.out.println("There is no Road Bicycle available. Choose another one");
        }
    }


    public static void maketicket(String userID, String username, Bicycle bicycle) throws IOException {
        bicyclenotavalible(bicycle);
        System.out.println("Bicycle chosen!" + "\n" +
                "Code: " + bicycle.getCode() + "\n" +
                "Type: " + bicycle.getType() + "\n" +
                "Color: " + bicycle.getColor() +
                "\n");

        Ticketgenerator(userID, username, bicycle, ticketsize + 1);
    }


}
