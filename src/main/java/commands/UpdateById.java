package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

import java.util.Arrays;

public class UpdateById extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
        boolean flag = false;
        for(SpaceMarine c: CollectionManager.collection){
            if(c.getId() == Integer.parseInt(args[0])){
                c.update(Arrays.stream(this.getArgs()).skip(1).toArray(String[]::new));
                flag = true;
            }
        }
        resp.setSuccess(flag);
        return resp;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
