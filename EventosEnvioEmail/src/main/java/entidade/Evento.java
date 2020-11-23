
package entidade;

import java.util.Date;
import java.io.Serializable;

public class Evento implements Serializable {

    private int id;
    private String cnpj;
    private String nome;
    private Date data;
    private double valor;

    public Evento() {

    }

    public Evento(String cnpj, String nome, Date data, double valor) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", cnpj=" + cnpj + ", nome=" + nome + ", data=" + data + ", valor=" + valor + '}';
    }

}