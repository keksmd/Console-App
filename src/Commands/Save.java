package Commands;

import Main.App;
import Main.Command;
import Submarines.SpaceMarine;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilites.interfaces.methods;
import java.io.*;
import java.util.Iterator;


public class Save extends Command implements methods{
    public boolean calling(){
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(App.fileName));
             BufferedOutputStream time = new BufferedOutputStream(new FileOutputStream(App.dateFileName)) ) {
                ObjectMapper objectMapper = new ObjectMapper();

            Iterator<SpaceMarine> iterator = App.collection.iterator();

            while(iterator.hasNext()){
                String jsonString = objectMapper.writeValueAsString(iterator.next());
                bos.write(jsonString.getBytes());
            }

            time.write(App.lastUpdated.toString().getBytes());
    }catch (IOException e){
            throw new RuntimeException();
        }
        return true;
    }
}