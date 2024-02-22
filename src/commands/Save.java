package commands;

import main.App;
import main.Command;
import submarines.SpaceMarine;
import utilites.interfaces.methods;
import java.io.*;

import static utilites.ObjectConverter.toJson;


public class Save extends Command implements methods{
    public boolean calling(){
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(App.fileName));
             BufferedOutputStream time = new BufferedOutputStream(new FileOutputStream(App.dateFileName)) ) {


            for (SpaceMarine spaceMarine : App.collection) {
                String jsonString = toJson(spaceMarine);
                bos.write(jsonString.getBytes());
            }

            time.write(App.lastUpdated.toString().getBytes());
    }catch (IOException e){
            throw new RuntimeException();
        }
        return true;
    }
}