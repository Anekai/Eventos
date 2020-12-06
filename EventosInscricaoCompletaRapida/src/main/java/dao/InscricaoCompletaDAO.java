
package dao;

import apoio.ConexaoBD;
import entidade.RegistroEvento;
import entidade.RegistroEventoTemp;
import java.sql.PreparedStatement;
import types.SimNaoType;

public class InscricaoCompletaDAO {
    
    public boolean inscricaoCompleta(RegistroEvento registroEvento) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO registro_evento(pessoa_id, evento_id, presenca) VALUES (?, ?, ?)");
        
            st.setInt(1, registroEvento.getUsuario().getId());
            st.setInt(2, registroEvento.getEvento().getId());
            st.setString(3, SimNaoType.NAO.toString());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao realizar inscrição completa: " + e);
            return false;
        }
    }
    
    public boolean synchronizeMarcarPresenca(RegistroEventoTemp inscricaoTemp) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("UPDATE registro_evento SET presenca = 'SIM', codigo_validacao = CONCAT( pessoa_id, (select cpf from pessoa where id = pessoa_id), evento_id ) WHERE evento_id = ? AND pessoa_id = ?");
            
            st.setInt(1, inscricaoTemp.getIdEvento());
            st.setInt(2, inscricaoTemp.getIdUsuario());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao sincronizar confirmação de presença: " + e);
            return false;
        }
    }
    
}
