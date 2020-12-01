
package service;

import dao.RegistroPresencaDAO;
import entidade.Pessoa;
import entidade.RegistroEvento;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/registroPresenca")
public class RegistroPresencaService {
    
    RegistroPresencaDAO dao;
    
    public RegistroPresencaService(){
        dao = new RegistroPresencaDAO();
    }
    
    @PUT
    @Path("/confirmarPresenca")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean confirmarPresenca(RegistroEvento registroEvento) {
        try {
            return (dao.confirmarPresenca(registroEvento));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @GET
    @Path("/buscarUsuario/{idUsuario}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Pessoa buscarUsuario(@PathParam("idUsuario") Integer idUsuario) {
        return (dao.buscarUsuario(idUsuario));
    }
    
}
