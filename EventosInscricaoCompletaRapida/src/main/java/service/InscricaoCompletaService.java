
package service;

import dao.InscricaoCompletaDAO;
import entidade.RegistroEvento;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inscricaoCompleta")
public class InscricaoCompletaService {

    private InscricaoCompletaDAO dao;
    
    public InscricaoCompletaService() {
        dao = new InscricaoCompletaDAO();
    }
    
    @POST
    @Path("/inscricaoCompleta")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean inscricaoCompleta(RegistroEvento p) {
        System.out.println("-------------------------------------- Inscrição Completa --------------------------------------");
        try {
            return (dao.inscricaoCompleta(p));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
