package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

public class FilterHeight extends CollectionManager implements methods{
    final int limit;
    public FilterHeight(int l){
        this.limit = l;
    }
    public boolean calling(){
        CollectionManager.collection.stream().filter(w->w.getHeight()>limit).forEach(System.out::println);
        return true;
    }
}
