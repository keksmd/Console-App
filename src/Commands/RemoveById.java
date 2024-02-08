package Commands;

import Main.App;
import Main.Command;
import utilites.interfaces.methods;

public class RemoveById extends Command implements methods{
    String idToRemove;
    public RemoveById(String id){
        this.idToRemove = id;
    }
    public void calling(){
        if(App.que.stream().anyMatch(w->String.valueOf(w.getId()).equals(idToRemove))) {
            App.que.removeIf(c -> c.getId() == Integer.valueOf(idToRemove));
        }else{
            System.out.println("Ошибка, не существует элеента с таким ID");
        }
    }

}
