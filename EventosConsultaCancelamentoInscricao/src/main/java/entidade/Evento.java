
package entidade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import framework.CalendarDeserializer;
import framework.CalendarSerializer;
import java.io.Serializable;
import java.util.Date;
import types.TipoEventoType;

public class Evento implements Serializable {
    
    private Integer id;
    private String nomeEvento;
    private TipoEventoType tipoEvento;
    @JsonSerialize(using = CalendarSerializer.class)
    @JsonDeserialize(using = CalendarDeserializer.class)
    private Date dataEvento;

    public Evento(){}
    
    public Evento(String values) {
        String[] val = values.split(" - ");
        
        id = Integer.valueOf(val[0]);
        nomeEvento = val[1];
    }
    
    public Evento(Integer id, String nomeEvento) {
        this.id = id;
        this.nomeEvento = nomeEvento;
    }
    
    public Evento(Integer id, String nomeEvento, TipoEventoType tipoEvento, Date dataEvento) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.tipoEvento = tipoEvento;
        this.dataEvento = dataEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public TipoEventoType getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEventoType tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }
    
    @Override
    public String toString() {
        return "{" + "id=" + id + ", nomeEvento=" + nomeEvento + ", tipoEvento=" + tipoEvento + ", dataEvento=" + dataEvento + '}';
    }
    
}
