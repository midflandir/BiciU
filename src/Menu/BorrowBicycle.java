package Menu;
import Domain.Users.user;
import Domain.bicycle.Bicycle;
import Domain.bicycle.EnumType;


import java.util.ArrayList;
import java.util.Scanner;

import static DAO.DaoBicycles.readbicycles;
import static DAO.Daousers.readusers;

public class BorrowBicycle {
    private static Registeruser reguser = new Registeruser();
    private static Scanner in = new Scanner(System.in);
    public static void start(){
        String ID;
        Boolean hasdebt = false;
        System.out.println("Please enter your ID");
        ID = in.nextLine();

        ArrayList<user> Userlist = new ArrayList<user>();
        Userlist = readusers();

        for (int i = 0; i < Userlist.size(); i++) {

            if ( Userlist.get(i).getTicketdebts() > 0){
                System.out.println("The user" + ID + "has a ticket with debt Please cancel it and try again");
                hasdebt = true;
            }
        }
        if (hasdebt == false){
            borrow(ID);
        }
    }

    public static void borrow(String ID){
        String type;
        ArrayList<Bicycle> bicyclelist = new ArrayList<Bicycle>();
        boolean thereisabicycle = false;
        System.out.println("Please Choose a bycicle type Mountain (M) - Road (R): ");
        type = in.nextLine();
        if (type.equals("M") || type.equals("R")) {
            bicyclelist = readbicycles();
            findavalible(type, ID, bicyclelist);

        }
    }

    public static void findavalible(String type, String ID, ArrayList<Bicycle> bicyclelist){

        boolean thereisabicycle = false;
            for (int i = 0; i < bicyclelist.size(); i++) {

                if (type.equals("M")
                        && bicyclelist.get(i).getType().equals(EnumType.Mountain)
                        && bicyclelist.get(i).isIsavalible() == true) {
                    thereisabicycle = true;
                    i = bicyclelist.size();
                }
                if (type.equals("R")
                        && bicyclelist.get(i).getType().equals(EnumType.Road)
                        && bicyclelist.get(i).isIsavalible() == true) {
                    thereisabicycle = true;
                    i = bicyclelist.size();
                }
            }
            if (thereisabicycle == false && type.equals("M")) {
                System.out.println("There is no Mountain Bicycle available. Choose another one");
            }
            if (thereisabicycle == false && type.equals("R")) {
                System.out.println("There is no Road Bicycle available. Choose another one");
            }

    }





    private static ArrayList<String> changeValueOf(String username, int newVal){
        ArrayList<String> newLines = new ArrayList<String>();
        for(String line: ){
            if(line.contains(username)){
                String [] vals = line.split(": ");
                newLines.add(vals[0]+": "+String.valueOf(newVal));
            }else{
                newLines.add(line);
            }

        }
        return newLines;
    }






}
