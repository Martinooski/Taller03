package taller03;

public class Menu {
	
	
	public static void mostrarMenuInicial() {
		
		System.out.println("\n============");
		System.out.println("  Bienvenido  ");
		System.out.println("==============");
		System.out.println("1) Panel Administrador");
		System.out.println("2) Panel Analista");
		System.out.println("3) Salir");
		System.out.print("Ingrese Opcion: ");
		
	}
	
	public static void mostrarMenuAdministrador() {
		
		System.out.println("1) Agregar Mago");
		System.out.println("2) Modificar Mago");
		System.out.println("3) Eliminar Mago");
		System.out.println("4) Agregar Hechizo");
		System.out.println("5) Modificar Hechizo");
		System.out.println("6) Eliminar Hechizo");
		System.out.println("7) Salir");
		System.out.print("Ingrese Opcion: ");
		
	}
	
	public static void mostrarMenuAnalista() {
		
		System.out.println("1) Top 10 Mejores Hechizos");
		System.out.println("2) Top 3 Mejores Magos");
		System.out.println("3) Mostrar todos los Hechizos");
		System.out.println("4) Mostrar todos los magos");
		System.out.println("5) Mostrar todos los Hechizos junto a su puntuacion");
		System.out.println("6) Mostrar todos los magos junto a su puntuacion");
		System.out.println("7) Salir");
		System.out.print("Ingrese Opcion: ");
		
	}
}
