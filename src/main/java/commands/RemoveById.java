package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class RemoveById extends Command implements methods{

    public Response calling(String[] a){
        Response resp = super.calling(a);
        if(CollectionManager.collection.stream().anyMatch(w->String.valueOf(w.getId()).equals(args[0]))) {
            CollectionManager.collection.removeIf(c -> c.getId() == Integer.parseInt(args[0]));
        }else{
            resp.addMessage("Ошибка, не существует элемента с таким ID");
            resp.setSuccess(false);
        }
        return resp;
    }
    private final String name = "remove_by_id";

}
