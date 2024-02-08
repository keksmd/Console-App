package Main;

import Submarines.SpaceMarine;
import utilites.GetById;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static boolean flag = true;
    public static PriorityQueue<SpaceMarine> que =new PriorityQueue<>();

    public static void main(String[] args) {

        while (flag){
            new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
        }
    }


}