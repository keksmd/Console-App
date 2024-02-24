package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

public class RemoveHead extends CollectionManager implements methods{
    public boolean calling(){
        CollectionManager.collection.poll();
        return true;
    }
}
