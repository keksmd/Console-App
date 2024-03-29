package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class Show extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        if(CollectionManager.collection.isEmpty()){
            resp.addMessage("В коллекции нет элементов");
        }
        CollectionManager.collection.forEach(
                w -> resp.addMessage(w+"\n"));
        return resp;
    }
    private String name = "show";
    public Command castInto(Command name){
        return (Show)name;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
