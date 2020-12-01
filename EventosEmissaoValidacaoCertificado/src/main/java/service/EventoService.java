
package service;

import apoio.ConexaoBD;
import dao.EventoDAO;
import entidade.Evento;
import entidade.RegistroEvento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @GET
    @Path("/codigoValidacao/{codigovalidacao}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public RegistroEvento codigoValidacao(@PathParam("codigoValidacao") String codigovalidacao){
        
        StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT p.nome AS nome_pessoa, e.nome_evento AS nome_evento")
               .append(" FROM   pessoa p, registro_evento re")
               .append(" WHERE re.codigo_validacao = '" + codigovalidacao + "'");
            
            RegistroEvento registro = new RegistroEvento();
                try {
                    ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
                    
                    while (resultado.next()) {
                RegistroEvento re = new RegistroEvento();

                re.getUsuario().setNome(resultado.getString("nome_pessoa"));
                re.getEvento().setNomeEvento(resultado.getString("nome_evento"));
                
                registro = re;
            }
                } catch (SQLException ex) {
                }
        
        return registro;
    }
    
}
