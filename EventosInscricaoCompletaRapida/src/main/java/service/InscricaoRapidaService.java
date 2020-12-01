
package service;

import dao.InscricaoRapidaDAO;
import entidade.RegistroEvento;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inscricaoRapida")
public class InscricaoRapidaService {
    
    private InscricaoRapidaDAO dao;

    public InscricaoRapidaService() {
        dao = new InscricaoRapidaDAO();
    }
    
    @POST
    @Path("/inscricaoRapida")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean inscricaoRapida(RegistroEvento registroEvento) {
        try {
            if ( registroEvento.getUsuario().getId() == null ) {
                dao.cadastroParcialUsuario(registroEvento.getUsuario());
                
                registroEvento.setUsuario(dao.buscaUsuario(registroEvento.getUsuario()));
            }
            
            return (dao.inscricaoRapida(registroEvento));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
