
package dao;

import apoio.ConexaoBD;
import java.sql.PreparedStatement;

public class CancelamentoInscricaoDAO {
    
    public boolean cancelarInscricao(Integer idEvento, Integer idUsuario) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("DELETE FROM registro_evento WHERE pessoa_id = ? AND evento_id = ?");
        
            st.setInt(1, idUsuario);
            st.setInt(2, idEvento);
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cancelar inscrição: " + e);
            return false;
        }
    }
    
}
