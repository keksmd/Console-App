package commands;

import main.CollectionManager;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

import java.util.List;

public class UpdateById extends CollectionManager implements methods{
    final String idToUpdate;
    String[] inputs;
    public UpdateById(String[] inputs){
        this.idToUpdate = inputs[0];
        this.inputs = inputs;
    }
    public boolean calling(){
        boolean flag = false;
        for(SpaceMarine c: CollectionManager.collection){
            if(c.getId() == Integer.parseInt(idToUpdate)){
                String[] args = {inputs[1],inputs[2],inputs[3],inputs[4],};
                c.update(args);
                flag = true;
            }
        }

        return flag;
    }
}
