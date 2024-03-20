package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class Info extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        resp.addMessage(String.format("В коллекции : %s, обновленной %s,хранится %d элементов%n", CollectionManager.collection.getClass().getName(), CollectionManager.lastUpdated, CollectionManager.collection.size()));
        return resp;
    }
}
