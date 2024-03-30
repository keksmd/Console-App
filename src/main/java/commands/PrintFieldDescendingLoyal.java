package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        StringBuilder s = new StringBuilder();
            CollectionManager.collection.stream().filter(SpaceMarine::getLoyal).forEach(s::append);
            CollectionManager.collection.stream().filter(w-> !w.getLoyal()).forEach(s::append);
            resp.addMessage(s.toString());
            return resp;

    }
    private final String name = "print_field_descending_loyal";
}
