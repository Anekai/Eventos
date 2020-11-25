
package dao;

import apoio.ConexaoBD;
import entidade.Pessoa;
import java.sql.PreparedStatement;
import java.sql.SQLType;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAO {
    
    public List<String> listarDados() {
        return new ArrayList<>();
    }
    
    public boolean cadastrarUsuario(Pessoa pessoa) {
        
        
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO pessoa(id, cpf, nome, email, data_nascimento, senha) VALUES (DEFAULT, ?, ?, ?, ?, ?)");
        
            st.setString(1, pessoa.getCpf());
            st.setString(2, pessoa.getNome());
            st.setString(3, pessoa.getEmail());
            st.setObject(4, pessoa.getDataNascimento(), Types.DATE);
            st.setString(5, pessoa.getSenha());
            st.executeUpdate();
            st.close();
            
            /*String sql = "INSERT INTO pessoa VALUES (DEFAULT,"
                    + "'" + pessoa.getCpf()+ "', "
                    + "'" + pessoa.getNome() + "',"
                    + "'" + pessoa.getEmail()+ "',"
                    + "to_date('" + new SimpleDateFormat("dd/MM/yyyy").format(pessoa.getDataNascimento()) + "', 'DD/MM/YYYY'),"
                    + "'" + pessoa.getSenha()+ "')";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql); */

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return false;
        }
        
        return true;
    }
    
}
