package Modelo;

public class Conexion {

	private ConexionMySQL mysql;
	private String sqlQuery;

	public Conexion(ConexionMySQL conexionMySQL) {
		this.mysql = conexionMySQL;
	}


	public void crearTablaCientifico() {

		
		/* Crear tabla cientifico */

		sqlQuery = "CREATE TABLE IF NOT EXISTS cientifico (" + "DNI VARCHAR(10) PRIMARY KEY NOT NULL,"
				+ "Nombre VARCHAR(100) DEFAULT NULL);";

		mysql.insertQuery("Laboratorio", sqlQuery);

	}

	public void crearTablaProyecto() {

		/* Crear tabla proyecto */

		sqlQuery = "CREATE TABLE IF NOT EXISTS proyecto(" + "ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "Nombre VARCHAR(100) DEFAULT NULL ," + "Horas INT(11) DEFAULT NULL);";
				
		mysql.insertQuery("Laboratorio", sqlQuery);
	}

	public void crearTablaAsignado() {
		
		/*Crear tabla asignado */
		
		sqlQuery = "CREATE TABLE asignado("	
				+ "ID_ASIGNADO INT(11) PRIMARY KEY AUTO_INCREMENT, "
				+ "ID_CIENTIFICO VARCHAR(8),"
				+ "KEY (ID_CIENTIFICO),"
				+ "FOREIGN KEY (ID_CIENTIFICO) REFERENCES cientifico(DNI) "
				+ "ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "ID_PROYECTO INT,"
				+ "KEY (ID_PROYECTO),"
				+ "FOREIGN KEY (ID_PROYECTO) REFERENCES proyecto(ID)  "
				+ "ON DELETE CASCADE ON UPDATE CASCADE)";

		mysql.insertQuery("Laboratorio", sqlQuery);
	}
		

	 /* Insertar registros en la tabla cientificos */
	
	public void insertarRegistrosCientificos() {
		
		sqlQuery = "INSERT INTO cientifico (DNI, Nombre) VALUE"
				+ "(\"39562548\",\"Manolo\"),"
				+ "(\"39562525\",\"Maria\"),"
				+ "(\"39562501\",\"Juan\"),"
				+ "(\"39183948\",\"Belen\"),"
				+ "(\"39192398\",\"Azucena\");";
		mysql.insertQuery("Laboratorio", sqlQuery);
	}
	
	

	 /* Insertar registros en la tabla videos */

	public void insertarRegistrosProyecto() {
		
		sqlQuery = "INSERT INTO proyecto (Nombre, Horas) VALUE" 
		+ "(\"XPA\",250),"
		+ "(\"FET\",100),"
		+ "(\"XXA\",270),"
		+ "(\"YWA\",100),"
		+ "(\"REST\",215);";
		mysql.insertQuery("Laboratorio", sqlQuery);
	}
	
	
	public void insertarRegistrosAsignado() {
		
		sqlQuery = "INSERT INTO asignado (ID_ASIGNADO, ID_CIENTIFICO, ID_PROYECTO) VALUE" 
				+ "(\"39562548\",1),"
				+ "(\"39562525\",2),"
				+ "(\"39183948\",3);";
				
				mysql.insertQuery("Laboratorio", sqlQuery);
		
	}

}
