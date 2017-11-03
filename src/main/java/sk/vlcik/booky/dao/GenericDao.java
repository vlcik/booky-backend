package sk.vlcik.booky.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import sk.vlcik.booky.exception.ItemNotFoundException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class GenericDao<T> implements IGenericDao<T> {

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

    @Override
    public void delete(Long id) {
        T entity = getSession().get(getModelClass(), id);
        if (entity != null){
            getSession().delete(entity);
        }
    }

    public List<T> findAll(){
        CriteriaQuery<T> query = getCriteriaBuilder()
                .createQuery(getModelClass());

        Root<T> root = query.from(getModelClass());
        query.select(root);
        Query<T> q = getSession().createQuery(query);
        return q.getResultList();
    }

    public T getEntity(Long id) throws ItemNotFoundException {
        Optional<T> entity = Optional.ofNullable(getSession().get(getModelClass(), id));
        return entity.orElseThrow(() -> new ItemNotFoundException());
    }

    public T saveEntity(T entity){
        return (T) getSession().save(entity);
    }

    @Override
    public void updateEntity(T entity) {
        getSession().merge(entity);
    }

    protected abstract Class<T> getModelClass();
}
