package commands;

import utilites.interfaces.*;
import main.*;

public class Clear extends CollectionManager implements methods{
    public boolean calling(){
        CollectionManager.collection.clear();
        return true;
    }
}
