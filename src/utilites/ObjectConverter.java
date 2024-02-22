package utilites;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.text.SimpleDateFormat;


public class ObjectConverter {


    public static <T > String toJson(T o){

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.setDateFormat(new SimpleDateFormat("dd-MM-yyyy hh:mm"));

        try {
            return om.writeValueAsString(o)  ;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
