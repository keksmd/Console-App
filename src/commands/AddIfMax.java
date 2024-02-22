package commands;

import main.App;
import main.Command;
import utilites.interfaces.methods;

import java.util.Comparator;

public class AddIfMax extends Command implements methods{
    final String[] args;
    public AddIfMax(String[] args){
        this.args = args;
    }
    public boolean calling() {
        if(args[0].compareTo(App.collection.stream().max(Comparator.naturalOrder()).get().getName())>0)
            new Add(args).calling();
        else{
            return false;
        }
        return true;
    }
}
