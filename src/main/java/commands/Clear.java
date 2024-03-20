package commands;

import utilites.interfaces.*;
import main.*;

public class Clear extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        CollectionManager.collection.clear();
        return resp;
    }
}
