package Commands;

import Main.App;
import Main.Command;
import utilites.interfaces.methods;

public class RemoveHead extends Command implements methods{
    public boolean calling(){
        App.collection.poll();
        return true;
    }
}
