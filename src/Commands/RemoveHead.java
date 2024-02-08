package Commands;

import Main.App;
import Main.Command;
import utilites.interfaces.methods;

public class RemoveHead extends Command implements methods{
    public void calling(){
        App.que.poll();
    }
}
