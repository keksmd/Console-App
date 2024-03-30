package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class Show extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        if(CollectionManager.getCollection().isEmpty()){
            resp.addMessage("В коллекции нет элементов");
        }
        CollectionManager.getCollection().forEach(
                w -> resp.addMessage(w+"\n"));
        return resp;
    }
    private final String name = "show";
}
