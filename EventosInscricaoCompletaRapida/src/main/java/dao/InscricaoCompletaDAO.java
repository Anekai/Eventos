
package dao;

import apoio.ConexaoBD;
import entidade.RegistroEvento;
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
    
}
