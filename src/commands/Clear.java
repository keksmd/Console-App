package commands;

import utilites.interfaces.*;
import main.*;

import java.time.LocalDate;

public class Clear extends Command implements methods{
    public boolean calling(){
        App.collection.clear();
        App.lastUpdated = LocalDate.now();
        return true;
    }
}
