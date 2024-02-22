package utilites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Time {
    DateTimeFormatter dtf = new DateTimeFormatterBuilder().toFormatter();
    private String StrMeaning;
    public Time(LocalDateTime t){
        this.StrMeaning = t.format(dtf);
    }

    public String getStrMeaning() {
        return StrMeaning;
    }
    public LocalDateTime getTimeMeaning() {
        return LocalDateTime.parse(StrMeaning,dtf);
    }
}
