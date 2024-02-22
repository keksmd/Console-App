package commands;

import main.App;
import main.Command;
import submarines.SpaceMarine;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends Command implements methods{
    public boolean calling(){
            App.collection.stream().filter(SpaceMarine::getLoyal).forEach(System.out::println);
            App.collection.stream().filter(w-> !w.getLoyal()).forEach(System.out::println);
            return  true;

    }
}
