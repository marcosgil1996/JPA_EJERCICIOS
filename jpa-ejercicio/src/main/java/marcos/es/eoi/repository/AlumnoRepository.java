package marcos.es.eoi.repository;

import marcos.es.eoi.entity.Alumno;

public interface AlumnoRepository {

		Alumno findById(int id);
		
		Alumno findByDni(String dni);

		void save(Alumno alumno);

		Alumno update(Alumno alumno);

		void remove(Alumno alumno);

	
}
