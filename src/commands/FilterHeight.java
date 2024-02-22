package commands;

import main.App;
import main.Command;
import submarines.SpaceMarine;
import utilites.interfaces.methods;

public class FilterHeight extends Command implements methods{
    final int limit;
    public FilterHeight(int l){
        this.limit = l;
    }
    public boolean calling(){
        App.collection.stream().filter(w->w.getHeight()>limit).forEach(System.out::println);
        return true;
    }
}
