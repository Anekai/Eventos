
package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Evento;
import entities.RegistroEvento;
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

public class RegistroEventoService {
    
    public void inscricaoCompleta(RegistroEvento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosInscricaoCompletaRapida-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosInscricaoCompletaRapida");
        
        WebTarget resourceWebTarget = webTarget.path("rest/inscricaoCompleta/inscricaoCompleta");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }

    public void update(RegistroEvento entity) {
        //dao.update(entity);
    }

    public void delete(RegistroEvento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosConsultaCancelamentoInscricao-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosConsultaCancelamentoInscricao");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cancelamentoInscricao/cancelarInscricao/" + entity.getEvento().getId() + "/" + entity.getUsuario().getId());
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.delete();
        
        System.out.println("Response: " + response.readEntity(String.class));
    }
    
    public RegistroEvento findById(Integer id) {
        return null; //dao.findById(id);
    }

    public List<RegistroEvento> find() {
        return find(new RegistroEvento());
    }
    
    public List<RegistroEvento> find(RegistroEvento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosConsultaCancelamentoInscricao-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosConsultaCancelamentoInscricao");
        
        WebTarget resourceWebTarget = webTarget.path("rest/consultaInscricao/consultarInscricoes");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String r = response.readEntity(String.class);
        System.out.println(r);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        List<RegistroEvento> inscricoes = g.fromJson(r, new TypeToken<ArrayList<RegistroEvento>>(){}.getType());
        System.out.println(inscricoes);
        
        return inscricoes;
    }
    
    public boolean registrarPresenca(RegistroEvento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosRegistroPresenca-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosRegistroPresenca");
        
        WebTarget resourceWebTarget = webTarget.path("rest/registroPresenca/confirmarPresenca");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.put(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
        
        return true;
    }
    
    public boolean inscricaoRapida(RegistroEvento entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosInscricaoCompletaRapida-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosInscricaoCompletaRapida");
        
        WebTarget resourceWebTarget = webTarget.path("rest/inscricaoRapida/inscricaoRapida");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
        
        return true;
    }
    
    public RegistroEvento findByCodigo(String codigo) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosEmissaoValidacaoCertificado-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosEmissaoValidacaoCertificado");
        
        WebTarget resourceWebTarget = webTarget.path("rest/evento/codigoValidacao/" + codigo);
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        String r = response.readEntity(String.class);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        System.out.println(r);
        RegistroEvento re = g.fromJson(r, RegistroEvento.class);
        System.out.println(re);
        
        return re;
    }
    
}
