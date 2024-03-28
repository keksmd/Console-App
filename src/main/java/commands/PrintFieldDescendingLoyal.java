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
    @Override
    public String toString() {
        return super.toString();
    }
    public Command castInto(Command name){
        return (PrintFieldDescendingLoyal)name;
    }
}
