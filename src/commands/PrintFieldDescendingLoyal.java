package commands;

import main.CollectionManager;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;

public class PrintFieldDescendingLoyal extends CollectionManager implements methods{
    public boolean calling(){
            CollectionManager.collection.stream().filter(SpaceMarine::getLoyal).forEach(System.out::println);
            CollectionManager.collection.stream().filter(w-> !w.getLoyal()).forEach(System.out::println);
            return  true;

    }
}
