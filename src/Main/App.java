package Main;

import Submarines.SpaceMarine;
import utilites.GetById;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static Map<String,SpaceMarine> idMap = new HashMap<>();
    public static boolean flag = true;
    public static PriorityQueue<SpaceMarine> que =new PriorityQueue<>();

    public static void main(String[] args) {
        while (flag){
            new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
        }
    }
    public static PriorityQueue<SpaceMarine> sort(PriorityQueue<SpaceMarine> a){
        PriorityQueue<SpaceMarine> loc = new PriorityQueue<>();
        a.stream().
                mapToInt(SpaceMarine::getId).
                boxed().
                sorted(Comparator.naturalOrder()).
                collect(Collectors.toCollection(ArrayList<Integer>::new)).
                forEach(w->loc.add(GetById.getById(w)));
        que = loc;
        return que;
    }

}