
package services;

import entities.RegistroEvento;
import java.util.List;

public class RegistroEventoService {
    
    public void insert(RegistroEvento entity) {
        //dao.insert(entity);
    }

    public void update(RegistroEvento entity) {
        //dao.update(entity);
    }

    public void delete(RegistroEvento entity) {
        //dao.delete(entity);
    }
    
    public RegistroEvento findById(Integer id) {
        return null; //dao.findById(id);
    }

    public List<RegistroEvento> find() {
        return null; //dao.find(new RegistroEvento());
    }
    
    public List<RegistroEvento> find(RegistroEvento entity) {
        return null; //dao.find(entity);
    }
    
    public boolean registrarPresenca(RegistroEvento entity) {
        return true;
    }
    
    public boolean inscricaoRapida(RegistroEvento entity) {
        return true;
    }
    
}
