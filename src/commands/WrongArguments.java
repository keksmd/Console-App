package commands;

import main.Command;
import utilites.interfaces.methods;

public class WrongArguments extends Command implements methods{
    public boolean calling(){
        System.out.printf("Wrong number or type of arguments, while creating object, you needed 4 arguments: String name,long health,Boolean loyal,float height and some additional in next lines %n");
        return false;
    }
}
