
package service;

import dao.CancelamentoInscricaoDAO;
import entidade.RegistroEvento;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cancelamentoInscricao")
public class CancelamentoInscricaoService {
    
    CancelamentoInscricaoDAO dao;
    
    public CancelamentoInscricaoService(){
        dao = new CancelamentoInscricaoDAO();
    }
    
    @DELETE
    @Path("/cancelarInscricao/{idEvento}/{idUsuario}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean cancelarInscricao(@PathParam("idEvento")Integer idEvento, @PathParam("idUsuario")Integer idUsuario) {
        try {
            return (dao.cancelarInscricao(idEvento, idUsuario));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
