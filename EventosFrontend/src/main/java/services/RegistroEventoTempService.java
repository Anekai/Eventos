
package services;

import daos.RegistroEventoTempDAO;
import entities.RegistroEventoTemp;
import java.util.List;

public class RegistroEventoTempService {
    
    RegistroEventoTempDAO dao;

    public RegistroEventoTempService() {
        dao = new RegistroEventoTempDAO();
    }

    public void insert(RegistroEventoTemp entity) {
        dao.insert(entity);
    }
    
    public void deleteAll() {
        dao.deleteAll();
    }

    public List<RegistroEventoTemp> find() {
        return dao.find();
    }
    
}
