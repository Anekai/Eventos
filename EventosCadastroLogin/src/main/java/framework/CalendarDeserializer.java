
package framework;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDeserializer extends JsonDeserializer<Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateAsString = jsonParser.getText();

        try {
            return formatter.parse(dateAsString);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}