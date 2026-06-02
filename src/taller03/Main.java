package taller03;

import java.util.Scanner;

public class Main {

	static Sistema sistema = new Sistema();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Martin Alvarado Lafferte 22.330.833-3 ICCI
		
		String opcion = "";
		
		
		do {
		    Menu.mostrarMenuInicial();
		    System.out.println();
		    opcion = scanner.nextLine();
		    
		    switch (opcion) {
		        case "1":
		        	menuAdministrador();
		            break;
		        case "2":
		        	menuAnalista();
		            break;
		        case "3":
		            System.out.println("Hasta luego!");
		            break;
		        default:
		            System.out.println("Opcion invalida");
		    }
		    
		} while (!opcion.equals("3"));
		
	}

	public static void menuAdministrador() {
		
		String opcion = "";
		do {
			Menu.mostrarMenuAdministrador();
			System.out.println();
		    opcion = scanner.nextLine();
		    switch (opcion) {
		        case "1":
		        	//agregar mago
		            break;
		        case "2":
		        	//modificar mago
		            break;
		        case "3":
		            //eliminar mago
		            break; 
		        case "4":
		        	//agregar hechizo
		            break;
		        case "5":
		        	//modificar hechizo
		            break;
		        case "6":
		            //eliminar hechizo
		            break;
		        case "7":
		            //salir
		            break;
		        default:
		            System.out.println("Opcion invalida");
		    }
		    
		} while (!opcion.equals("7"));
		
	}
	
	
	public static void menuAnalista() {
		
		String opcion = "";
		do {
			Menu.mostrarMenuAnalista();
			System.out.println();
		    opcion = scanner.nextLine();
		    switch (opcion) {
		        case "1":
		        	//top 10 mejores hechizos
		            break;
		        case "2":
		        	//top 3 mejores magos
		            break;
		        case "3":
		        	sistema.mostrarHechizos();
		            break; 
		        case "4":
		        	sistema.mostrarMagos();
		            break;
		        case "5":
		        	sistema.mostrarHechizosYPuntaje();
		            break;
		        case "6":
		            System.out.println("Top 10 mejores Magos : ");
		            sistema.ordenamientoBurbujaMagos();
		            sistema.mostrarTop10();
		            break;
		        case "7":
		            //salir
		            break;
		        default:
		            System.out.println("Opcion invalida");
		    }
		    
		} while (!opcion.equals("7"));
		
	}
}
