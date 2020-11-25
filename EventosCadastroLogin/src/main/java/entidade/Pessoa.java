
package entidade;

import java.util.Calendar;

public class Pessoa {
    
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private Calendar dataNascimento;
    private String senha;

    public Pessoa() {}
    
    public Pessoa(String values) {
        String[] val = values.split(" - ");
        
        id = Integer.valueOf(val[0]);
        nome = val[1];
    }
    
    public Pessoa(Integer id, String nome, String cpf, String email, Calendar dataNascimento, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
