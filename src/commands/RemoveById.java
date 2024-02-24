package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

public class RemoveById extends CollectionManager implements methods{
    final String idToRemove;
    public RemoveById(String id){
        this.idToRemove = id;
    }
    public boolean calling(){
        if(CollectionManager.collection.stream().anyMatch(w->String.valueOf(w.getId()).equals(idToRemove))) {
            CollectionManager.collection.removeIf(c -> c.getId() == Integer.parseInt(idToRemove));
            return true;
        }else{
            System.out.println("Ошибка, не существует элемента с таким ID");
            return false;
        }
    }

}
