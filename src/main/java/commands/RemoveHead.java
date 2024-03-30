package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class RemoveHead extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        CollectionManager.collection.poll();
        return resp;
    }

    private final String name = "remove_head";
}
