package commands;

import utilites.interfaces.*;
import main.*;

public class Clear extends Command implements methods{

    private String name = "clear";
    public Response calling(String[] a){
        Response resp = super.calling(a);
        CollectionManager.collection.clear();
        return resp;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

