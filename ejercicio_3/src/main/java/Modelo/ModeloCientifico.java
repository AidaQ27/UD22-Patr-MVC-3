package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCientifico {

	private static ConexionMySQL mysql;

	public ModeloCientifico(ConexionMySQL mysql) {
		this.mysql = mysql;
	}

	public void insertar(Cientifico cientifico) {

		try {
			String sqlQuery = "INSERT INTO cientifico (DNI, Nombre) VALUE (\""
					+ cientifico.getDNI() + "\",\"" + cientifico.getNombre() + ");"; 
		} catch (Exception e) {
			System.out.println("Fallo insercion modelo cliente");
		}
	}

	public ArrayList<Cientifico> mostrarTodos() {

		try {
			String sqlQuery = "SELECT * FROM cientifico;";
			ResultSet rs = mysql.getAllRows("Laboratorio", sqlQuery);

			ArrayList<Cientifico> arrCientificos = new ArrayList<Cientifico>();
			
			rs.next();
			
			// Crear cliente y anadirlo al array
			Cientifico cientifico = new Cientifico(rs.getString("DNI"), rs.getString("Nombre"));
			
			arrCientificos.add(cientifico);
			
			return arrCientificos;
			
		} catch (Exception e) {
			System.out.println("Fallo mostrar registros");

			return new ArrayList<Cientifico>();
		}

	}

	public static void update(Cientifico cientificos) {

		try {
			String sqlQuery = "UPDATE cientificos SET (DNI, Nombre) WHERE ID = "
					+ cientificos.getDNI() + cientificos.getNombre() +";";
			mysql.insertQuery("Laboratorio", sqlQuery);

		} catch (Exception e) {
			System.out.println("Fallo Update modelo cliente");
		}

	}
	
	public Cientifico mostrarPorId(String DNI) {
		
		Cientifico cientifico = new Cientifico();
		ResultSet rs = mysql.getByDni("cientificos", DNI);
	
		try {
			rs.next();
			cientifico.setNombre(rs.getString("Nombre"));
			cientifico.setDNI(rs.getString("DNI"));
			
	
			return cientifico;
		} catch (SQLException e) {
	
			System.out.println("Fallo modelo cientificos al buscar por id");
			System.out.println(e);
			
			return new Cientifico();
		}
	
	
	}
	
	public Cientifico mostrarPorDNI(String DNI) {
		
		Cientifico cientifico = new Cientifico();
		ResultSet rs = mysql.getByDni("cientificos", DNI);
	
		try {
			rs.next();
			cientifico.setNombre(rs.getString("Nombre"));
			cientifico.setDNI(rs.getString("DNI"));
			
	
			return cientifico;
		} catch (SQLException e) {
	
			System.out.println("Fallo modelo cientificos al buscar por DNI");
			System.out.println(e);
			
			return new Cientifico();
		}
	
	
	}

	public void delete(String dni) {
		mysql.deleteRowDni("cientifico", dni);
	}


}
