
package dao;

import apoio.ConexaoBD;
import entidade.Evento;
import entidade.Pessoa;
import entidade.RegistroEvento;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import types.SimNaoType;

public class ConsultaInscricaoDAO {
    
    public List<RegistroEvento> consultarInscricoes(RegistroEvento registroEvento) {
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT reev.* ")
               .append(" ,      pess.nome ")
               .append(" ,      even.nome_evento ")
               .append(" FROM   registro_evento reev ")
               .append(" INNER JOIN pessoa pess ON reev.pessoa_id = pess.id ")
               .append(" INNER JOIN evento even ON reev.evento_id = even.id ")
               .append(" WHERE  1 = 1");
            
            if ( registroEvento.getUsuario() != null && registroEvento.getUsuario().getId() != null ) {
                sql.append(" AND reev.pessoa_id = " + registroEvento.getUsuario().getId());
            }
            
            if ( registroEvento.getEvento()!= null && registroEvento.getEvento().getId() != null ) {
                sql.append(" AND reev.evento_id = " + registroEvento.getEvento().getId());
            }
            
            sql.append(" ORDER BY reev.evento_id ");
            
            ArrayList<RegistroEvento> resultados = new ArrayList<>();
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
            
            while (resultado.next()) {
                RegistroEvento r = new RegistroEvento();

                r.setUsuario(new Pessoa(resultado.getInt("pessoa_id"), resultado.getString("nome")));
                r.setEvento(new Evento(resultado.getInt("evento_id"), resultado.getString("nome_evento")));
                r.setPresenca(SimNaoType.valueOf(resultado.getString("presenca")));
                r.setCodigoValidacao(resultado.getString("codigo_validacao"));
                
                resultados.add(r);
            }
            
            System.out.println();
            System.out.println();
            System.out.println(sql);
            System.out.println();
            System.out.println();

            return resultados;
        } catch (Exception e) {
            System.out.println("Erro ao buscar inscrições: " + e);
            return null;
        }
    }
    
}
