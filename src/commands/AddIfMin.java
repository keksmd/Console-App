package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AddIfMin extends CollectionManager implements methods{
    final String[] args;
    public AddIfMin(String[]  args){
            this.args = args;
    }
    public boolean calling() {
        if(args[0].compareTo(CollectionManager.collection.stream().min(Comparator.naturalOrder()).get().getName())<0) {
            new Add(args).calling();
            return true;
        }else return  false;
    }
}
