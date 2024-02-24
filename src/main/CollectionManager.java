package main;

import commands.*;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

import java.util.*;

public class CollectionManager implements methods {
    public static final PriorityQueue<SpaceMarine> collection =new PriorityQueue<>();
    private static final HashSet<String> wasExecuted = new HashSet<>();
    public static HashSet<String> getWasExecuted(){
        return wasExecuted;
    }
    public boolean calling(){
        return true;
    }
    CollectionManager cmd;
    public CollectionManager getCmd() {
        return cmd;
    }
    public CollectionManager commandReader(String str){
        CollectionManager cm = new CollectionManager();
        String[] words = str.split(" ");
        if(str.startsWith("add")||str.startsWith("update")){
            String[] args = str.split(" ");
            if(args.length!=5){
                if (args.length==6&& Arrays.asList(args).contains("update")){
                    String[] args1 = {args[1],args[2],args[3],args[4],args[5]};
                    cm.cmd = new UpdateById(args1);
                }else {
                    cm.cmd = new WrongArguments();
                }

            }else if(str.startsWith("add_if_min")){
                String[] args1 = {args[1],args[2],args[3],args[4]};
                    cm.cmd = new AddIfMin(args1);
            } else if (str.startsWith("add_if_max")) {
                String[] args1 = {args[1],args[2],args[3],args[4]};
                cm.cmd = new AddIfMax(args1);
            }else {
                String[] args1 = {args[1],args[2],args[3],args[4]};
                cm.cmd = new Add(args1);
            }

        }else if(words.length ==1){
            switch (str){
                case "help":
                    cm.cmd = new Help();
                    break;
                case "clear":
                    cm.cmd = new Clear();
                    break;
                case "exit":
                    cm.cmd = new Exit();
                    break;
                case "remove_head":
                    cm.cmd = new RemoveHead();
                    break;
                case "group_counting_by_weapon_type":
                    cm.cmd = new GroupByWeapon();
                    break;
                case "print_field_descending_loyal":
                    cm.cmd = new PrintFieldDescendingLoyal();
                    break;
                case "show":
                   cm.cmd = new Show();
                    break;
                case "info":
                    cm.cmd = new Info();
                    break;
                case "save":
                    cm.cmd = new Save();
                    break;

                default:
                    cm.cmd = new NotFound();
            }
        } else if (words.length == 2) {
            switch (words[0]){

                case "execute_script":
                    cm.cmd = new Execute(words[1]);
                    break;
                case "remove_by_id":
                   cm.cmd = new RemoveById(words[1]);
                    break;
                case "filter_greater_than_height":
                    cm.cmd = new FilterHeight(Integer.parseInt(words[1]));
                    break;
                default:
                    cm.cmd = new NotFound();
            }
        }else{
             cm.cmd = new NotFound();
        }

        return cm;

    }
}
