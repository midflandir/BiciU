package DAO;

import Domain.bicycle.Bicycle;
import Domain.bicycle.EnumType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DaoBicycles {


    private static List<String> lines;

    public static List<Bicycle> readbicycles() {
        List<String> arr = new ArrayList<String>();
        List<Bicycle> bicyclelist = new ArrayList<Bicycle>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Data/bycicles.txt"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                Bicycle auxbicycle = new Bicycle();
                arr.add(sCurrentLine);
                String[] arrOfStr = sCurrentLine.split(";", 4);
                auxbicycle.setCode(arrOfStr[0]);
                if (arrOfStr[1].equals(EnumType.Mountain.toString())) {
                    auxbicycle.setType(EnumType.Mountain);
                }
                if (arrOfStr[1].equals(EnumType.Road.toString())) {
                    auxbicycle.setType(EnumType.Road);
                }
                auxbicycle.setColor(arrOfStr[2]);
                auxbicycle.setIsavalible(Boolean.parseBoolean(arrOfStr[3]));
                bicyclelist.add(auxbicycle);
            }
            return bicyclelist;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void bicyclenotavalible(Bicycle bicycle) throws IOException {
        File f = new File("src/Data/bycicles.txt");
        lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());
        changetofalse(bicycle); // the name and the value you want to modify
        Files.write(f.toPath(), changetofalse(bicycle), Charset.defaultCharset());
    }

    private static List<String> changetofalse(Bicycle bicycle) {
        List<String> newLines = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains(bicycle.getCode())) {
                String[] vals = line.split(";");
                newLines.add(vals[0] + ";" + vals[1] + ";" + vals[2] + ";" + "false");
            } else {
                newLines.add(line);
            }
        }
        return newLines;
    }

    public static void bicycleisavalible(Bicycle bicycle) throws IOException {
        File f = new File("src/Data/bycicles.txt");
        lines = Files.readAllLines(f.toPath(), Charset.defaultCharset());
        changetotrue(bicycle); // the name and the value you want to modify
        Files.write(f.toPath(), changetotrue(bicycle), Charset.defaultCharset());
    }

    private static List<String> changetotrue(Bicycle bicycle) {
        List<String> newLines = new ArrayList<String>();
        for (String line : lines) {
            if (line.contains(bicycle.getCode())) {
                String[] vals = line.split(";");
                newLines.add(vals[0] + ";" + vals[1] + ";" + vals[2] + ";" + "true");
            } else {
                newLines.add(line);
            }

        }
        return newLines;
    }

}
