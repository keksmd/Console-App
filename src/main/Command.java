package main;

import commands.*;
import utilites.interfaces.methods;

import static utilites.CheckingReader.checkyRead;

public class Command implements methods {
    public boolean calling(){
        return true;
    }
    Command cmd;
    public Command getCmd() {
        return cmd;
    }
    public Command commandReader(String str){
        Command cm = new Command();
        String[] words = str.split(" ");
        if(str.startsWith("add")){
            String[] args = str.split(" ");
            if(args.length!=5){
                cm.cmd = new WrongArguments();
            }else if(str.startsWith("add_if_min")){
                    cm.cmd = new AddIfMin(args);
            } else if (str.startsWith("add_if_max")) {
                cm.cmd = new AddIfMax(args);
            }else cm.cmd = new Add(args);

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
                case "update id":
                    cm.cmd = new UpdateById(words[1]);
                    break;
                case "execute_script":
                    cm.cmd = new Exexute((String)checkyRead("s",words[1]));
                    break;
                case "remove_by_id":
                   cm.cmd = new RemoveById(words[1]);
                    break;
                case "filter_greater_than_height":
                    cm.cmd = new FilterHeight((int)(checkyRead("i",words[1])));
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
