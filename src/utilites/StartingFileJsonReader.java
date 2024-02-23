package utilites;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import submarines.SpaceMarine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class StartingFileJsonReader {
    public static <T> ArrayList<T> readAndUpdate(String fileName,TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy hh:mm"));
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ArrayList<T> data = new ArrayList<>();
               try (FileReader fis = new FileReader(fileName);
             BufferedReader bfr = new BufferedReader(fis)){
            String line;
            while ((line = bfr.readLine()) != null) {
                data.add(mapper.readerFor(typeReference).readValue(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
               return data;

    }

}
