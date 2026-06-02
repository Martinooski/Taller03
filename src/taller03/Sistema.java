package taller03;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Hechizo> listaHechizos;
    private Lector lector;
    private ArrayList<Mago> listaMagos;
    
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
}
