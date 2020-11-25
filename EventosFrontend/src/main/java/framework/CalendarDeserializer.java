
package framework;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDeserializer implements JsonDeserializer<Date> {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        String dateAsString = je.getAsString();

        try {
            return formatter.parse(dateAsString);
        } catch (ParseException e) {
            System.out.println(e);
            return null;
        }
    }
}