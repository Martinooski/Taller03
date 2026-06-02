package taller03;


public abstract class Hechizo {
	
	private String nombrehechizo;
	private String tipo;
	private int daño;
	
	
	
	public Hechizo(String nombrehechizo, String tipo, int daño) {
		super();
		this.nombrehechizo = nombrehechizo;
		this.tipo = tipo;
		this.daño = daño;
	}
	
	


	public String getNombrehechizo() {
		return nombrehechizo;
	}




	public void setNombrehechizo(String nombrehechizo) {
		this.nombrehechizo = nombrehechizo;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public int getDaño() {
		return daño;
	}




	public void setDaño(int daño) {
		this.daño = daño;
	}




	public abstract double calcularPuntaje();

}
