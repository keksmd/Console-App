package Commands;

import Main.App;
import Main.Command;
import Submarines.SpaceMarine;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilites.interfaces.methods;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import com.fasterxml.jackson.core.*;



public class Save extends Command implements methods{
    public void calling(){
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(App.fileName))) {
                ObjectMapper objectMapper = new ObjectMapper();

            Iterator<SpaceMarine> iterator = App.que.iterator();

            while(iterator.hasNext()){
                iterator.next();
                String jsonString = objectMapper.writeValueAsString(iterator.next());
                bos.write(jsonString.getBytes());
            }
    }catch (IOException e){
            throw new RuntimeException();
        }

    }
}
