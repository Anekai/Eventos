
package views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Evento;
import framework.CalendarDeserializer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MainView {
    
    public static void main(String[] args) {
        
        /*RegistroEventoTempService service = SpringConfig.context.getBean(RegistroEventoTempService.class);

        RegistroEventoTemp entity = new RegistroEventoTemp();

        entity.setId(1);

        service.find(entity);*/
        
        MainView r = new MainView();
        
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/teste");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        r.getResponse(response);
        //System.out.println("Status: " + response.getStatus());
        //System.out.println("Response: " + response.readEntity(String.class));
    }
    
    public void getResponse(Response response) {
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String p = response.readEntity(String.class);
        System.out.println(p);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        List<Evento> e = g.fromJson(p, new TypeToken<ArrayList<Evento>>(){}.getType());
        System.out.println(e);
    }
    
}
