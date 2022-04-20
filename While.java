public class While {
  public static void main (String [] args) {
    int i = 1; // iniciamos la variable i que va a ser nuestro contador
    while ( i <= 10 ) { // esta es la condición que nos marca las repeticiones
      // que va a tener el bucle
      System.out.println(i); // mostramos en la terminal la variable i
      i++; // aumentamos el contador en 1 por cada bucle
    }
  }
}