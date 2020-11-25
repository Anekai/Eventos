
package views;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Evento;
import entities.Pessoa;
import framework.CalendarDeserializer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
        
        r.getTest();
        //r.postTest();
    }
    
    public void getTest() {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/login/loginUsuario/alexandre.klabunde@universo.univates.br/teste123");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        String p = response.readEntity(String.class);
        System.out.println(p);
        
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new CalendarDeserializer());
        Gson g = gsonBuilder.create();
        
        //List<Pessoa> e = g.fromJson(p, new TypeToken<ArrayList<Pessoa>>(){}.getType());
        
        Pessoa e = g.fromJson(p, Pessoa.class);
        
        if ( e != null ) {
            System.out.println(e.getId());
            System.out.println(e.getNome());
            System.out.println(e.getCpf());
            System.out.println(e.getEmail());
            System.out.println(e.getDataNascimento());
        } else {
            System.out.println("Usuário não encontrado");
        }
        
    }
    
    public void postTest() {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        Date data = null;
        try {
            data = new SimpleDateFormat("dd/MM/yyyy").parse("05/08/1999");
        } catch (ParseException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Pessoa obj = new Pessoa(null, "Pedro", "03074062036", "pedro.assis@universo.univates.br", data, "teste123");
        
        WebTarget resourceWebTarget = webTarget.path("rest/cadastro/cadastrarUsuario");
        Invocation.Builder invocationBuilder = resourceWebTarget.request();
        Response response = invocationBuilder.post(Entity.entity(obj, MediaType.APPLICATION_JSON_TYPE));
        
        System.out.println("-- Response --");
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
    }
    
}
