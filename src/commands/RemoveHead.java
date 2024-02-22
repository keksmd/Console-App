package commands;

import main.App;
import main.Command;
import utilites.interfaces.methods;

public class RemoveHead extends Command implements methods{
    public boolean calling(){
        App.collection.poll();
        return true;
    }
}
