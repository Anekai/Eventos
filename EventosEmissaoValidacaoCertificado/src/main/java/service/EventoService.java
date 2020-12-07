
package service;

import apoio.ConexaoBD;
import dao.EventoDAO;
import entidade.Evento;
import entidade.Pessoa;
import entidade.RegistroEvento;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import types.SimNaoType;

@Path("/evento")
public class EventoService {
    
    EventoDAO dao;
    
    public EventoService(){
        dao = new EventoDAO();
    }
    
    @GET
    @Path("/codigoValidacao/{codigoValidacao}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public RegistroEvento codigoValidacao(@PathParam("codigoValidacao") String codigovalidacao){
        StringBuilder sql = new StringBuilder();
            
        sql.append(" SELECT re.* ")
           .append(" ,      p.nome AS nome_pessoa ")
           .append(" ,      e.nome_evento ")
           .append(" ,      p.email ")
           .append(" FROM   registro_evento re ")
           .append(" INNER JOIN pessoa p ON re.pessoa_id = p.id ")
           .append(" INNER JOIN evento e ON re.evento_id = e.id ")
           .append(" WHERE  re.codigo_validacao = '" + codigovalidacao + "' ");
        
        System.out.println();
        System.out.println();
        System.out.println(sql);
        System.out.println();
        System.out.println();
            
        RegistroEvento registro = new RegistroEvento();
        
        try {
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
                    
            while (resultado.next()) {
                RegistroEvento re = new RegistroEvento();

                re.setUsuario(new Pessoa(resultado.getInt("pessoa_id"), resultado.getString("nome_pessoa"), resultado.getString("email")));
                re.setEvento(new Evento(resultado.getInt("evento_id"), resultado.getString("nome_evento")));
                re.setPresenca(SimNaoType.valueOf(resultado.getString("presenca")));
                re.setCodigoValidacao(resultado.getString("codigo_validacao"));
                
                registro = re;
                
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar inscrições: " + ex);
            return null;
        }
        
        return registro;
    }
    
}
