package commands;

import main.*;
import utilites.interfaces.*;

public class Exit extends CollectionManager implements methods{
    public boolean calling(){
        App.flag = false;
        System.exit(0);
        return true;

    }
}
