
package service;

import dao.ConsultaInscricaoDAO;
import entidade.RegistroEvento;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/consultaInscricao")
public class ConsultaInscricaoService {
    
    ConsultaInscricaoDAO dao;
    
    public ConsultaInscricaoService(){
        dao = new ConsultaInscricaoDAO();
    }
    
    @POST
    @Path("/consultarInscricoes")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<RegistroEvento> consultarInscricoes(RegistroEvento registroEvento) {
        try {
            return (dao.consultarInscricoes(registroEvento));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
