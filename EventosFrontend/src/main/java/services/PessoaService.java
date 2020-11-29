
package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Evento;
import entities.Pessoa;
import framework.CalendarDeserializer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PessoaService {
    
    public void insert(Pessoa entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/cadastrarUsuario");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }

    public void update(Pessoa entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/atualizarUsuario");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.put(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("Response: " + response.readEntity(String.class));
    }

    public void delete(Pessoa entity) {
        //dao.delete(entity);
    }
    
    public Pessoa findById(Integer id) {
        return null; //dao.findById(id);
    }

    public List<Pessoa> find() {
        return null; //dao.find(new Pessoa());
    }
    
    public List<Pessoa> find(Pessoa entity) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/buscarUsuarios");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String r = response.readEntity(String.class);
        System.out.println(r);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        List<Pessoa> usuarios = g.fromJson(r, new TypeToken<ArrayList<Pessoa>>(){}.getType());
        System.out.println(usuarios);
        
        return usuarios;
    }
    
    public Pessoa loginUsuario( String login, String senha ) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/login/loginUsuario/" + login + "/" + senha);
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        String r = response.readEntity(String.class);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        System.out.println(r);
        Pessoa p = g.fromJson(r, Pessoa.class);
        System.out.println(p);
        
        return p;
    }
    
}
