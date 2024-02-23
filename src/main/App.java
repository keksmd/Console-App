package main;

import com.fasterxml.jackson.core.type.TypeReference;
import submarines.SpaceMarine;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

import static utilites.StartingFileJsonReader.readAndUpdate;

public class App {
    public static LocalDate lastUpdated;


    public static final String fileName = System.getenv("JSON_LIB");
    public static final String dateFileName = "Date.txt";
    public static boolean flag = true;
    public static final PriorityQueue<SpaceMarine> collection =new PriorityQueue<>();
    public static final File dateFile = new File(dateFileName);
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

            if (new File(fileName).exists()) {
                if (new File(fileName).length() > 0) {
                    collection.addAll(readAndUpdate(fileName, new TypeReference<SpaceMarine>() {}));
                }
            } else {
                new File(fileName).createNewFile();
            }
            Scanner sc = new Scanner(System.in);

                while (flag) {
                    while (sc.hasNext()&&flag) {
                        try {
                            new Command().commandReader(sc.nextLine()).getCmd().calling();
                        }catch (NoSuchElementException e){
                            System.err.println("Не надо вводить ctrl+D !!!");
                            System.exit(0);
                        }
                    }

                }

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    }