
package service;

import dao.EventoDAO;
import entidade.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/evento")
public class EventoService {
    
    EventoDAO dao;
    
    public EventoService(){
        dao = new EventoDAO();
    }
    
    @GET
    @Path("/teste")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Evento> teste() {
        System.out.println("---------------- Teste ----------------");
        List<Evento> p = dao.listarDados();
        
        return p;
    }
    
}
