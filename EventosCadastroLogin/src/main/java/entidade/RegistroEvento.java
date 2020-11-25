
package entidade;

import java.io.Serializable;
import types.SimNaoType;

public class RegistroEvento implements Serializable {
    
    private Pessoa usuario;
    private Evento evento;
    private SimNaoType presenca;
    private String codigoValidacao;

    public RegistroEvento() {}

    public RegistroEvento(Pessoa usuario, Evento evento, SimNaoType presenca, String codigoValidacao) {
        this.usuario = usuario;
        this.evento = evento;
        this.presenca = presenca;
        this.codigoValidacao = codigoValidacao;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public SimNaoType getPresenca() {
        return presenca;
    }

    public void setPresenca(SimNaoType presenca) {
        this.presenca = presenca;
    }

    public String getCodigoValidacao() {
        return codigoValidacao;
    }

    public void setCodigoValidacao(String codigoValidacao) {
        this.codigoValidacao = codigoValidacao;
    }
    
}
