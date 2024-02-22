package utilites;

import exceptions.IncorrectCommandUsing;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;



public class CheckingReader {


    public static Object checkyRead(String type,String uslovie,String comment,String input) {
        if (!comment.isEmpty()) {
            System.out.println(comment);
        }
        Scanner sc;
        if (input.equals("sin")) {
            sc = new Scanner(System.in);
        } else {
            sc = new Scanner(input);
        }
        Supplier<?> append = null;
        Supplier<Boolean> check = null;
        Object o = null;
        check = switch (type.toLowerCase()) {
            case "b" -> {
                append = sc::nextBoolean;
                yield sc::hasNextBoolean;
            }
            case "i" -> {
                append = sc::nextInt;
                yield sc::hasNextInt;
            }
            case "l" -> {
                append = sc::nextLong;
                yield sc::hasNextLong;
            }
            case "f" -> {
                System.out.println("2");
                append = sc::nextFloat;
                yield sc::hasNextFloat;
            }
            case "s" -> {
                append = sc::nextLine;
                yield sc::hasNextLine;
            }
            default -> check;
        };
        if (check == null) {
            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead");
        }
        if (check.get()) {
            o = switch (type) {
                case "b" -> (Boolean) append.get();
                case "i" -> (Integer) append.get();
                case "l" -> (Long) append.get();
                case "f" -> (Float) append.get();
                case "s" -> (String) append.get();
                default -> o;
            };
            if (!uslovie.isEmpty()){
                if (proove(type, uslovie, o)) {
                    return o;
                } else {

                    return checkyRead(type, uslovie, ("Значение не подходит по условию,еще раз\n" + comment).replace("Значение не подходит по условию,еще раз\nЗначение не подходит по условию,еще раз\n", "Значение не подходит по условию    ,еще раз\n"), input);
                }
            }else{
                return o;
            }
    }
        return checkyRead(type,uslovie,("Вы ошиблись,еще раз\n"+comment).replace("Вы ошиблись,еще раз\nВы ошиблись,еще раз\n","Вы ошиблись,еще раз\n"),"sin");
    }
    private static boolean proove(String type,String usl,Object o){

        String[] words = usl.split(" ");
        boolean right = true;
        if(usl.isEmpty()) return true;

        switch (type) {
            case "i", "l" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o <= new Scanner(words[2]).nextLong()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead1");
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o >= new Scanner(words[2]).nextLong()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead2");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead2");
                    }} else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead3");}
                }
            case "f" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o <= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead4");
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o >= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead5");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead6");
                    }
                } else {
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead7");}
            }
            case "s" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() <= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead8");
                            }
                            break;
                        case "less":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() >= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead9");
                            }
                            break;
                        default:
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead10");
                    }
                } else if(words.length == 2){
                    switch (words[0]){
                    case "is":
                        if(Objects.equals(words[1], "weapon")){
                            if(!o.equals("BOLT_PISTOL") && !o.equals("INFERNO_PISTOL")&& !o.equals("MULTI_MELTA") && !o.equals("COMBI_PLASMA_GUN") && !o.equals("GRENADE_LAUNCHER")){
                                right = false;
                            }
                        }else{
                            throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead10");
                        }
                        break;
                    }
                }else{
                    throw new IncorrectCommandUsing("Syntax error in proove \n in checkyRead11");
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
