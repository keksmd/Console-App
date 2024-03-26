package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class RemoveById extends Command implements methods{

    public Response calling(){
        Response resp = super.calling();
        if(CollectionManager.collection.stream().anyMatch(w->String.valueOf(w.getId()).equals(args[0]))) {
            CollectionManager.collection.removeIf(c -> c.getId() == Integer.parseInt(args[0]));
        }else{
            resp.addMessage("Ошибка, не существует элемента с таким ID");
            resp.setSuccess(false);
        }
        return resp;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
