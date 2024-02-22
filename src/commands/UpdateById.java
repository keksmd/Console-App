package commands;

import main.App;
import main.Command;
import submarines.SpaceMarine;
import utilites.interfaces.methods;

import java.time.LocalDate;

public class UpdateById extends Command implements methods{
    final String idToUpdate;
    public UpdateById(String id){
        this.idToUpdate = id;
    }
    public boolean calling(){
        boolean flag = false;
        for(SpaceMarine c: App.collection){
            if(c.getId() == Integer.parseInt(idToUpdate)){
                c.update();
                flag = true;
                App.lastUpdated = LocalDate.now();
            }
        }

        return flag;
    }
}
