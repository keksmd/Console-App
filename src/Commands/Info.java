package Commands;

import Main.App;
import Main.Command;
import utilites.interfaces.methods;

public class Info extends Command implements methods{
    public boolean calling(){
        System.out.printf("В коллекции : %s, обновленной %s,хранится %d элементов%n", App.collection.getClass().getName(),App.lastUpdated.toString(),App.collection.size());//ДАТА ИНИЦИАЛИЗАЦИИ
        return true;
    }
}
