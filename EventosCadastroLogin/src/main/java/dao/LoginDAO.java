
package dao;

import apoio.ConexaoBD;
import entidade.Pessoa;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LoginDAO {
    
    public Pessoa findUsuario(String email, String senha) {
        try {
            String sql = "SELECT * FROM pessoa WHERE email = '" + email + "' and senha = '" + senha + "'";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pessoa p = new Pessoa();

                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setCpf(resultado.getString("cpf"));
                p.setEmail(resultado.getString("email"));
                
                Calendar c = Calendar.getInstance();
                
                c.setTime(resultado.getDate("data_nascimento"));
                
                p.setDataNascimento(resultado.getDate("data_nascimento"));
                p.setSenha(resultado.getString("senha"));

                return p;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return null;
    }
    
}
