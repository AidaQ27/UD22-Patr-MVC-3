package Modelo;

import java.sql.Date;

public class Proyecto {

	private Long ID;
	private String Nombre;
	private String Horas;

	
	public Proyecto() {
		
	}

	public Proyecto(Long iD, String nombre, String horas) {
		
		ID = iD;
		Nombre = nombre;
		Horas = horas;
	}
	
	//Getters & Setters

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getHoras() {
		return Horas;
	}

	public void setHoras(String horas) {
		Horas = horas;
	}

	@Override
	public String toString() {
		return "Proyecto [ID=" + ID + ", Nombre=" + Nombre + ", Horas=" + Horas + "]";
	}

	
	
}
