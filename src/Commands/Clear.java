package Commands;

import utilites.interfaces.*;
import Main.*;

import java.time.LocalDate;

public class Clear extends Command implements methods{
    public boolean calling(){
        App.collection.clear();
        App.lastUpdated = LocalDate.now();
        return true;
    }
}
