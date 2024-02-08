package utilites;

import Exceptions.IncorrectCommandUsing;

import java.util.Scanner;
import java.util.function.Supplier;



public class CheckingReader {
    static Class clas = null;

    public static Object checkyRead(String type,String uslovie,String comment,String input) {
        System.out.println(comment);
        Scanner sc = new Scanner(input);
        Supplier<?> append = null;
        Supplier<Boolean> check = null;
        Object o = null;
        switch(type.toLowerCase()){
            case"b":
                clas = Boolean.class;
                append = sc::nextBoolean;
                check= sc::hasNextBoolean;
                break;
            case"i":
                clas = Integer.class;
                append = sc::nextInt;
                check = sc::hasNextInt;
                break;
            case"l":
                clas = Long.class;
                append = sc::nextLong;
                check = sc::hasNextLong;
                break;
            case"f":
                clas = Float.class;
                append = sc::nextFloat;
                check = sc::hasNextFloat;
                break;
            case "s":
                clas = String.class;
                append = sc::nextLine;
                check = sc::hasNextLine;
                break;
        }
            if(check == null){
                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
            }
            if(check.get()){
                o = switch (type) {
                    case "b" -> (Boolean) append.get();
                    case "i" -> (Integer) append.get();
                    case "l" -> (Long) append.get();
                    case "f" -> (Float) append.get();
                    case "s" -> (String) append.get();
                    default -> o;
                };
                if(proove(type,uslovie,o)){
                    return o;
                }else return checkyRead(type,uslovie,("Значение не подходит по размеру,еще раз\n"+comment).replace("Вы ошиблись,еще раз\nВы ошиблись,еще раз\n","Вы ошиблись,еще раз\n"));
            }
            return checkyRead(type,uslovie,("Вы ошиблись,еще раз\n"+comment).replace("Вы ошиблись,еще раз\nВы ошиблись,еще раз\n","Вы ошиблись,еще раз\n"));
    }
    private static boolean proove(String type,String usl,Object o){

        String[] words = usl.split(" ");
        boolean right = true;

        switch (type) {

            case "i", "l" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o <= new Scanner(words[2]).nextLong()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o >= new Scanner(words[2]).nextLong()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                    }} else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");}}
            case "f" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o <= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o >= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                    }
                } else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");}}
            case "s" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() <= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                            }
                            break;
                        case "less":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() >= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                    }
                } else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
                }
            }
        }
        return right;
    }

    public static Object checkyRead(String type,String input){
        return  checkyRead(type,"","",input);
    }

    public static Object checkyRead(String type,String comment,String input){
        return  checkyRead(type,"",comment,input);
    }
}
