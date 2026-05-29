package taller03;

public class HechizoTierra extends Hechizo {

	private int mejoraDefensa;
	
	
	public HechizoTierra(String nombrehechizo, String tipo, int daño, int mejoraDefensa) {
		super(nombrehechizo, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() {
		return mejoraDefensa;
	}

	public void setMejoraDefensa(int mejoraDefensa) {
		this.mejoraDefensa = mejoraDefensa;
	}

	public double calcularPuntaje() {
		return getDaño() * mejoraDefensa / 2;
	}

	@Override
	public String toString() {
		return getNombrehechizo() + " | " + getTipo() + " | Daño: " + getDaño() + " | Mejor Defensa: " + mejoraDefensa;
	}
	
	
}
