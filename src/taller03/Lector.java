package taller03;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Lector {
	
	public ArrayList<Hechizo> leerHechizos() {
		
		ArrayList<Hechizo> listaHechizos = new ArrayList<>();
		
	    try {

	        Scanner scanner = new Scanner(new File("Hechizos.txt"));

	        while (scanner.hasNextLine()) {

	            String linea = scanner.nextLine();
	            String[] partes = linea.split(";");
	            String nombrehechizo = partes[0].trim();
	            String tipo = partes[1].trim();
	            int daño = Integer.parseInt(partes[2].trim());
	            String[] extras = partes[3].split(",");
	            
	            if (tipo.equals("Fuego")) {
	            		int duracionQuemaduras = Integer.parseInt(extras[0].trim());
	            		listaHechizos.add(new HechizoFuego(nombrehechizo, tipo, daño, duracionQuemaduras));
	          
	            }
	            
	            else if (tipo.equals("Tierra")) {
	            	int mejorDefensa = Integer.parseInt(extras[0].trim());
	            	listaHechizos.add(new HechizoTierra(nombrehechizo, tipo, daño, mejorDefensa));
	            }
	            
	            else if (tipo.equals("Agua")) {
	            	int cantidadHeal = Integer.parseInt(extras[0].trim());
	            	int presionDelAgua = Integer.parseInt(extras[1].trim());
	            	listaHechizos.add(new HechizoAgua(nombrehechizo, tipo, daño, cantidadHeal, presionDelAgua));
	            }
	            
	            else if (tipo.equals("Planta")) {
	            	int duracionStun = Integer.parseInt(extras[0].trim());
	            	int cantPlantas = Integer.parseInt(extras[1].trim());
	            	listaHechizos.add(new HechizoPlanta(nombrehechizo, tipo, daño, duracionStun, cantPlantas));
	            }
	            
	        }
	        scanner.close();

	    } catch (FileNotFoundException e) {
	    	System.out.println("Error: " + e.getMessage());
	    }
	    
	    return listaHechizos;
	}
	
	
	public ArrayList<Mago> leerMagos(ArrayList<Hechizo> listaHechizos) {
		
		ArrayList<Mago> listaMagos = new ArrayList<>();
		
		try {
			
			Scanner scanner = new Scanner(new File("Magos.txt"));
			
			while (scanner.hasNextLine()) {
				
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				String nombreMago = partes[0].trim();
				String[] hechizosMago = partes[1].split("\\|");
				
				Mago mago = new Mago(nombreMago);
				
				for (int i = 0; i < hechizosMago.length; i++) {
				    String nombreHechizoMago = hechizosMago[i].trim();
				    
				    for (int j = 0; j < listaHechizos.size(); j++) {
				    	if (nombreHechizoMago.equals(listaHechizos.get(j).getNombrehechizo())) {
				    	    mago.agregarHechizo(listaHechizos.get(j));
				    	    break;
				    	}
				    }
				}
				listaMagos.add(mago);
				
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return listaMagos;
	}
}
