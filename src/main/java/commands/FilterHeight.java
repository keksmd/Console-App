package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class FilterHeight extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        StringBuilder s = new StringBuilder();
        CollectionManager.collection.stream().filter(w->w.getHeight()>Integer.parseInt(args[0])).forEach(s::append);
        resp.addMessage(s.toString());
        return resp;
    }
    private final String name = "filter_greater_than_height";
}
