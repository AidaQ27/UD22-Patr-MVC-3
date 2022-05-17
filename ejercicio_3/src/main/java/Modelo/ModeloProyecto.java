package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProyecto {

	private ConexionMySQL mysql;

	public ModeloProyecto(ConexionMySQL mysql) {
		this.mysql = mysql;
	}

	public void insertar(Proyecto proyecto) {

		try {
			String sqlQuery = "INSERT INTO proyecto (Nombre, Horas) VALUE (\""
					+ proyecto.getNombre() + "\",\"" + proyecto.getHoras() + "\");";
			mysql.insertQuery("Laboratorio", sqlQuery);
		} catch (Exception e) {
			System.out.println("Fallo insercion modelo video");
		}
	}

	public ArrayList<Proyecto> mostrarTodos() {

		try {
			String sqlQuery = "SELECT * FROM proyecto;";
			ResultSet rs = mysql.getAllRows("Laboratorio", sqlQuery);

			ArrayList<Proyecto> arrproyectos = new ArrayList<Proyecto>();

			while (rs.next()) {
				// Crear video y anadirlo al array
				Proyecto proyecto = new Proyecto(rs.getLong("ID"), rs.getString("Nombre"), rs.getString("Horas"));

				arrproyectos.add(proyecto);
			}

			return arrproyectos;

		} catch (Exception e) {
			System.out.println("Fallo mostrar registros");
			System.out.println(e);

			return new ArrayList<Proyecto>();
		}

	}
	
	public Proyecto mostrarPorId(Long id) {
		
		Proyecto proyecto = new Proyecto();
		ResultSet rs = mysql.getRow("clientes", id);
	
		try {
			rs.next();
			proyecto.setID(rs.getLong("ID"));
			proyecto.setNombre(rs.getString("Nombre"));
			proyecto.setHoras(rs.getString("Horas"));
			
	
			return proyecto;
		} catch (SQLException e) {
	
			System.out.println("Fallo modelo clientes al buscar por id");
			System.out.println(e);
			
			return new Proyecto();
		}
	
	
	}

	public void update(Proyecto proyecto) {

		try {
			String sqlQuery = "UPDATE proyecto SET (Nombre, Horas) WHERE ID = "
					+ proyecto.getNombre()+ proyecto.getHoras() + ";";
			mysql.insertQuery("", sqlQuery);

		} catch (Exception e) {
			System.out.println("Fallo Update modelo video");
		}

	}
	
	public void delete(Long id) {
		mysql.deleteRow("proyecto", id);
	}

	public ArrayList<Proyecto> mostrarTodosID() {
	
		try {
			String sqlQuery = "SELECT * FROM proyectos;";
			ResultSet rs = mysql.getAllRows("Laboratorio", sqlQuery);
	
			ArrayList<Proyecto> arrproyecto = new ArrayList<Proyecto>();
	
			while (rs.next()) {
				// Crear video y anadirlo al array
				Proyecto proyecto = new Proyecto(rs.getLong("ID"), rs.getString("Nombre"), rs.getString("Horas"));
	
				arrproyecto.add(proyecto);
			}
	
			return arrproyecto;
	
		} catch (Exception e) {
			System.out.println("Fallo mostrar registros");
			System.out.println(e);
	
			return new ArrayList<Proyecto>();
		}
	
	}
}
