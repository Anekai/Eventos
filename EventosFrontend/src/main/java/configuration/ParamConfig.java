
package configuration;

import entities.Pessoa;

public class ParamConfig {
    
    private static Pessoa usuario;
    
    public ParamConfig() {}
    
    public ParamConfig(Pessoa usuario) {
        this.usuario = usuario;
    }
    
    public Pessoa getUsuarioLogado() {
        return usuario;
    }
    
}
