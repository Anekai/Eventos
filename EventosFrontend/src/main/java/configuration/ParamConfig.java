
package configuration;

import entities.Evento;
import entities.Pessoa;
import entities.RegistroEvento;
import java.util.List;

public class ParamConfig {
    
    private static Pessoa usuario;
    private static List<Evento> eventos;
    private static List<Pessoa> usuarios;
    private static List<RegistroEvento> inscricoes;
    
    public ParamConfig() {}
    
    public ParamConfig(Pessoa usuario, List<Evento> eventos, List<Pessoa> usuarios, List<RegistroEvento> inscricoes) {
        this.usuario = usuario;
        this.eventos = eventos;
        this.usuarios = usuarios;
        this.inscricoes = inscricoes;
    }
    
    public Pessoa getUsuarioLogado() {
        return usuario;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Pessoa> getUsuarios() {
        return usuarios;
    }

    public List<RegistroEvento> getInscricoes() {
        return inscricoes;
    }
    
}
