package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class Show extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        if(CollectionManager.collection.isEmpty()){
            System.out.println("В коллекции нет элементов");
        }
        CollectionManager.collection.forEach(
                w -> System.out.println(w+"\n"));
        return resp;
    }
}
