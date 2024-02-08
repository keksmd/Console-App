package Main;

import Commands.*;
import utilites.interfaces.methods;

import java.util.Scanner;

public class Command implements methods {
    public void calling(){}
    Command cmd;
    public Command getCmd() {
        return cmd;
    }
    public Command commandReader(String str){
        Command cm = new Command();
        String[] words = str.split(" ");
        if(words.length ==1){
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
                case "remove head":
                    cm.cmd = new RemoveHead();
                    break;
                case "group_counting_by_weapon_type":
                    cm.cmd = new GroupByWeapon();
                    break;
                case "print_field_descending_loyal":
                    cm.cmd = new PrintFieldDescendingLoyal();
                    break;
                case "show":
                    //SHOW
                    break;
                case "info":
                    //INFO
                    break;
                case "save":
                    //SAVING
                    break;
                case "add":
                    cm.cmd =  new Add();
                    break;
                case "add_if_max":
                    cm.cmd = new AddIfMax();
                    break;
                case "add_if_min":
                    cm.cmd = new AddIfMin();
                    break;
                default:
                    cm.cmd = new NotFound();
            }
        } else if (words.length == 2) {
            switch (words[0]){
                case "update id":
                    cm.cmd = new UpdateById(words[1]);
                    break;
                case "execute_script":
                    //file
                    break;
                case "remove_by_id":
                   cm.cmd = new RemoveById(words[1]);
                    break;
                case "filter_greater_than_height":
                    //FILTER
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
