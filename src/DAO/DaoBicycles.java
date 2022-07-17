package DAO;

import Domain.bicycle.Bicycle;
import Domain.bicycle.EnumType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DaoBicycles {


    public static ArrayList<Bicycle> readbicycles() {
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<Bicycle> bicyclelist = new ArrayList<Bicycle>();
        Bicycle auxbicycle = new Bicycle();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Data/users.txt"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
                String[] arrOfStr = sCurrentLine.split(";", 2);
                auxbicycle.setCode(arrOfStr[0]);
                if (arrOfStr[1].equals(EnumType.Mountain.toString())){
                    auxbicycle.setType(EnumType.Mountain);
                }
                if (arrOfStr[1].equals(EnumType.Road.toString())){
                    auxbicycle.setType(EnumType.Road);
                }
                auxbicycle.setCode(arrOfStr[2]);
                auxbicycle.setIsavalible(Boolean.parseBoolean(arrOfStr[3]));
                bicyclelist.add(auxbicycle);
            }
            return bicyclelist;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
