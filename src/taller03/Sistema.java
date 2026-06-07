package taller03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    
    
    public void ordenamientoBurbujaHechizos() {
    	int n = listaHechizos.size();
    	for (int i = 0; i < n - 1; i++) {
    		for (int j = 0; j < n - i - 1; j++) {
    			if (listaHechizos.get(j).calcularPuntaje() < listaHechizos.get(j + 1).calcularPuntaje()) {
    				
    				Hechizo aux = listaHechizos.get(j);
    				listaHechizos.set(j, listaHechizos.get(j + 1));
    				listaHechizos.set(j + 1, aux);
    				
    			}
    		}
    	}
    }
    
    public void mostrarTop10() {


        if (listaHechizos.size() < 10) {
            limite = listaHechizos.size();
        } else {
            limite = 10;
        }

        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + listaHechizos.get(i).getNombrehechizo() + " -> Puntaje: " + listaHechizos.get(i).calcularPuntaje());
        }
    }

    public void mostrarMagosYPuntaje() {
        for (Mago m : listaMagos) {
            System.out.println(m.getNombreMago() + " | Puntaje: " + m.calcularPuntaje());
        }
    }
    
    public void mostrarTop3() {


        if (listaMagos.size() < 3) {
            limite = listaMagos.size();
        } else {
            limite = 3;
        }

        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + listaMagos.get(i).getNombreMago() + " -> Puntaje: " + listaMagos.get(i).calcularPuntaje());
        }
    }
    
    public void guardarMagos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Magos.txt"));
            for (Mago m : listaMagos) {
                String linea = m.getNombreMago() + ";";
                ArrayList<Hechizo> hechizos = m.getHechizos();
                for (int i = 0; i < hechizos.size(); i++) {
                    linea += hechizos.get(i).getNombrehechizo();
                    if (i < hechizos.size() - 1) {
                        linea += "|";
                    }
                }
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
 
    
    public void agregarMago(String nombre) {

    	
        for (Mago m : listaMagos) {
            if (m.getNombreMago().equalsIgnoreCase(nombre)) {
                System.out.println("Ya existe");
                return;
            }
        }
        listaMagos.add(new Mago(nombre));
        guardarMagos();
        System.out.println("Mago agregado correctamente");
    }
 
    public void eliminarMago(String nombre) {
        Mago aEliminar = null;
        for (Mago m : listaMagos) {
            if (m.getNombreMago().equalsIgnoreCase(nombre)) {
                aEliminar = m;
                break;
            }
        }
        if (aEliminar != null) {
            listaMagos.remove(aEliminar);
            guardarMagos();
            System.out.println("Mago eliminado correctamente");
        } else {
            System.out.println("No se encontró un mago con ese nombre");
        }
    }
 
    public void modificarNombreMago(String nombreActual, String nuevoNombre) {
        for (Mago m : listaMagos) {
            if (m.getNombreMago().equalsIgnoreCase(nombreActual)) {
                m.setNombreMago(nuevoNombre);
                guardarMagos();
                System.out.println("Nombre modificado correctamente");
                return;
            }
        }
        System.out.println("No se encontró un mago con ese nombre");
    }
    
    public void agregarHechizo(Hechizo hechizo) {
        for (Hechizo h : listaHechizos) {
            if (h.getNombrehechizo().equalsIgnoreCase(hechizo.getNombrehechizo())) {
                System.out.println("Ya existe un hechizo con ese nombre.");
                return;
            }
        }
        listaHechizos.add(hechizo);
        guardarHechizos();
        System.out.println("Hechizo agregado correctamente.");
    }
 
    public void eliminarHechizo(String nombre) {
        Hechizo aEliminar = null;
        for (Hechizo h : listaHechizos) {
            if (h.getNombrehechizo().equalsIgnoreCase(nombre)) {
                aEliminar = h;
                break;
            }
        }
        if (aEliminar != null) {
            for (Mago m : listaMagos) {
                m.getHechizos().remove(aEliminar);
            }
            listaHechizos.remove(aEliminar);
            guardarHechizos();
            guardarMagos();
            System.out.println("Hechizo eliminado correctamente.");
        } else {
            System.out.println("No se encontró un hechizo con ese nombre.");
        }
    }
 
    public void modificarDañoHechizo(String nombre, int nuevoDaño) {
        for (Hechizo h : listaHechizos) {
            if (h.getNombrehechizo().equalsIgnoreCase(nombre)) {
                h.setDaño(nuevoDaño);
                guardarHechizos();
                System.out.println("Hechizo modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un hechizo con ese nombre.");
    }
    
    public Hechizo buscarHechizoPorNombre(String nombre) {
        for (Hechizo h : listaHechizos) {
            if (h.getNombrehechizo().equalsIgnoreCase(nombre)) {
                return h;
            }
        }
        return null;
    }
 
    public Mago buscarMagoPorNombre(String nombre) {
        for (Mago m : listaMagos) {
            if (m.getNombreMago().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }
    
    public void guardarHechizos() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Hechizos.txt"));
            for (Hechizo h : listaHechizos) {
                String linea = "";
                if (h instanceof HechizoFuego) {
                    HechizoFuego hf = (HechizoFuego) h;
                    linea = hf.getNombrehechizo() + ";" + hf.getTipo() + ";" + hf.getDaño() + ";" + hf.getDuracionQuemadura();
                } else if (h instanceof HechizoTierra) {
                    HechizoTierra ht = (HechizoTierra) h;
                    linea = ht.getNombrehechizo() + ";" + ht.getTipo() + ";" + ht.getDaño() + ";" + ht.getMejoraDefensa();
                } else if (h instanceof HechizoAgua) {
                    HechizoAgua ha = (HechizoAgua) h;
                    linea = ha.getNombrehechizo() + ";" + ha.getTipo() + ";" + ha.getDaño() + ";" + ha.getCantidadHeal() + "," + ha.getPresionDelAgua();
                } else if (h instanceof HechizoPlanta) {
                    HechizoPlanta hp = (HechizoPlanta) h;
                    linea = hp.getNombrehechizo() + ";" + hp.getTipo() + ";" + hp.getDaño() + ";" + hp.getDuracionStun() + "," + hp.getCantPlantas();
                }
                bw.write(linea);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar hechizos: " + e.getMessage());
        }
    }
    

    
    
}




