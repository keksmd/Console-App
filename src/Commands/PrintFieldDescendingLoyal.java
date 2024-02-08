package Commands;

import Main.App;
import Main.Command;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends Command implements methods{
    public void calling(){
            App.que.stream().filter(w-> w.getLoyal()).forEach(w -> w.toString());
            App.que.stream().filter(w-> !w.getLoyal()).forEach(Object::toString);
    }
}
