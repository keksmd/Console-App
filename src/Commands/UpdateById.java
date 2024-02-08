package Commands;

import Main.App;
import Main.Command;
import Submarines.SpaceMarine;
import utilites.interfaces.methods;

public class UpdateById extends Command implements methods{
    String idToUpdate;
    public UpdateById(String id){
        this.idToUpdate = id;
    }
    public void calling(){
        for(SpaceMarine c: App.que){
            if(c.getId() == Integer.valueOf(idToUpdate)){
                c.update();
            }
        }
    }
}
