package Commands;

import Main.App;
import Main.Command;
import Submarines.SpaceMarine;
import utilites.interfaces.methods;

public class FilterHeight extends Command implements methods{
    final int limit;
    public FilterHeight(int l){
        this.limit = l;
    }
    public boolean calling(){
        App.collection.stream().filter(w->w.getHeight()>limit).forEach(SpaceMarine::describe);
        return true;
    }
}
