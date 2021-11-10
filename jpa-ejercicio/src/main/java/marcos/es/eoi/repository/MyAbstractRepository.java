package marcos.es.eoi.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import marcos.es.eoi.entity.Alumno;

public abstract class MyAbstractRepository<E> {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_APP");
	EntityManager em = emf.createEntityManager();
	
	
	public Alumno findById(int id) {
		return em.find(Alumno.class, id);
	}

	public void save(E entity) {
		em.getTransaction();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	public void remove(E entity) {
		em.getTransaction();
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}


	public Alumno update(E entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return null;
	}
}
