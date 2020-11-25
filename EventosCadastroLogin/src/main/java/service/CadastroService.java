
package service;

import dao.CadastroDAO;
import entidade.Evento;
import entidade.Protesto;
import java.util.ArrayList;
import java.util.Calendar;
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
import types.TipoEventoType;

@Path("/cadastro")
public class CadastroService {
    
    CadastroDAO dao;
    
    public CadastroService(){
        dao = new CadastroDAO();
    }
    
    @GET
    @Path("/teste")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Evento> teste() {
        System.out.println("---------------- Teste ----------------");
        List<Evento> p = new ArrayList<>();
        
        //p.add(new Protesto("0101010101", "Alexandre", new Date(), 10.0));
        p.add(new Evento(1, "Palestra A", TipoEventoType.PALESTRA, Calendar.getInstance()));
        
        return p;
    }
    
}
