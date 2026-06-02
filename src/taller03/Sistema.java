package taller03;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Hechizo> listaHechizos;
    private Lector lector;
    private ArrayList<Mago> listaMagos;
    private int limite;
    
    public Sistema() {
        lector = new Lector();
        listaHechizos = lector.leerHechizos(); 
        listaMagos = lector.leerMagos(listaHechizos);

    }
    
    public void mostrarHechizos() {
        for (Hechizo h : listaHechizos) {
            System.out.println(h.toStringSimple());
        }
    }
    
    public void mostrarMagos() {
    	for (Mago m : listaMagos) {
    		System.out.println(m.getNombreMago());
    		for (Hechizo h : m.getHechizos()) {
    			System.out.println(" -" + h.getNombrehechizo());
    		}
    	}
    }
    
    public void mostrarHechizosYPuntaje() {
    	for (Hechizo h : listaHechizos) {
    		
    		System.out.println(h.toString());
    	}
    }
    
    public void ordenamientoBurbujaMagos() {
    	int n = listaMagos.size();
    	for (int i = 0; i < n - 1; i++) {
    		for (int j = 0; j < n - i - 1; j++) {
    			if (listaMagos.get(j).calcularPuntaje() < listaMagos.get(j + 1).calcularPuntaje()) {
    				
    				Mago aux = listaMagos.get(j);
    				listaMagos.set(j, listaMagos.get(j + 1));
    				listaMagos.set(j + 1, aux);
    				
    			}
    		}
    	}
    }
    
    public void mostrarTop10() {


        if (listaMagos.size() < 10) {
            limite = listaMagos.size();
        } else {
            limite = 10;
        }

        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + listaMagos.get(i).getNombreMago() + " -> Puntaje: " + listaMagos.get(i).calcularPuntaje());
        }
    }
}
