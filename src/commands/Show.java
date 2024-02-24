package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

public class Show extends CollectionManager implements methods{
    public boolean calling(){
        if(CollectionManager.collection.isEmpty()){
            System.out.println("В коллекции нет элементов");
        }
        CollectionManager.collection.forEach(
                w -> System.out.println(w+"\n"));
        return true;
    }
}
