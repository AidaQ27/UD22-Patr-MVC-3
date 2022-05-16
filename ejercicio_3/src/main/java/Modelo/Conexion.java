package Modelo;

public class Conexion {

	private ConexionMySQL mysql;
	private String sqlQuery;

	public Conexion(ConexionMySQL conexionMySQL) {
		this.mysql = new ConexionMySQL();
	}

	public void conectar() {

		/* Conectar a mysql server */

		mysql.conectar();
	}

	public void crearTablaCientifico() {

		/* Crear base de datos Cientifico */

		mysql.createDB("Laboratorio");

		/* Crear tabla cientifico */

		sqlQuery = "CREATE TABLE cientifico (" + "DNI VARCHAR(10) PRIMARY KEY NOT NULL,"
				+ "Nombre VARCHAR(100) DEFAULT NULL);";

		mysql.insertQuery("Laboratorio", sqlQuery);

	}

	public void crearTablaProyecto() {

		/* Crear tabla proyecto */

		sqlQuery = "CREATE TABLE proyecto(" + "ID CHAR(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,"
				+ "Nombre VARCHAR(100) DEFAULT NULL ," + "Horas INT(11) DEFAULT NULL);";
				
		mysql.insertQuery("Laboratorio", sqlQuery);
	}

	public void crearTablaAsignado() {
		
		/*Crear tabla asignado */
		
		sqlQuery = "CREATE TABLE asignado("	
				+ "ID_ASIGNADO CHAR(10) PRIMARY KEY, "
				+ "ID_CIENTIFICO VARCHAR(8),"
				+ "KEY (ID_CIENTIFICO),"
				+ "FOREIGN KEY (ID_CIENTIFICO) REFERENCES CIENTIFICOS(DNI) "
				+ "ON DELETE CASCADE ON UPDATE CASCADE, "
				+ "ID_PROYECTO INT,"
				+ "KEY (ID_PROYECTO),"
				+ "FOREIGN KEY (ID_PROYECTO) REFERENCES PROYECTO(ID)  "
				+ "ON DELETE CASCADE ON UPDATE CASCADE)";

		mysql.insertQuery("Laboratorio", sqlQuery);
	}
		

	 /* Insertar registros en la tabla cientificos */
	
	public void insertarRegistrosCientificos() {
		
		sqlQuery = "INSERT INTO cientifico(DNI, Nombre) VALUE"
				+ "(\"39562548\",\"Manolo\"),"
				+ "(\"39562525\",\"Maria\"),"
				+ "(\"39562501\",\"Juan\"),"
				+ "(\"39183948\",\"Belen\"),"
				+ "(\"39192398\",\"Azucena\",);";
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

}
