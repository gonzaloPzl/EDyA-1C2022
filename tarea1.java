import java.util.Scanner; // Importamos la clase Scanner para utilizar la función nextInt
// nextInt nos permite ingresar datos del tipo entero a través del teclado


public class tarea1 {
  // creamos el método estatico
  static Boolean noEsBisiesto (int anio) { // de parámetro recibe el año
    // hacemos las validaciones para saber si es un año bisiesto el pasado por parámetro
    if ( (anio % 4 == 0) && ( (anio % 100 != 0) || (anio % 400 == 0) ) ) {
      // en caso de serlo retornamos false
      return false;
    } else {
      // en caso de no serlo retornamos true
      return true;
    }
  }
  public static void main(String [] args) {
    Scanner leer = new Scanner(System.in); // leer va a ser un nuevo objeto Scanner
    // por lo que hereda sus métodos
    System.out.println("Ingrese el año para saber si no es bisiesto"); // Mostramos el mensaje por pantalla
    int anio = leer.nextInt(); // utilizamos el método nextInt para capurar el dato entero
    // ingresado por el usuario

    System.out.println(noEsBisiesto(anio)); // mostramos por pantalla el retorno
    // generado por la ejecución de la función noEsBisiesto
 
  }
}