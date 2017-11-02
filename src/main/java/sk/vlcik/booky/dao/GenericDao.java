package sk.vlcik.booky.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected CriteriaBuilder getCriteriaBuilder(){
        return getSession().getCriteriaBuilder();
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    protected List<T> findAll(){
        CriteriaQuery<T> query = getCriteriaBuilder()
                .createQuery(getModelClass());

        Root<T> root = query.from(getModelClass());
        query.select(root);
        Query<T> q = getSession().createQuery(query);
        return q.getResultList();
    }

    public T getEntity(Long id){
        return getSession().get(getModelClass(), id);
    }

    protected T saveEntity(T entity){
        return (T) getSession().save(entity);
    }

    protected abstract Class<T> getModelClass();
}
