
package services;

import daos.RegistroEventoTempDAO;
import entities.RegistroEvento;
import entities.RegistroEventoTemp;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RegistroEventoTempService {
    
    RegistroEventoTempDAO dao;

    public RegistroEventoTempService() {
        dao = new RegistroEventoTempDAO();
    }
    
    public boolean registrarPresencaTemp(RegistroEvento entity) {
        return dao.registrarPresenca(entity);
    }
    
    public boolean inscricaoRapidaTemp(RegistroEvento entity) {
        if ( entity.getUsuario().getId() != null ) {
            return dao.inscricaoRapidaWithUser(entity);
        } else {
            return dao.inscricaoRapidaWithoutUser(entity);
        }
    }
    
    public void deleteAll() {
        dao.deleteAll();
    }

    public List<RegistroEventoTemp> find() {
        return dao.find();
    }
    
    public void synchronize() {
        List<RegistroEventoTemp> inscricoesTemp = find();
        
        if ( inscricoesTemp != null && !inscricoesTemp.isEmpty() ) {
            Client client = ClientBuilder.newClient();

            WebTarget webTarget = client.target("http://177.44.248.90:8080/EventosInscricaoCompletaRapida-1.0");
            //WebTarget webTarget = client.target("http://localhost:8080/EventosInscricaoCompletaRapida");
        
            WebTarget resourceWebTarget = webTarget.path("rest/inscricaoSynchronize/synchronize");
            Invocation.Builder invocationBuilder = resourceWebTarget.request();
            Response response = invocationBuilder.post(Entity.entity(inscricoesTemp, MediaType.APPLICATION_JSON_TYPE));
        
            System.out.println("Synchronize Response: " + response.readEntity(String.class));
        }
        
        deleteAll();
    }
    
}
