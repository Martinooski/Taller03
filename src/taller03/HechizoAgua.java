package taller03;

public class HechizoAgua extends Hechizo {
	
	private int cantidadHeal;
	private int presionDelAgua;
	
	public HechizoAgua(String nombrehechizo, String tipo, int daño, int cantidadHeal, int presionDelAgua) {
		super(nombrehechizo, tipo, daño);
		this.cantidadHeal = cantidadHeal;
		this.presionDelAgua = presionDelAgua;
	}

	public int getCantidadHeal() {
		return cantidadHeal;
	}

	public void setCantidadHeal(int cantidadHeal) {
		this.cantidadHeal = cantidadHeal;
	}

	public int getPresionDelAgua() {
		return presionDelAgua;
	}

	public void setPresionDelAgua(int presionDelAgua) {
		this.presionDelAgua = presionDelAgua;
	}
	
	public double calcularPuntaje() {
		return (getDaño() + cantidadHeal + presionDelAgua) * 2;
	}

	@Override
	public String toString() {
		return getNombrehechizo() + " | " + getTipo() + " | Daño: " + getDaño() + " | Cantidad Heal: " + cantidadHeal + " | Presion del Agua: " + presionDelAgua;
	}
}
