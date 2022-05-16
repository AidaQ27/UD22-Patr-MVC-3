package Modelo;


public class Cientifico {

	private String DNI;
	private String Nombre;
	
	
	public Cientifico() {
		
	}

	public Cientifico(String dni, String nombre) {
		
		DNI = dni;
		Nombre = nombre;
		
	}
	
	//Getters & Setters

	

	public String getNombre() {
		return Nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cientifico [DNI=" + DNI + ", Nombre=" + Nombre + "]";
	}

	

	
	

	
	
}
