package Modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ModeloProyecto {

	private ConexionMySQL mysql;

	public ModeloProyecto(ConexionMySQL mysql) {
		this.mysql = mysql;
	}

	public void insertar(Proyecto proyecto) {

		try {
			String sqlQuery = "INSERT INTO proyecto (Nombre, Horas) VALUE (\""
					+ proyecto.getNombre() + "\",\"" + proyecto.getHoras() + ");";
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

	public void update(Proyecto proyecto) {

		try {
			String sqlQuery = "UPDATE proyecto SET (Nombre, Horas) WHERE ID = "
					+ proyecto.getNombre()+ proyecto.getHoras() + ";";
			mysql.insertQuery("", sqlQuery);

		} catch (Exception e) {
			System.out.println("Fallo Update modelo video");
		}

	}
}
