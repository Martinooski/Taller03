package taller03;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Hechizo> listaHechizos;
    private Lector lector;
    
    public Sistema() {
        lector = new Lector();
        listaHechizos = lector.leerHechizos(); 

    }
    
    public void mostrarHechizos() {
    	for (Hechizo h : listaHechizos) {
    		System.out.println(h.toString());
    	}
    }
}