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
		            System.out.print("Ingrese nombre del mago: ");
		            String nombre = scanner.nextLine();
		            sistema.agregarMago(nombre);

		            System.out.print("¿Desea agregar hechizos? (s/n): ");
		            String resp = scanner.nextLine();

		            if (resp.equals("s")) {
		                String seguir = "s";
		                while (seguir.equals("s")) {
		                    System.out.print("Ingrese nombre del hechizo a agregar: ");
		                    String nombreHechizo = scanner.nextLine();
		                    
		                   
		                    Hechizo hechizo = sistema.buscarHechizoPorNombre(nombreHechizo);
		                    
		                    if (hechizo != null) {
		                        sistema.buscarMagoPorNombre(nombre).agregarHechizo(hechizo);
		                        System.out.println("Hechizo agregado.");
		                    } else {
		                        System.out.println("No se encontró ese hechizo.");
		                    }
		                    
		                    System.out.print("¿Agregar otro hechizo? (s/n): ");
		                    seguir = scanner.nextLine();
		                }
		                sistema.guardarMagos(); 
		            }
		            break;
		        case "2":
		            System.out.print("Ingrese nombre actual del mago: ");
		            String nombreActual = scanner.nextLine();
		            System.out.print("Ingrese nuevo nombre: ");
		            String nuevoNombre = scanner.nextLine();
		            sistema.modificarNombreMago(nombreActual, nuevoNombre);
		            break;
		        case "3":
		            System.out.print("Ingrese nombre del mago a eliminar: ");
		            String nombreEliminar = scanner.nextLine();
		            sistema.eliminarMago(nombreEliminar);
		            break; 
		        case "4":
					System.out.print("Nombre del hechizo: ");
					String nombreH = scanner.nextLine();
					System.out.print("Tipo (Fuego/Tierra/Agua/Planta): ");
					String tipo = scanner.nextLine();
					System.out.print("Daño: ");
					int daño = Integer.parseInt(scanner.nextLine());
 
					if (tipo.equals("FUEGO")) {
						System.out.print("Duración Quemadura: ");
						int dur = Integer.parseInt(scanner.nextLine());
						sistema.agregarHechizo(new HechizoFuego(nombreH, tipo, daño, dur));
					} else if (tipo.equals("TIERRA")) {
						System.out.print("Mejora Defensa: ");
						int def = Integer.parseInt(scanner.nextLine());
						sistema.agregarHechizo(new HechizoTierra(nombreH, tipo, daño, def));
					} else if (tipo.equals("AGUA")) {
						System.out.print("Cantidad Heal: ");
						int heal = Integer.parseInt(scanner.nextLine());
						System.out.print("Presión del Agua: ");
						int presion = Integer.parseInt(scanner.nextLine());
						sistema.agregarHechizo(new HechizoAgua(nombreH, tipo, daño, heal, presion));
					} else if (tipo.equals("PLANTA")) {
						System.out.print("Duración Stun: ");
						int stun = Integer.parseInt(scanner.nextLine());
						System.out.print("Cantidad Plantas: ");
						int plantas = Integer.parseInt(scanner.nextLine());
						sistema.agregarHechizo(new HechizoPlanta(nombreH, tipo, daño, stun, plantas));
					} else {
						System.out.println("Tipo inválido.");
					}
		            break;
		        case "5":
					System.out.print("Ingrese nombre del hechizo a modificar: ");
					String nombreHechizoModificar = scanner.nextLine();
					System.out.print("Ingrese nuevo daño: ");
					int nuevoDaño = Integer.parseInt(scanner.nextLine());
					sistema.modificarDañoHechizo(nombreHechizoModificar, nuevoDaño);
		            break;
		        case "6":
		            System.out.print("Ingrese nombre del hechizo a eliminar: ");
		            String nombreEliminarHechizo = scanner.nextLine();
		            sistema.eliminarHechizo(nombreEliminarHechizo);
		            break;
		        case "7":
		        	System.out.println("Volviendo al menú principal...");
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
		            System.out.println("Top 10 mejores Hechizos : ");
		            sistema.ordenamientoBurbujaHechizos();
		            sistema.mostrarTop10();
		            break;
		        case "2":
		            System.out.println("Top 3 mejores Magos : ");
		            sistema.ordenamientoBurbujaMagos();
		            sistema.mostrarTop3();
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
		        	sistema.mostrarMagosYPuntaje();
		            break;
		        case "7":
		        	System.out.println("Volviendo al menú principal...");
		            break;
		        default:
		            System.out.println("Opcion invalida");
		    }
		    
		} while (!opcion.equals("7"));
		
	}
}
