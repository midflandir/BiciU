package Menu;
import Domain.Users.user;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Scanner;

import static DAO.Daousers.readusers;

public class BorrowBicycle {
    private static Registeruser reguser = new Registeruser();
    private static Scanner in = new Scanner(System.in);
    public static void start(){
        String ID;
        System.out.println("Please enter your ID");
        ID = in.nextLine();

        ArrayList<user> Userlist = new ArrayList<user>();
        Userlist = readusers();

        for (int i = 0; i < Userlist.size(); i++) {


            if ( Userlist.get(i).getTicketdebts() > 0){
                System.out.println("The user" + ID + "has a ticket with debt Please cancel it and try again");
            }
            if ( Userlist.get(i).getTicketdebts() == 0){

            }

        }
    }
}
