package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class Info extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        //resp.addMessage("В коллекции : "+CollectionManager.collection.getClass().getName()+", обновленной "+CollectionManager.lastUpdated+",хранится "+CollectionManager.collection.size()+" элементов");
        resp.addMessage(String.format("В коллекции : %s, обновленной %s,хранится %d элементов", CollectionManager.getCollection().getClass().getName(), CollectionManager.lastUpdated, CollectionManager.getCollectionSize()));
        return resp;
    }
    private final String name = "info";

}
