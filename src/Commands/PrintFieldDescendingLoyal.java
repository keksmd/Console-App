package Commands;

import Main.App;
import Main.Command;
import Submarines.SpaceMarine;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends Command implements methods{
    public boolean calling(){
            App.collection.stream().filter(SpaceMarine::getLoyal).forEach(SpaceMarine::describe);
            App.collection.stream().filter(w-> !w.getLoyal()).forEach(SpaceMarine::describe);
            return  true;

    }
}
