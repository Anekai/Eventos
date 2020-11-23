
package dao;

import entidade.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventoDAO {
    
    public List<Evento> listarDados() {
        List<Evento> result = new ArrayList<>();
        
        result.add(new Evento("0101010101", "Alexandre", new Date(), 10.0));
        
        return result;
    }
    
}
