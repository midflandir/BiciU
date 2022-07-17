package Menu;

import Domain.Ticket.Status;
import Domain.Ticket.Ticket;
import Domain.bicycle.Bicycle;
import Domain.bicycle.EnumType;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static DAO.DaoBicycles.bicycleisavalible;
import static DAO.DaoBicycles.bicyclenotavalible;
import static DAO.DaoBicycles.readbicycles;
import static DAO.DaoTickets.Ticketgenerator;
import static DAO.DaoTickets.readtickets;
import static DAO.DaoTickets.updateticket;

public class ReturnBicycle {
    private static Scanner in = new Scanner(System.in);
    public static void start() throws IOException {
        String auxTicketID, helmet, condition, status;
        System.out.println("Please enter the ticket ID: ");
        auxTicketID = in.nextLine();
        System.out.println("bicycle has helmet:  Yes NO (Y)/(N)");
        helmet = in.nextLine();
        System.out.println("bicycle is in good condition:  Yes NO (Y)/(N)");
        condition = in.nextLine();
        calculatedebt(auxTicketID,helmet, condition);
    }



    public static void calculatedebt(String auxTicketID, String helmet, String condition) throws IOException {
        List<Ticket> Ticketlist = new ArrayList<Ticket>();
        Ticketlist = readtickets();
        Ticket auxticket;
        for (int i = 0; i < Ticketlist.size(); i++) {

            if (Ticketlist.get(i).getCode().equals(auxTicketID)){
                auxticket =  Ticketlist.get(i);
                auxticket.setEndtime(LocalTime.now());

                Long millis = Duration.between(Ticketlist.get(i).getStarttime(), Ticketlist.get(i).getEndtime()).toMillis();
                String minutes;
                minutes = String.format("%d",
                        TimeUnit.MILLISECONDS.toMinutes(millis));
                Integer intminutes = Integer.parseInt(minutes);
                if (intminutes > 30) {
                    auxticket.setAmount(auxticket.getAmount() + (int) intminutes / 30);
                    auxticket.setStatus(Status.Pending);
                }
                    if(helmet.equals("N")){
                        auxticket.setHashelmet(false);
                        auxticket.setAmount(auxticket.getAmount() + 5);
                        auxticket.setStatus(Status.Pending);
                    }
                    if(condition.equals("N")){
                        auxticket.setGoodcondition(false);
                        auxticket.setAmount(auxticket.getAmount() + 5);
                        auxticket.setStatus(Status.Pending);
                    }

                updateticket(auxticket);
                showticket(auxticket);
            }
        }


    }
    public static void showticket(Ticket ticket){
        System.out.println("Code: " + ticket.getCode() + "\n"
                + "Bicycle: " + ticket.getBicycle() + "\n"
                + "User: " + ticket.getUser() + "\n"
                + "Name: " + ticket.getUser() + "\n"
                + "Date: " + ticket.getDate() + "\n"
                + "Start Time: " + ticket.getStarttime() + "\n"
                + "End Time: " + ticket.getEndtime() + "\n"
                + "Has helmet: " + ticket.getHashelmet() + "\n"
                + "Condition: " + ticket.getGoodcondition() + "\n"
                + "Status: " + ticket.getStatus().name() +"\n"
                + "Amount: " + ticket.getAmount() + "\n");
    }


}
