package Commands;

import Main.*;
import utilites.interfaces.*;

public class Exit extends Command implements methods{
    public void calling(){
        App.flag = false;

    }
}
