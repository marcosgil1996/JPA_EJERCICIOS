package marcos.es.eoi.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "alumnos", schema = "beca")
public class Alumno{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	public Alumno(String dni, String apellidos) {
		this.dni = dni;
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return 	"ID:\t"+this.getId()+"\n"+
			 	"APELLIDOS:\t"+this.getApellidos()+"\n"+
				"DNI:\t"+this.getDni();
	}

}