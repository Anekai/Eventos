
package dao;

import apoio.ConexaoBD;
import entidade.Pessoa;
import entidade.RegistroEvento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegistroPresencaDAO {
    
    public boolean confirmarPresenca(RegistroEvento registroEvento) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("UPDATE registro_evento SET presenca = 'SIM', codigo_validacao = CONCAT( pessoa_id, (select cpf from pessoa where id = pessoa_id), evento_id ) WHERE evento_id = ? AND pessoa_id = ?");
            
            st.setInt(1, registroEvento.getEvento().getId());
            st.setInt(2, registroEvento.getUsuario().getId());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao confirmar presença: " + e);
            return false;
        }
    }
    
    public Pessoa buscarUsuario(Integer id) {
        try {
            String sql = "SELECT * FROM pessoa WHERE id = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pessoa p = new Pessoa();

                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setCpf(resultado.getString("cpf"));
                p.setEmail(resultado.getString("email"));
                p.setDataNascimento(resultado.getDate("data_nascimento"));
                p.setSenha(resultado.getString("senha"));

                return p;
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário: " + e);
        }

        return null;
    }
    
}
