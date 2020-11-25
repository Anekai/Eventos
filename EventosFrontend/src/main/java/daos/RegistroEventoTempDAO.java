
package daos;

import entities.RegistroEventoTemp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RegistroEventoTempDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(RegistroEventoTemp entity) {
        em.persist(entity);
    }

    public void update(RegistroEventoTemp entity) {
        em.merge(entity);
    }

    public void delete(RegistroEventoTemp entity) {
        em.remove(entity);
    }
    
    public RegistroEventoTemp findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(RegistroEventoTemp.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (RegistroEventoTemp)criteria.uniqueResult();
    }
    
    public List<RegistroEventoTemp> find(RegistroEventoTemp entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(RegistroEventoTemp.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
