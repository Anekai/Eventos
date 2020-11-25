
package services;

import entities.Pessoa;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PessoaService {
    
    public void insert(Pessoa entity) {
        //dao.insert(entity);
    }

    public void update(Pessoa entity) {
        //dao.update(entity);
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
        return null; //dao.find(entity);
    }
    
    public Pessoa loginUsuario( String login, String senha ) {
        Client client = ClientBuilder.newClient();

        //WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosCadastroLogin-1.0");
        WebTarget webTarget = client.target("http://localhost:8080/EventosCadastroLogin");
        
        WebTarget resourceWebTarget = webTarget.path("rest/evento/loginUsuario");
        Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();
        
        response.readEntity(String.class);
        
        return null;
    }
    
}
