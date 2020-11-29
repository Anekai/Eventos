
package dao;

import apoio.ConexaoBD;
import entidade.Evento;
import entidade.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLType;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import types.TipoEventoType;

public class CadastroDAO {
    
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
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e);
            return false;
        }
    }
    
    public boolean atualizarUsuario(Pessoa pessoa) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("UPDATE pessoa SET cpf = ?, nome = ?, email = ?, data_nascimento = ?, senha = ? WHERE id = ?");
        
            st.setString(1, pessoa.getCpf());
            st.setString(2, pessoa.getNome());
            st.setString(3, pessoa.getEmail());
            st.setObject(4, pessoa.getDataNascimento(), Types.DATE);
            st.setString(5, pessoa.getSenha());
            st.setInt(6, pessoa.getId());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e);
            return false;
        }
    }
    
    public List<Pessoa> findUsuarios(Pessoa pessoa) {
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT * ")
               .append(" FROM   pessoa pess")
               .append(" WHERE  1 = 1");
            
            if ( pessoa.getId() != null ) {
                sql.append(" AND pess.id = " + pessoa.getId());
            }
            
            if ( pessoa.getNome() != null && !pessoa.getNome().isEmpty() ) {
                sql.append(" AND pess.nome = '" + pessoa.getNome() + "' ");
            }
            
            sql.append(" ORDER BY pess.id ");
            
            ArrayList<Pessoa> resultados = new ArrayList<>();
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
            
            while (resultado.next()) {
                Pessoa p = new Pessoa();

                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setCpf(resultado.getString("cpf"));
                p.setEmail(resultado.getString("email"));
                p.setDataNascimento(resultado.getDate("data_nascimento"));
                p.setSenha(resultado.getString("senha"));
                
                resultados.add(p);
            }

            return resultados;
        } catch (Exception e) {
            System.out.println("Erro ao buscar usuários: " + e);
            return null;
        }
    }
    
    public boolean cadastrarEvento(Evento evento) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("INSERT INTO evento(id, nome_evento, tipo_evento, data) VALUES (DEFAULT, ?, ?, ?)");
        
            st.setString(1, evento.getNomeEvento());
            st.setString(2, evento.getTipoEvento().toString());
            st.setObject(3, evento.getDataEvento(), Types.DATE);
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar evento: " + e);
            return false;
        }
    }
    
    public boolean atualizarEvento(Evento evento) {
        try {
            PreparedStatement st = ConexaoBD.getInstance().getConnection().prepareStatement("UPDATE evento SET nome_evento = ?, tipo_evento = ?, data = ? WHERE id = ?");
        
            st.setString(1, evento.getNomeEvento());
            st.setString(2, evento.getTipoEvento().toString());
            st.setObject(3, evento.getDataEvento(), Types.DATE);
            st.setInt(4, evento.getId());
            st.executeUpdate();
            st.close();
            
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar evento: " + e);
            return false;
        }
    }
    
    public List<Evento> findEventos(Evento evento) {
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append(" SELECT * ")
               .append(" FROM   evento even")
               .append(" WHERE  1 = 1");
            
            if ( evento.getId() != null ) {
                sql.append(" AND even.id = " + evento.getId());
            }
            
            if ( evento.getNomeEvento() != null && !evento.getNomeEvento().isEmpty() ) {
                sql.append(" AND even.nome_evento = '" + evento.getNomeEvento() + "' ");
            }
            
            if ( evento.getTipoEvento() != null ) {
                sql.append(" AND even.tipo_evento = '" + evento.getTipoEvento() + "' ");
            }
            
            sql.append(" ORDER BY even.id ");
            
            ArrayList<Evento> resultados = new ArrayList<>();
            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql.toString());
            
            while (resultado.next()) {
                Evento e = new Evento();

                e.setId(resultado.getInt("id"));
                e.setNomeEvento(resultado.getString("nome_evento"));
                e.setTipoEvento(TipoEventoType.valueOf(resultado.getString("tipo_evento")));
                e.setDataEvento(resultado.getDate("data"));

                resultados.add(e);
            }

            return resultados;
        } catch (Exception e) {
            System.out.println("Erro ao buscar eventos: " + e);
            return null;
        }
    }
    
}
