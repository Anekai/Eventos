
package dao;

import apoio.ConexaoBD;
import entidade.Pessoa;
import entidade.RegistroEvento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import types.SimNaoType;

public class InscricaoRapidaDAO {
    
    public boolean cadastroParcialUsuario(Pessoa usuario) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO pessoa(id, cpf, nome, email, senha) VALUES (DEFAULT, ?, ?, ?, 'teste123')");
        
            st.setString(1, usuario.getCpf());
            st.setString(2, usuario.getNome());
            st.setString(3, usuario.getEmail());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao realizar cadastro parcial do usuário: " + e);
            return false;
        }
    }
    
    public Pessoa buscaUsuario(Pessoa usuario) {
        try {
            String sql = "SELECT * FROM pessoa WHERE email = '" + usuario.getEmail() + "' and senha = 'teste123'";

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
            System.out.println("Erro ao buscar usuário parcial: " + e);
        }

        return null;
    }
    
    public boolean inscricaoRapida(RegistroEvento registroEvento) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO registro_evento(pessoa_id, evento_id, presenca, codigo_validacao) VALUES (?, ?, ?, ?)");
        
            st.setInt(1, registroEvento.getUsuario().getId());
            st.setInt(2, registroEvento.getEvento().getId());
            st.setString(3, SimNaoType.SIM.toString());
            st.setString(4, registroEvento.getUsuario().getId() + registroEvento.getUsuario().getCpf() + registroEvento.getEvento().getId());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao realizar inscrição rápida: " + e);
            e.printStackTrace();
            return false;
        }
    }
    
}
