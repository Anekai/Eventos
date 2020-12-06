
package service;

import dao.CadastroDAO;
import entidade.Evento;
import entidade.Pessoa;
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
import types.SimNaoType;
import types.TipoEventoType;

@Path("/cadastro")
public class CadastroService {
    
    CadastroDAO dao;
    
    public CadastroService(){
        dao = new CadastroDAO();
    }
    
    @POST
    @Path("/cadastrarUsuario")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean cadastrarUsuario(Pessoa p) {
        System.out.println("---------------- Inserindo protestos "+p.toString());
        try {
            return (dao.cadastrarUsuario(p));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
//    @POST
//    @Path("/cadastrarUsuario")
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
//    public void cadastrarUsuario(Pessoa p) {
//        System.out.println("---------------- Inserindo protestos "+p.toString());
//        try {
//            System.out.println("teste");
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//    }
    
    
    @PUT
    @Path("/atualizarUsuario")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean atualizarUsuario(Pessoa pessoa) {
        try {
            return (dao.atualizarUsuario(pessoa));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @POST
    @Path("/buscarUsuarios")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Pessoa> buscarUsuarios(Pessoa pessoa) {
        try {
            return (dao.findUsuarios(pessoa));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @POST
    @Path("/cadastrarEvento")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean cadastrarEvento(Evento evento) {
        try {
            return (dao.cadastrarEvento(evento));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @PUT
    @Path("/atualizarEvento")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean atualizarEvento(Evento evento) {
        try {
            return (dao.atualizarEvento(evento));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @POST
    @Path("/buscarEventos")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Evento> buscarEventos(Evento evento) {
        try {
            return (dao.findEventos(evento));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
