package Main;

import Submarines.SpaceMarine;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

import static utilites.StartingFileJsonReader.readAndUpdate;

public class App {
    public static LocalDate lastUpdated;


    public static final String fileName = System.getenv("JSON_LIB");
    public static final String dateFileName = "Date.txt";
    public static boolean flag = true;
    public static final PriorityQueue<SpaceMarine> collection =new PriorityQueue<>();
    public static File dateFile = new File(dateFileName);
    public static void main(String[] args) {
        try {
            File dataFile = new File(dateFileName);
            if (dataFile.exists()) {
                if (new Scanner(dateFile).hasNextLine()) {
                    String line = new Scanner(dataFile).nextLine();
                    lastUpdated = LocalDate.parse(line.subSequence(0,line.length()));

                }
            } else {
                new File(fileName).createNewFile();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            if (new File(fileName).exists()) {
                if (new File(fileName).length() > 0) {
                    readAndUpdate(fileName, collection);
                    System.out.println("hel");
                }
            } else {
                new File(fileName).createNewFile();
            }
            while (flag) {
                //Scanner sc = new Scanner(System.in);
                //if(sc.hasNextLine()) {
                //    new Command().commandReader(sc.nextLine()).getCmd().calling();
                //}
                new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    }