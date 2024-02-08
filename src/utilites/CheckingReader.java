package utilites;

import Exceptions.IncorrectCommandInput;

import java.util.Scanner;
import java.util.function.Supplier;



public class CheckingReader {
    static Class clas = null;

    public static Object checkyRead(String type,String uslovie,String comment) {
        System.out.println(comment);
        Scanner sc = new Scanner(System.in);
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
            if(check.get()){
                switch (type){
                    case "b":
                        o = (Boolean)append.get();
                        break;
                    case "i":
                        o = (Integer)append.get();
                        break;
                    case "l":
                        o = (Long)append.get();
                        break;
                    case "f":
                        o = (Float)append.get();
                        break;
                    case "s":
                        o = (String)append.get();
                        break;
                    default:
                        System.out.println("Type must be i(int)/l(long)/f(float)/s(string)/b(boolean)");///// перепис
                        break;
                }
                if(proove(type,uslovie,o)){
                    return o;
                }
                return checkyRead(type,uslovie,("Значение не подходит по размеру,еще раз\n"+comment).replace("Вы ошиблись,еще раз\nВы ошиблись,еще раз\n","Вы ошиблись,еще раз\n"));
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
                                System.out.println("Unchecked eror reader is bad");///// переписать
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextInt() || new Scanner(words[2]).hasNextLong())) {
                                if ((Long) o >= new Scanner(words[2]).nextLong()) {
                                    right = false;}
                            } else {
                                System.out.println("Unchecked eror reader is bad");///// переписать
                            }
                            break;
                        default:
                            System.out.println("Unchecked eror reader is bad");///// переписать
                    }} else {
                    System.out.println("Unknown command, try again");}}
            case "f" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o <= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                System.out.println("Unchecked eror reader is bad");///// переписать
                            }
                            break;
                        case "less":
                            if (words[1].equals("than") && (new Scanner(words[2]).hasNextFloat())) {
                                if ((Float) o >= new Scanner(words[2]).nextFloat()) {
                                    right = false;}
                            } else {
                                System.out.println("Unchecked eror reader is bad");///// переписать
                            }
                            break;
                        default:
                            System.out.println("Unchecked eror reader is bad");///// переписать
                    }
                } else {
                    System.out.println("Unknown command, try again");}}
            case "s" -> {
                if (words.length == 3) {
                    switch (words[0]) {
                        case "more":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() <= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                System.out.println("Unchecked eror reader is bad");///// переписать
                            }
                            break;
                        case "less":
                            if (words[1].equals("length") && (new Scanner(words[2]).hasNextInt())) {
                                if (((String) o).length() >= new Scanner(words[2]).nextInt()) {
                                    right = false;
                                }
                            } else {
                                System.out.println("Unchecked eror reader is bad");///// переписать
                            }
                            break;
                        default:
                            System.out.println("Unchecked eror reader is bad");///// переписать
                    }
                } else {
                    System.out.println("Unknown command, try again");
                }
            }
        }
        return right;
    }

    public static Object checkyRead(String type){
        return  checkyRead(type,"","");
    }

    public static Object checkyRead(String type,String comment){
        return  checkyRead(type,"",comment);
    }
}
