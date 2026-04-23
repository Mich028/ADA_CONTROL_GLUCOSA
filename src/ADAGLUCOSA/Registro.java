package ADAGLUCOSA;

import java.time.LocalDate;

public class Registro {
	private LocalDate Fecha;
	private int Valor;
	
	public Registro (LocalDate Fecha, int Valor) {
		this.Fecha = Fecha;
		this.Valor = Valor;
		
}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

	@Override
	public String toString() {
		 return "Fecha: " + Fecha + " | Glucosa: " + Valor + " mg/dL";
	}
	

}
