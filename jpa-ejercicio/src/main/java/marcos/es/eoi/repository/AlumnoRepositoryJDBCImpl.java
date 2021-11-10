package marcos.es.eoi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import marcos.es.eoi.entity.Alumno;

public class AlumnoRepositoryJDBCImpl implements AlumnoRepository {

	@Override
	public Alumno findById(int id) {
		Alumno alumno = null;
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beca?serverTimezone=UTC", "root", "1234");
			PreparedStatement pst=con.prepareStatement("SELECT * FROM  BECA.ALUMNOS WHERE ID=?");
			pst.setInt(1,id);
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setApellidos(rs.getString("apellidos"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {	
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}

		return alumno;
	}

	@Override
	public void save(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno update(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Alumno alumno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
