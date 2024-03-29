package utilites;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

import Main.App;
import Submarines.SpaceMarine;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;


public class StartingFileJsonReader {
    public static <T, C extends Collection<T>> void readAndUpdate(String fileName, C collection) {
        try (FileReader fis = new FileReader(fileName);
             BufferedReader bfr = new BufferedReader(fis)){
            String line;
            StringBuilder fileContent = new StringBuilder();
            while ((line = bfr.readLine()) != null) {
                fileContent.append(line);
            }

            convert(fileContent.toString(), collection);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T, C extends Collection<T>> void convert(String json, C collection) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //T data = mapper.readValue(json, new TypeReference<T>() {
        //});
        //collection.add(data);
        //App.collection = mapper.readValue(json, new TypeReference<PriorityQueue<SpaceMarine>>() {
        //});ArrayList<SpaceMarine>();
        App.collection.add(mapper.readValue(json, new TypeReference<SpaceMarine>() {}));

    }
}
