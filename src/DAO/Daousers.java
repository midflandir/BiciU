package DAO;

import Domain.Users.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Daousers {

    public static ArrayList<user> readusers() {
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<user> Userlist = new ArrayList<user>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Data/users.txt"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                user auxuser = new user();
                arr.add(sCurrentLine);
                String[] arrOfStr = sCurrentLine.split(";", 4);
                auxuser.setID(arrOfStr[0]);
                auxuser.setName(arrOfStr[1]);
                auxuser.setAge(Integer.parseInt((arrOfStr[2])));
                auxuser.setTicketdebts(Double.parseDouble((arrOfStr[3])));
                Userlist.add(auxuser);
            }
            return Userlist;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
