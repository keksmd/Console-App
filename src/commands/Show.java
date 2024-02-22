package commands;

import main.App;
import main.Command;
import submarines.SpaceMarine;
import utilites.interfaces.methods;

public class Show extends Command implements methods{
    public boolean calling(){
        App.collection.forEach(System.out::println);
        return true;
    }
}
