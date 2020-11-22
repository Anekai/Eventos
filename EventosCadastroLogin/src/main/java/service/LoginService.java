
package service;

import dao.LoginDAO;
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

@Path("/login")
public class LoginService {
    
    LoginDAO dao;
    
    public LoginService(){
        dao = new LoginDAO();
    }
    
    @GET
    @Path("/teste")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<String> teste() {
        System.out.println("---------------- Teste ----------------");
        List<String> p = new ArrayList<>();
        
        p.add("Teste 1");
        p.add("Teste 2");
        p.add("Teste 3");
        
        return p;
    }
    
}
