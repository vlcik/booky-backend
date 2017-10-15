package sk.vlcik.booky.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    protected List<T> findAll(){
        CriteriaQuery<T> query = getSession()
                .getCriteriaBuilder()
                .createQuery(getModelClass());

        Root<T> root = query.from(getModelClass());
        query.select(root);
        Query<T> q = getSession().createQuery(query);
        return q.getResultList();
    }

    protected abstract Class<T> getModelClass();
}
