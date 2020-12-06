
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
    
    public ParamConfig(Pessoa usuarioParam) {
        usuario = usuarioParam;
    }
    
    public ParamConfig(List<Evento> eventosParam, List<Pessoa> usuariosParam, List<RegistroEvento> inscricoesParam) {
        eventos = eventosParam;
        usuarios = usuariosParam;
        inscricoes = inscricoesParam;
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
