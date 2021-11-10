package marcos.es.eoi;

import marcos.es.eoi.entity.Alumno;
import marcos.es.eoi.repository.AlumnoRepository;
import marcos.es.eoi.repository.AlumnoRepositoryJPAImpl;
import marcos.es.eoi.repository.MyAbstractRepository;
import marcos.es.eoi.repository.MyRepository;

public class Main {
	private static final int SALIR = 0, INSERTAR = 1, BUSCAR = 2, ELIMINAR = 3, MODIFICAR = 4;
	private static MyAbstractRepository<Alumno> repository;
	public static void main(String[] args) {
		boolean salir = false;
		int opcion = 0;
		//AlumnoRepository repository = new AlumnoRepositoryJDBCImpl();
		repository = new AlumnoRepositoryJPAImpl();
		
		do {
			//mostaremos el menu
			mostrarMenu();
			opcion = Utilidades.pedirEntero("INTRODUCE UN NÚMERO");
			switch(opcion) {
				case INSERTAR:
					insertarAlumno();
					break;
				case BUSCAR:
					//Almacenamos la info del alumno encontrado en objeto Alumno
					int idAlu = Utilidades.pedirEntero("INTRODUCE EL ID DEL ALUMNO: ");
					Alumno aluSearch = repository.findById(idAlu);
					//Comprobar que el alumno ha sido encontrado
					if(aluSearch!=null) {
						System.out.println("DATOS DEL ALUMNO: ");
						System.out.println(aluSearch.toString());
					}else {
						System.out.println("EL ALUMNO CON EL ID "+idAlu+" NO SE HA PODIDO ENCONTRAR");
					}
					break;
				case ELIMINAR:
					eliminarAlumno();
					break;
				case MODIFICAR:
					modificarAlumno();
					break;
				case SALIR:
					System.out.println("HASTA LA PROXIMA");
					salir = true;
					break;
				default: System.out.println("NO SE HA ENCONTRADO OPCIÓN"); break;
			}
		}while(!salir);
	}
	
	private static void mostrarMenu() {
		System.out.println("MENU ALUMNOS");
		System.out.println("1. Insertar Alumno");
		System.out.println("2. Buscar Alumno");
		System.out.println("3. Eliminar Alumno");
		System.out.println("4. Modificar datos Alumno");
		System.out.println("0. Salir");
	}
	
	private static void modificarAlumno() {
		int idAlu;
		String dni,apellidos;
		
		//Primero introduce id alu
		idAlu = Utilidades.pedirEntero("INTRODUCE EL ID DEL ALUMNO");
		//Llamar al repository para guardar el alu
		if(existeAlu(idAlu)) {
			//Pedir datos
			dni = Utilidades.pedirString("INSERTA EL DNI DEL ALUMNO");
			apellidos = Utilidades.pedirString("INSERTA LOS APELLIDOS DEL ALUMNO");
			
			//Crear objeto alumno con los datos
			Alumno aluUpdate = new Alumno(dni,apellidos);
			
			//Llamar al repository update
			repository.update(aluUpdate);
		}else {
			System.out.println("El alumno con id "+idAlu+" no existe");
		}
	}
	
	private static boolean existeAlu(int id) {
		boolean existe = false;
		Alumno aluSearch = repository.findById(id);
		if(aluSearch != null) {
			existe = true;
		}
		return existe;
	}
	
	private static void eliminarAlumno() {
		int aluIdRemove = Utilidades.pedirEntero("INTRODUCE EL DNI DEL ALUMNO A ELIMINAR: ");
		Alumno aluRemove = repository.findById(aluIdRemove);
		if(aluRemove != null) {
			repository.remove(aluRemove);
			System.out.println("DATOS DEL ALUMNO ELIMINADO: ");
			System.out.println(aluRemove.toString());
		}else {
			System.out.println("El alumno con el DNI "+aluIdRemove+" no se ha podido encontrar");
		}
	}
	
	private static void insertarAlumno() {
		//boolean insertado = false;
		String dni,apellidos;
		
		//Pedir datos
		dni = Utilidades.pedirString("INSERTA EL DNI DEL ALUMNO");
		apellidos = Utilidades.pedirString("INSERTA LOS APELLIDOS DEL ALUMNO");

		//Crear objeto alumno con los datos
		Alumno aluInsert = new Alumno(dni,apellidos);
		
		//Llamar al repository para guardar el alu
		repository.save(aluInsert);
		
		/***
		 * Esta parte de código la dejo comentada por que al ser la PK el ID,
		 * a parte que el ID es autoincrementable.
		 * Se ve que no deja buscar por DNI por que DNI no es PK(Primary key).
		 */
		//Si el alumno no existe
		/*if(repository.findByDni(aluInsert.getDni()).equals(null)) {
			//Llamar al repository para guardar el alu
			repository.save(aluInsert);
		}else {
			System.out.println("El alumno con dni "+dni+" ya existe en el sistema");
		}*/
	}
}
