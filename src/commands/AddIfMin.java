package commands;

import main.App;
import main.Command;
import utilites.interfaces.methods;

import java.util.Comparator;

public class AddIfMin extends Command implements methods{
    final String[] args;
    public AddIfMin(String[] args){
            this.args = args;
    }
    public boolean calling() {
        if(args[0].compareTo(App.collection.stream().min(Comparator.naturalOrder()).get().getName())<0) {
            new Add(args).calling();
            return true;
        }else return  false;
    }
}
