
package daos;

import configuration.ConexaoBD;
import entities.RegistroEvento;
import entities.RegistroEventoTemp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import types.SimNaoType;

public class RegistroEventoTempDAO {
    
    public boolean registrarPresenca(RegistroEvento entity) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO registro_evento_temp(id_registro_evento_temp, id_usuario, id_evento, presenca) VALUES (DEFAULT, ?, ?, ?)");
        
            st.setInt(1, entity.getUsuario().getId());
            st.setInt(2, entity.getEvento().getId());
            st.setString(3, SimNaoType.SIM.toString());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao registrar a presença temporária: " + e);
            return false;
        }
    }

    public boolean inscricaoRapidaWithUser(RegistroEvento entity) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO registro_evento_temp(id_registro_evento_temp, id_usuario, id_evento) VALUES (DEFAULT, ?, ?)");
        
            st.setInt(1, entity.getUsuario().getId());
            st.setInt(2, entity.getEvento().getId());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar inscrição temporária: " + e);
            return false;
        }
    }
    
    public boolean inscricaoRapidaWithoutUser(RegistroEvento entity) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO registro_evento_temp(id_registro_evento_temp, id_evento, nome_usuario, cpf_usuario, email_usuario) VALUES (DEFAULT, ?, ?, ?, ?)");
        
            st.setInt(1, entity.getEvento().getId());
            st.setString(2, entity.getUsuario().getNome());
            st.setString(3, entity.getUsuario().getCpf());
            st.setString(4, entity.getUsuario().getEmail());
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
               .append(" FROM   registro_evento_temp ")
               .append(" ORDER BY id_registro_evento_temp ");
            
            ArrayList<RegistroEventoTemp> resultados = new ArrayList<>();
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
            
            while (resultado.next()) {
                RegistroEventoTemp p = new RegistroEventoTemp();

                p.setId(resultado.getInt("id_registro_evento_temp"));
                p.setIdUsuario(resultado.getString("id_usuario") != null ? Integer.valueOf(resultado.getString("id_usuario")) : null);
                p.setIdEvento(resultado.getInt("id_evento"));
                p.setPresenca(resultado.getString("presenca") != null ? SimNaoType.valueOf(resultado.getString("presenca")) : null);
                p.setNomeUsuario(resultado.getString("nome_usuario"));
                p.setCpfUsuario(resultado.getString("cpf_usuario"));
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
