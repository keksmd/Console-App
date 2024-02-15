package Commands;

import Main.App;
import Main.Command;
import utilites.interfaces.methods;

import java.time.LocalDate;

public class RemoveById extends Command implements methods{
    final String idToRemove;
    public RemoveById(String id){
        this.idToRemove = id;
    }
    public boolean calling(){
        if(App.collection.stream().anyMatch(w->String.valueOf(w.getId()).equals(idToRemove))) {
            App.collection.removeIf(c -> c.getId() == Integer.parseInt(idToRemove));

            App.lastUpdated = LocalDate.now();
            return true;
        }else{
            System.out.println("Ошибка, не существует элемента с таким ID");
            return false;
        }
    }

}
