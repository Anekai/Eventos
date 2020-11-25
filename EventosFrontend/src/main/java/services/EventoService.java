
package services;

import entities.Evento;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EventoService {
    
    public void insert(Evento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosRegistroPresenca");
        
        WebTarget resourceWebTarget = webTarget.path("rest/evento/insert");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        System.out.println("Response: " + response.readEntity(String.class));
    }

    public void update(Evento entity) {
        //dao.update(entity);
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
        return null; //dao.find(entity);
    }
    
}
