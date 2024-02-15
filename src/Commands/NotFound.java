package Commands;

import Main.Command;
import utilites.interfaces.methods;

import java.util.Scanner;

public class NotFound extends Command implements methods{
    public boolean calling(){
        System.out.println("Unknown command,try again or use 'help' toget information about aviable commands");
        new Command().commandReader(new Scanner(System.in).nextLine()).getCmd().calling();
        return true;
    }
}
