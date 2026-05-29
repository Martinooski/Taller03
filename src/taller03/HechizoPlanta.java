package taller03;

public class HechizoPlanta extends Hechizo {
	
	private int duracionStun;
	private int cantPlantas;
	
	
	public HechizoPlanta(String nombrehechizo, String tipo, int daño, int duracionStun, int cantPlantas) {
		super(nombrehechizo, tipo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}


	public int getDuracionStun() {
		return duracionStun;
	}


	public void setDuracionStun(int duracionStun) {
		this.duracionStun = duracionStun;
	}


	public int getCantPlantas() {
		return cantPlantas;
	}


	public void setCantPlantas(int cantPlantas) {
		this.cantPlantas = cantPlantas;
	}
	
	public double calcularPuntaje() {
		return getDaño() + (duracionStun * cantPlantas) ;
	}

	@Override
	public String toString() {
		return getNombrehechizo() + " | " + getTipo() + " | Daño: " + getDaño() + " | Duracion Stun: " + duracionStun + " | Cantidad Plantas: " + cantPlantas;
	}

	
	

}
