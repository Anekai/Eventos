
package entities;

import java.io.Serializable;
import types.SimNaoType;

public class RegistroEventoTemp implements Serializable {
    
    private Integer id;
    private Integer idUsuario;
    private Integer idEvento;
    private SimNaoType presenca;
    private String nomeUsuario;
    private String cpfUsuario;
    private String emailUsuario;

    public RegistroEventoTemp(){}
    
    public RegistroEventoTemp(Integer id, Integer idUsuario, Integer idEvento, SimNaoType presenca, String nomeUsuario, String cpfUsuario, String emailUsuario) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.presenca = presenca;
        this.nomeUsuario = nomeUsuario;
        this.cpfUsuario = cpfUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public SimNaoType getPresenca() {
        return presenca;
    }

    public void setPresenca(SimNaoType presenca) {
        this.presenca = presenca;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

}
