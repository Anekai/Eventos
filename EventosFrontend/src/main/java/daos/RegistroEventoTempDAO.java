
package daos;

import configuration.ConexaoBD;
import entities.RegistroEventoTemp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import types.SimNaoType;

public class RegistroEventoTempDAO {
    

    public boolean insert(RegistroEventoTemp entity) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO registro_evento_temp(id, id_usuario, id_evento, presenca, codigo_validacao, nome_usuario, cpf_usuario, email_usuario) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?)");
        
            st.setInt(1, entity.getIdUsuario());
            st.setInt(2, entity.getIdEvento());
            st.setString(3, entity.getPresenca().toString());
            st.setString(4, entity.getCodigoValidacao());
            st.setString(5, entity.getNomeUsuario());
            st.setString(6, entity.getCpfUsuario());
            st.setString(7, entity.getEmailUsuario());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar inscrição temporária: " + e);
            return false;
        }
    }
    
    public boolean deleteAll() {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("DELETE FROM registro_evento_temp");
        
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao excluir inscrições temporárias: " + e);
            return false;
        }
    }
    
    public List<RegistroEventoTemp> find() {
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT * ")
               .append(" FROM   registro_evento_temp")
               .append(" ORDER BY id ");
            
            ArrayList<RegistroEventoTemp> resultados = new ArrayList<>();
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
            
            while (resultado.next()) {
                RegistroEventoTemp p = new RegistroEventoTemp();

                p.setId(resultado.getInt("id"));
                p.setIdUsuario(resultado.getInt("id_usuario"));
                p.setIdEvento(resultado.getInt("id_evento"));
                p.setPresenca(SimNaoType.valueOf(resultado.getString("presenca")));
                p.setCodigoValidacao(resultado.getString("codigo_validacao"));
                p.setNomeUsuario(resultado.getString("nome_usuario"));
                p.setCpfUsuario(resultado.getString("cpf"));
                p.setEmailUsuario(resultado.getString("email_usuario"));
                
                resultados.add(p);
            }

            return resultados;
        } catch (Exception e) {
            System.out.println("Erro ao buscar inscrições temporárias: " + e);
            return null;
        }
    }
    
}
