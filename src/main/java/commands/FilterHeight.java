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
    public Response calling(){
        Response resp = super.calling();
        CollectionManager.collection.stream().filter(w->w.getHeight()>Integer.parseInt(args[0])).forEach(System.out::println);
        return resp;
    }
}
