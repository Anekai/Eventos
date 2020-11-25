
package services;

import daos.RegistroEventoTempDAO;
import entities.RegistroEventoTemp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistroEventoTempService {
    
    @Autowired
    RegistroEventoTempDAO dao;

    public void insert(RegistroEventoTemp entity) {
        dao.insert(entity);
    }

    public void update(RegistroEventoTemp entity) {
        dao.update(entity);
    }

    public void delete(RegistroEventoTemp entity) {
        dao.delete(entity);
    }
    
    public RegistroEventoTemp findById(Integer id) {
        return dao.findById(id);
    }

    public List<RegistroEventoTemp> find() {
        return dao.find(new RegistroEventoTemp());
    }
    
    public List<RegistroEventoTemp> find(RegistroEventoTemp entity) {
        return dao.find(entity);
    }
    
}
