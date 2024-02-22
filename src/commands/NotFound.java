package commands;

import main.Command;
import utilites.interfaces.methods;

public class NotFound extends Command implements methods{
    public boolean calling(){
        System.out.println("Unknown command,try again or use 'help' toget information about aviable commands");
        return true;
    }
}
