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
}