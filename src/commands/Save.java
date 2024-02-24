package commands;

import main.App;
import main.CollectionManager;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;
import java.io.*;

import static utilites.ObjectConverter.toJson;


public class Save extends CollectionManager implements methods{
    public boolean calling(){
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(App.fileName));) {
            for (SpaceMarine spaceMarine : CollectionManager.collection) {
                String jsonString = toJson(spaceMarine);
                bos.write(jsonString.getBytes());
            }
    }catch (IOException e){
            throw new RuntimeException();
        }
        return true;
    }
}