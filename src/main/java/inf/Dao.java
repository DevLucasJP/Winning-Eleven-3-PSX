package inf;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Dao<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> pClass;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("projetinho_we3_ps1");
		} catch (Exception e) {
			emf = Persistence.createEntityManagerFactory("projetinho_we3_ps1");
		}
	}

	public Dao() {
	}

	public Dao(Class<E> pClass) {
		em = emf.createEntityManager();
		this.pClass = pClass;
	}

	public Class<E> getpClass() {
		return pClass;
	}

	public void setpClass(Class<E> pClass) {
		this.pClass = pClass;
	}

	public Dao<E> openTransaction() {
		em.getTransaction().begin();

		return this;
	}

	public Dao<E> include(E entity) {
		em.persist(entity);

		return this;
	}

	public Dao<E> closeTransaction() {
		em.getTransaction().commit();

		return this;
	}

	public Dao<E> atomicInclude(E entity) {
		this.openTransaction().include(entity).closeTransaction();

		return this;
	}

	public Dao<E> alter(E entity) {
		this.openTransaction();
		em.merge(entity);
		this.closeTransaction();

		return this;
	}

	public void resetValues(String sql) {
		TypedQuery<E> query = em.createNamedQuery(sql, pClass);
		em.clear();

		openTransaction();
		query.executeUpdate();
		closeTransaction();
	}

	public E getById(Object id) {
		return em.find(pClass, id);
	}

	public List<E> getList() {
		String jqpl = "select e from " + pClass.getName() + " e";

		TypedQuery<E> query = em.createQuery(jqpl, pClass);

		return query.getResultList();
	}

	public void closeDao() {
		em.close();
	}
}
