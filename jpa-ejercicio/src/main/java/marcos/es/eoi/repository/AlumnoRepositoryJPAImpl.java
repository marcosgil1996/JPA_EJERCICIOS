package marcos.es.eoi.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import marcos.es.eoi.entity.Alumno;


public class AlumnoRepositoryJPAImpl implements AlumnoRepository{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_APP");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public Alumno findById(int id) {
		return em.find(Alumno.class, id);
	}
	
	@Override
	public Alumno findByDni(String dni) {
		return em.find(Alumno.class, dni);
	}

	
	@Override
	public void save(Alumno alumno) {
		em.getTransaction();
		em.getTransaction().begin();
		em.persist(alumno);
		em.getTransaction().rollback();
		em.getTransaction().commit();
		
	}
	
	@Override
	public void remove(Alumno alumno) {
		em.getTransaction();
		em.getTransaction().begin();
		em.remove(alumno);
		em.getTransaction().commit();
	}

	@Override
	public Alumno update(Alumno alumno) {
		em.getTransaction().begin();
		em.merge(alumno);
		em.getTransaction().commit();
		return null;
	}
}