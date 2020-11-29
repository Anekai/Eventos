
package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Evento;
import entities.Pessoa;
import framework.CalendarDeserializer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EventoService {
    
    public void insert(Evento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/cadastrarEvento");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }

    public void update(Evento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/atualizarEvento");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.put(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }

    public void delete(Evento entity) {
        //dao.delete(entity);
    }
    
    public Evento findById(Integer id) {
        return null; //dao.findById(id);
    }

    public List<Evento> find() {
        return null; //dao.find(new Evento());
    }
    
    public List<Evento> find(Evento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/buscarEventos");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String r = response.readEntity(String.class);
        System.out.println(r);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        List<Evento> eventos = g.fromJson(r, new TypeToken<ArrayList<Evento>>(){}.getType());
        System.out.println(eventos);
        
        return eventos;
    }
    
}
