package Main;

import Submarines.SpaceMarine;
import utilites.GetById;

import java.io.*;
import java.net.FileNameMap;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static String fileName = "/home/boo/IdeaProjects/Console App/src/Info";

    public static boolean flag = true;
    public static PriorityQueue<SpaceMarine> que =new PriorityQueue<>();

    public static void main(String[] args) {

        while (flag){
            new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
        }
    }


}