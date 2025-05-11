package fr.dgn.imdb.daos;

import java.util.List;

import fr.dgn.imdb.entites.Identifiable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public abstract class AbstractDao<T extends Identifiable<U>, U> {
	
	@PersistenceContext
	protected EntityManager em;
	
	public List<T> findAll(Class<T> entityClass) {
	    String queryString = "from " + entityClass.getSimpleName();
	    TypedQuery<T> query = em.createQuery(queryString, entityClass);
	    
	    return query.getResultList();
	}
	
	public final boolean exists(T bean) {
		TypedQuery<?> query = em.createQuery("from "+bean.getClass().getSimpleName()+" b WHERE b.id=:id", bean.getClass());
		query.setParameter("id", bean.getId());
		return !query.getResultList().isEmpty();
	}
	
	public final T findById(Class<T> clazz, U id) {
		TypedQuery<T> query = em.createQuery("from "+clazz.getSimpleName()+" b WHERE b.id=:id", clazz);
		query.setParameter("id", id);
		return query.getResultStream().findFirst().orElse(null);
	}
	
	public final T updateOrCreate(T bean) {
		T beanDb = findByCriteria(bean);
		if (beanDb==null) {
			insert(bean);
			return bean;
		}
		else if (!beanDb.equals(bean)) {
			update(beanDb, bean);
		}
		return beanDb;
	}
	

	public final void insert(T bean) {
		em.persist(bean);
	}
	
	public abstract T findByCriteria(T bean);
	
	public abstract void update(T beanDb, T nvBean);
}
