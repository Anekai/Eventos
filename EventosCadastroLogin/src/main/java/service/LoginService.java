
package service;

import dao.LoginDAO;
import entidade.Pessoa;
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
    @Path("/loginUsuario/{email}/{senha}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Pessoa loginUsuario(@PathParam("email")String email, @PathParam("senha")String senha) {
        return dao.findUsuario(email, senha);
    }
    
}
