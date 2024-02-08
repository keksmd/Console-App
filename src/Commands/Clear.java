package Commands;

import utilites.interfaces.*;
import Main.*;

public class Clear extends Command implements methods{
    public void calling(){
        App.que.clear();
    }
}
