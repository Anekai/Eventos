
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import types.SimNaoType;

@Entity
@Table(name = "registro_evento_temp")
@SequenceGenerator(allocationSize = 1, name = "seq_registro_evento_temp", sequenceName = "seq_registro_evento_temp")
public class RegistroEventoTemp implements Serializable {
    
    private Integer id;
    private Integer usuario;
    private Integer evento;
    private SimNaoType presenca;
    private String codigoValidacao;
    
    @Id
    @GeneratedValue(generator = "seq_registro_evento_temp", strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro_evento_temp")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "id_usuario")
    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Column(name = "id_evento")
    public Integer getEvento() {
        return evento;
    }

    public void setEvento(Integer evento) {
        this.evento = evento;
    }

    @Column(name = "presenca")
    @Enumerated(EnumType.STRING)
    public SimNaoType getPresenca() {
        return presenca;
    }

    public void setPresenca(SimNaoType presenca) {
        this.presenca = presenca;
    }

    @Column(name = "codigo_validacao")
    public String getCodigoValidacao() {
        return codigoValidacao;
    }

    public void setCodigoValidacao(String codigoValidacao) {
        this.codigoValidacao = codigoValidacao;
    }
    
}
