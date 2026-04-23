package ADAGLUCOSA;

import java.util.ArrayList;

public class Persona {
	private String Nombre;
	private ArrayList<Registro>Registros; 
	
	public Persona (String Nombre) {
		this.Nombre = Nombre;
		this.Registros = new ArrayList<>();
		
}
	public void AgregarRegistro (Registro Registro) {
		Registros.add(Registro);
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	/**
	 * @return the registros
	 */
	public ArrayList<Registro> getRegistros() {
		return Registros;
	}
	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(ArrayList<Registro> registros) {
		Registros = registros;
	}
	public String obtenerHistorial() {
	    String texto = "";

	    for (Registro r : Registros) {
	        texto += r.toString() + "\n";
	    }

	    return texto;
	}
}