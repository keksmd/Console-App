package commands;

import main.*;
import utilites.interfaces.*;

public class Exit extends Command implements methods{
    @Override
    public String toString() {
        return super.toString();
    }

    public Response calling(String[] a){
        Response resp = super.calling(a);
        resp.setFlag(false);
        new Save().calling(a);
        return resp;

    }
    public Command castInto(Command name){
        return (Exit)name;
    }
}
