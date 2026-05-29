package taller03;

public class HechizoFuego extends Hechizo {
	
	private int duracionQuemadura;
	
	
	
	public HechizoFuego(String nombrehechizo, String tipo, int daño, int duracionQuemadura) {
		super(nombrehechizo, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}	
	
	public int getDuracionQuemadura() {
		return duracionQuemadura;
	}

	public void setDuracionQuemadura(int duracionQuemadura) {
		this.duracionQuemadura = duracionQuemadura;
	}

	public double calcularPuntaje() {
		return getDaño() * duracionQuemadura;
	}
	
	@Override
	public String toString() {
	    return getNombrehechizo() + " | " + getTipo() + " | Daño: " + getDaño() + " | Duración Quemadura: " + duracionQuemadura;
	}
}
