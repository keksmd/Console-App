package Commands;

import Main.Command;
import utilites.interfaces.methods;

import java.util.Scanner;

public class WrongArguments extends Command implements methods{
    public boolean calling(){
        System.out.printf("Wrong number or type of arguments, while creating object, you needed 4 arguments: String name,long health,Boolean loyal,float height and some additional in next lines %n");
        new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
        return false;
    }
}
