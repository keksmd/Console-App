package commands;

import main.App;
import main.CollectionManager;
import main.Command;
import main.Response;
import spacemarines.SpaceMarine;
import utilites.interfaces.methods;
import java.io.*;

import static utilites.ObjectConverter.toJson;


public class Save extends Command implements methods{
    public Response calling(){
        Response resp = super.calling();
            CollectionManager.collection.forEach(spaceMarine -> {String jsonString = toJson(spaceMarine)+"\n";
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(App.fileName));){
                    bos.write(jsonString.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        return resp;
    }
}