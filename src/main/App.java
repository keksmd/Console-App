package main;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static utilites.StartingFileJsonReader.readAndUpdate;

public class App {
    public static Date lastUpdated;
    public static final String fileName = System.getenv("JSON_LIB");
    public static boolean flag = true;
    private App(){
    }

    public static void main(String[] args) {
        try {
            File f  = new File(fileName);
            if (f.exists()) {
                lastUpdated = new Date(f.lastModified());
                if (f.length() > 0) {

                    CollectionManager.collection.addAll(readAndUpdate(fileName, new TypeReference<>() {
                    }));
                }
            } else {
                new File(fileName).createNewFile();
            }
            Scanner sc = new Scanner(System.in);

                while (flag) {
                    CollectionManager.getWasExecuted().clear();
                    try {
                        new CollectionManager().commandReader(sc.nextLine()).getCmd().calling();
                    }catch (NoSuchElementException e){
                        System.err.println("Не надо вводить ctrl+D !!!");
                        System.exit(0);
                    }
                }

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    }