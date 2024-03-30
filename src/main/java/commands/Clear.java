package commands;

import utilites.interfaces.*;
import main.*;

public class Clear extends Command implements methods{

    private final String name = "clear";
    public Response calling(String[] a){
        Response resp = super.calling(a);
        CollectionManager.collection.clear();
        return resp;
    }
}

