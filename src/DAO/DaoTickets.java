package DAO;

import Domain.Ticket.Status;
import Domain.Ticket.Ticket;
import Domain.Users.user;
import Domain.bicycle.Bicycle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoTickets {
    private static List<String> lines;
    public static void Ticketgenerator(String userID, String username, Bicycle bicycle, Integer ticketnumber) {

String ticketformat="T-";

        if (ticketnumber <= 9){
            ticketformat= "T-00";
        } else if (ticketnumber <= 99){
            ticketformat= "T-0";
        } else if (ticketnumber <= 999){
            ticketformat= "T-";
        }
        try {
            FileWriter myWriter = new FileWriter("src/Data/tickets.txt", true);
            myWriter.append(ticketformat + ticketnumber + ";"
                    + bicycle.getCode() + ";"
                    + userID + ";"
                    + LocalDate.now() + ";"
                    + LocalTime.now() + ";"
                    + "-" + ";"
                    + "true" + ";"
                    + "true" + ";"
                    + Status.Active.name() +";"
                    + "0 \n"); // default Debt in 0s
            myWriter.close();
            System.out.println("Code: " + ticketformat + ticketnumber + "\n"
                    + "Bicycle: " + bicycle.getCode() + "\n"
                    + "User: " + userID + "\n"
                    + "Name: " + username + "\n"
                    + "Date: " + LocalDate.now() + "\n"
                    + "Start Time: " + LocalTime.now() + "\n"
                    + "End Time: " + "-" + "\n"
                    + "Has helmet: " + "true" + "\n"
                    + "Condition: " + "true" + "\n"
                    + "Status: " + Status.Active.name() +"\n"
                    + "Amount: " + "0 \n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<Ticket> readtickets() {
        ArrayList<String> arr = new ArrayList<String>();
        List<Ticket> Ticketlist = new ArrayList<Ticket>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Data/tickets.txt"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                Ticket auxticket = new Ticket();
                arr.add(sCurrentLine);
                String[] arrOfStr = sCurrentLine.split(";");
                auxticket.setCode(arrOfStr[0]);
                auxticket.setBicycle(arrOfStr[1]);
                auxticket.setUser(arrOfStr[2]);
                auxticket.setDate(LocalDate.parse(arrOfStr[3]));
                auxticket.setStarttime(LocalTime.parse(arrOfStr[4]));
                if(arrOfStr[5].equals("-")){
                    auxticket.setEndtime(LocalTime.parse(arrOfStr[4]));
                }
                auxticket.setHashelmet(Boolean.parseBoolean(arrOfStr[6]));
                auxticket.setGoodcondition(Boolean.parseBoolean(arrOfStr[7]));
                if (arrOfStr[8].equals(Status.Active.name())){
                    auxticket.setStatus(Status.Active);
                } else if (arrOfStr[8].equals(Status.OK.name())) {
                    auxticket.setStatus(Status.OK);
                } else if (arrOfStr[8].equals(Status.Pending.name())) {
                    auxticket.setStatus(Status.Pending);
                }
                auxticket.setAmount(Double.parseDouble(arrOfStr[9]));
                Ticketlist.add(auxticket);
            }
            return Ticketlist;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }




    public static void updateticket(Ticket ticket) throws IOException {
        File f = new File("src/Data/tickets.txt");
        lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());
        changeticket(ticket); // the name and the value you want to modify
        Files.write(f.toPath(), changeticket(ticket), Charset.defaultCharset());
    }

    private static List<String> changeticket(Ticket ticket) {
        List<String> newLines = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains(ticket.getCode())) {
                String[] vals = line.split(";");
                newLines.add(vals[0] + ";" + vals[1] + ";" + vals[2]
                        + ";" + vals[3] + ";" + vals[4] + ";" + ticket.getEndtime() + ";"
                        + ticket.getHashelmet() + ";" + ticket.getGoodcondition()
                        + ";" + ticket.getStatus().name() + ";"+ ticket.getAmount());
            } else {
                newLines.add(line);
            }

        }
        return newLines;
    }






}
