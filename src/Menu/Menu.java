package Menu;

import java.util.Scanner;

public class Menu {

    public static BorrowBicycle borrow = new BorrowBicycle();
    public static PayTickets pay = new PayTickets();
    public static Registeruser register = new Registeruser();
    public static ReturnBicycle returnBicy = new ReturnBicycle();
    public static Ticketshistory ticketshis = new Ticketshistory();
    private static Scanner in = new Scanner(System.in);

    public static void mainmenu() {
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
        } catch (Exception e) {
            System.out.println("Wrong option");
            mainmenu();
        }
    }

    public static void options(Integer Option) {

        switch (Option) {
            case 1:
                Registeruser.start();
                break;
            case 2:
                BorrowBicycle.start();
                break;
            case 3:
                ReturnBicycle.start();
                break;
            case 4:
                PayTickets.start();
                break;
            case 5:
                Ticketshistory.start();
                break;

        }
        if (Option != 6) {
            mainmenu();
        }
    }


}
