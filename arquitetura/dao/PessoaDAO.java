/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidade.Pessoa;
import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PessoaDAO {

    private String converteData(Date data) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(data);
        return date;
    }

    public String salvar(Pessoa objeto) {
        try {
            String sql = "INSERT INTO pessoa (id, cpf, nome, email, data_nasc) VALUES (DEFAULT,"
                    + "'" + objeto.getCpf()+ "', "
                    + "'" + objeto.getNome() + "',"
                    + "'" + objeto.getEmail()+ "',"
                    + "'" + converteData(objeto.getData_nasc())+"'";

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            return e.toString();
        }
        return null;
    }

    public String atualizar(Pessoa p) {
        try {
            String sql = "UPDATE pessoa SET "
                    + "nome = '" + p.getNome() + "', "
                    + "data_nasc = '" + converteData(p.getData_nasc()) + "',"
                    + "cpf = '" + p.getCpf()+ "' "
                    + "email = '" + p.getEmail()+ "' "
                    + "WHERE id = " + p.getId();

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            return e.toString();
        }
        return null;
    }

    public String excluir(int id) {
        try {
            String sql = "DELETE FROM pessoa "
                    + "WHERE id = " + id;

            int resultado = ConexaoBD.getInstance().getConnection().createStatement().executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e);
            return e.toString();
        }
        return null;
    }

    public ArrayList<Pessoa> consultarTodos() {
        ArrayList<Pessoa> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM pessoa"
                    + " ORDER BY id ASC";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pessoa o = new Pessoa();

                o.setId(resultado.getInt("id"));
                o.setCpf(resultado.getString("cpf"));
                o.setNome(resultado.getString("nome"));
                o.setData_nasc(resultado.getDate("data_nasc"));
                o.setEmail(resultado.getString("email"));

                obj.add(o);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

    public Pessoa consultarID(int id) {
        try {
            String sql = "SELECT * FROM pessoa"
                    + " WHERE id = " + id;

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pessoa p = new Pessoa();

                p.setId(resultado.getInt("id"));
                p.setCpf(resultado.getString("Cpf"));
                p.setNome(resultado.getString("nome"));
                p.setData_nasc(resultado.getDate("data"));
                p.setEmail(resultado.getString("email"));

                return p;
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return null;
    }

    public ArrayList<Pessoa> consultarCPF(String Cpf) {
        ArrayList<Pessoa> obj = new ArrayList<>();

        try {
            String sql = "SELECT * FROM pessoa"
                    + " WHERE Cpf = '" + Cpf + "'"
                    + " ORDER BY id";

            ResultSet resultado = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            while (resultado.next()) {
                Pessoa u = new Pessoa();

                u.setId(resultado.getInt("id"));
                u.setCpf(resultado.getString("Cpf"));
                u.setNome(resultado.getString("nome"));
                u.setData_nasc(resultado.getDate("data_nasc"));
                u.setEmail(resultado.getString("email"));

                obj.add(u);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return obj;
    }

}
