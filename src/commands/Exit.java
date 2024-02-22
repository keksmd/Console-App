package commands;

import main.*;
import utilites.interfaces.*;

public class Exit extends Command implements methods{
    public boolean calling(){
        App.flag = false;
        return true;

    }
}
