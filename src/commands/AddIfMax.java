package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddIfMax extends CollectionManager implements methods{
    final String[] args;
    public AddIfMax(String[] args){
        this.args = args;
    }
    public boolean calling() {
        if(args[0].compareTo(CollectionManager.collection.stream().max(Comparator.naturalOrder()).get().getName())>0)
            new Add(args).calling();
        else{
            return false;
        }
        return true;
    }
}
