package marcos.es.eoi.repository;

public interface MyRepository <E> {
	
	E findById(int id);
	
	void remove(E entity);
	
	E update(E entity);
	
	void save(E entity);
	
}
