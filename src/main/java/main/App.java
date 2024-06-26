
package main;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static utilites.ObjectConverter.readAndUpdate;

public class App {
    public static final Logger log = LogManager.getLogger();

    private App(){
    }

    public static final String fileName = System.getenv("JSON_LIB");
    public static void main(String[] args) {


        try {

            File f  = new File(fileName);
            if (f.exists()) {
                CollectionManager.lastUpdated = new Date(f.lastModified());
                if (f.length() > 0) {
                    CollectionManager.getCollection().addAll(readAndUpdate(fileName, new TypeReference<>() {
                    }));
                }
            } else {
                new File(fileName).createNewFile();
            }
            CollectionManager.setCollection(CollectionManager.getCollection().stream().sorted().collect(Collectors.toCollection(PriorityQueue::new)));
            Server server = new Server(8081);

            server.run();
        }catch (IOException  e){
            log.error("",e);
        }

    }
    private static void check(Selector s){
        log.info("keys");
        s.keys().stream().forEach(w-> log.info(w.toString()));
        log.info("SelectredKeys");
        s.selectedKeys().stream().forEach(w-> log.info(w.toString()));

    }


    }