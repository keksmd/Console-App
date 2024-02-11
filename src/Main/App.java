package Main;

import Submarines.SpaceMarine;
import utilites.Box;

import java.io.*;
import java.util.*;

import static utilites.StartingFileJsonReader.readAndUpdate;

public class App {

    public static String fileName = "/home/boo/IdeaProjects/Console App/src/Info";

    public static boolean flag = true;
    public static PriorityQueue<SpaceMarine> que =new PriorityQueue<>();


    public static void main(String[] args) {
        if(new File(fileName).exists()){
            if(new File(fileName).length()>0){
                readAndUpdate(fileName,que);
            }
        }else {
            // создаем файл и записываем путь в fileName
        }
        while (flag){
            new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
        }
    }


}