package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class FilterHeight extends Command implements methods{
    @Override
    public String toString() {
        return super.toString();
    }
    public Response calling(String[] a){
        Response resp = super.calling(a);
        StringBuilder s = new StringBuilder();
        CollectionManager.collection.stream().filter(w->w.getHeight()>Integer.parseInt(args[0])).forEach(s::append);
        resp.addMessage(s.toString());
        return resp;
    }
    public Command castInto(Command name){
        return (FilterHeight)name;
    }
}
