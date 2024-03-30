package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

import java.util.Arrays;

public class UpdateById extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        if(CollectionManager.getCollectionStream().anyMatch(w->w.getId() == Integer.parseInt(args[0]))){
            CollectionManager.getCollectionStream().filter(w->w.getId() == Integer.parseInt(args[0])).findFirst().get().update(Arrays.stream(this.getArgs()).skip(1).toArray(String[]::new));
        }else{
            resp.addMessage("Ошибка, не существует элемента с таким ID");
            resp.setSuccess(false);
        }
        return resp;
    }
    private final String name = "update_by_id";

}
