package commands;

import main.App;
import main.CollectionManager;
import utilites.interfaces.methods;

public class Info extends CollectionManager implements methods{
    public boolean calling(){
        System.out.printf("В коллекции : %s, обновленной %s,хранится %d элементов%n", CollectionManager.collection.getClass().getName(),App.lastUpdated, CollectionManager.collection.size());
        return true;
    }
}
