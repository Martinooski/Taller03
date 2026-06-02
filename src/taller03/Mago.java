package taller03;

import java.util.ArrayList;

public class Mago implements Puntaje {
	
	private String nombreMago;
	private ArrayList<Hechizo> hechizos;
	
	public Mago(String nombreMago) {
		super();
		this.nombreMago = nombreMago;
		this.hechizos = new ArrayList<>();
	}

	public String getNombreMago() {
		return nombreMago;
	}

	public void setNombreMago(String nombreMago) {
		this.nombreMago = nombreMago;
	}

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}

	public void setHechizos(ArrayList<Hechizo> hechizos) {
		this.hechizos = hechizos;
	}
	
	public void agregarHechizo(Hechizo hechizo) {
	    hechizos.add(hechizo);
	}
	
	
	public double calcularPuntaje() {
		
		double total = 0;
		for (Hechizo h : hechizos) {
			total += h.calcularPuntaje();
		}
		return total;
	}
	
}
