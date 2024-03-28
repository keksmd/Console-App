package commands;

import utilites.interfaces.*;
import main.*;

public class Clear extends Command implements methods{
    public Command castInto(Command name){
        return (Clear)name;
    }
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

