# Taller 03 - Magos y Hechizos

Este programa simula un mundo de magia por consola, donde un menu administrador puede gestionar magos y hechizos, mientras que un menu analista puede consultar rankings y estadísticas de rendimiento.

### Integrantes
* Martin Alvarado - 22.330.833-3 - [Martinooski]

### Estructura
Lógica centralizada en la clase Sistema.java, utilizando ArrayLists para el almacenamiento en memoria de los hechizos y magos. La clase Lector se encarga de parsear los archivos Hechizos.txt y Magos.txt al inicio del programa. La clase abstracta Hechizo define la estructura base, extendida por HechizoFuego, HechizoTierra, HechizoAgua y HechizoPlanta, cada una con su propia fórmula de puntaje. La clase Mago implementa la interfaz Puntaje y acumula su puntuación sumando la de sus hechizos. La clase Menu muestra los menús por consola y Main coordina los paneles de Administrador y Analista. Los cambios realizados desde el panel Administrador se persisten automáticamente en los archivos .txt mediante BufferedWriter.
