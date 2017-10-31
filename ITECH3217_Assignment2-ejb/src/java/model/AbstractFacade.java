package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> _entityClass) {
        this.entityClass = _entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T _entity) {
        getEntityManager().persist(_entity);
    }

    public void edit(T _entity) {
        getEntityManager().merge(_entity);
    }

    public void remove(T _entity) {
        getEntityManager().remove(getEntityManager().merge(_entity));
    }

    public T find(Object _object) {
        return getEntityManager().find(this.entityClass, _object);
    }

    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.entityClass));
        return (List<T>) getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] _range) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(this.entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(_range[1] - _range[0] + 1);
        q.setFirstResult(_range[0]);
        return (List<T>) q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(this.entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
