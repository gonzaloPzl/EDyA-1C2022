
// Imports 
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class anagrama {
  // Método de ordenamiento quicksort, igual al primer punto
  public static int[] quicksort(int[] arreglo, int primero, int ultimo ){
    int i,j,pivote,aux;
    i = primero;
    j = ultimo;
    pivote = arreglo[(primero + ultimo) / 2];

    do {
      while (arreglo[i] < pivote) {
        i++;
      }
      while (arreglo[j] > pivote) {
        j--;
      }
      // Intercambio de la posición de los numeros
      if (i <= j) {
        aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
        i++;
        j--;
      }
    } while (i <= j);

    if (primero <= j) {
      quicksort(arreglo, primero, j);
    }
    if (i < ultimo) {
      quicksort(arreglo, i, ultimo);
    }

    return arreglo;
  }

  // Método transformar palabra a arreglo de ascii
  public static int[] stringToAscii(String palabra) { // Recibe la palabra
    // Transforma la palabra en un arreglo de chars separados
    char[] arregoChar = palabra.toCharArray();
    // Crea un arreglo de enteros con el tamaño del arreglo de char
    int[] arregloAscii = new int[arregoChar.length];
    // Hace un ciclo for que se ejecutara tantas veces como el largo del arreglo de char
    for (int i = 0; i < arregoChar.length; i++) {
      // Transformamos el char de la posición i a un entero ASCII
      int charToInt = arregoChar[i];
      // Agregamos ese entero al arreglo de ASCII
      arregloAscii[i] = charToInt;
    }
    return arregloAscii;
  }
  
  // Método para transformar los strings a arreglo de int
  public static int[][] arregloStringToAscii(String[] arreglo) {
    // creamos un array bidimensional que contendrá los códigos ascii ordenables
    int[][] arregloDeArreglosInt = new int[arreglo.length][];
    // hacemos un for para agregar los ASCII
    for (int i = 0; i < arreglo.length; i++){
      // vamos agregando a cada indice la tranformación de la letra a un entero que lo representa en ASCII
      int arregloAscii[] = stringToAscii(arreglo[i]);
      arregloDeArreglosInt[i] = arregloAscii;
    }
    return arregloDeArreglosInt;
  }

  // Método para transformar un entero a un char
  public static String asciiToString (int[] arreglo) {
    // este método nos servirá para volver a transformar los enteros en su simbolo ASCII
    // creamos un arreglo que tendra la palbra en chars por ej -> roma = [r,o,m,a]
    char arregloToChar[] = new char[arreglo.length];
    for (int i = 0; i < arreglo.length; i++) {
      // con (char) hacemos la transformación de ese entero a char ej -> r = 114
      char intToChar = (char) arreglo[i];
      arregloToChar[i] = intToChar;
    }

    return String.valueOf(arregloToChar); // retornamos la transformación del array de chars a string
    // ej -> [r,o,m,a] = roma

  }
  
  // Método que ordena un arreglo bidimensional
  public static int[][] arregloOrdenado (int[][] arreglo) {
    // se crea el arreglo bidimensional donde se irá ordenando
    int arregloDeAsciiOrdenado[][] = new int[arreglo.length][];
    for (int i = 0; i < arreglo.length; i++) {
      // Se consume el método quicksort para ordenar cada arreglo que irá dentro de nuestro arreglo
      int arregloOrdenado[] = quicksort(arreglo[i], 0, arreglo[i].length - 1);
      arregloDeAsciiOrdenado[i] = arregloOrdenado;
    }
    return arregloDeAsciiOrdenado;
  }

  // Método que nos devuelve el arreglo que tenga mayor cantidad de réteticiones
  public static int[] arregloMaximasApariciones (int[][] arregloOrdenado) {
    // recibe el arreglo ya ordenado y con esto podemos saber cuantos se repiten
    int count = 0; // iniciamos contador
    int indiceOrdenado = 0; // Declaramos un indice para recorrer 
    int count_max = 0; // Declaramos un contador para el que tenga las máximas apariciones
    int arregloMax[] = new int[1];
    // Mientras el indice sea menor que el tamaño de arreglo ordenado se ejecuta
    while (indiceOrdenado < arregloOrdenado.length) {

      // Hacemos un for para iterar el arreglo buscando los anagramas
      for (int i = 0; i < arregloOrdenado.length; i++) {
        // Iniciamos el arreglo que se va a comparar
        int arregloAComparar[] = arregloOrdenado[indiceOrdenado];
        
        // Si el arreglo a comparar es igual a otro que apareza aumentamos el contador
        if (Arrays.equals(arregloAComparar, arregloOrdenado[i])) {
          count++;
        }
      }
      // Si ese contador es mayor al contador anterior ahora será el nuevo máximo
      if (count > count_max) {
        count_max = count;
        // Guardamos ese arreglo para tener la referencia
        arregloMax = arregloOrdenado[indiceOrdenado]; // sabemos cual se repite más
      }

      // reseteamos el contador
      count = 0;
      // aumentamos el indice para recorrer
      indiceOrdenado++;
    }
    return arregloMax;
  }

  // Método para devolver el arreglo con los anagramas 
  public static String[] arregloAnagramas (String[] arreglo){
    // Iniciamos el anagrama con 0 espacios para ir creciendolo
    String[] arregloDeAnagramas = new String[0];
    int n = arregloDeAnagramas.length; // El tamaño que va a ir creciendo el arreglo

    /*  Con esta función transformamos el arreglo de strings con las palabras a un arreglo
      de arreglos de numeros ascii que simbolizan las letras */
    int[][] arregloDeArreglosInt = arregloStringToAscii(arreglo); 
    
    // Guardamos los resultados del ordenamiento de cada subarreglo dentro de esta variable
    int arregloDeAsciiOrdenado[][] = arregloOrdenado(arregloStringToAscii(arreglo));

    /*  Obtenemos el ASCII con mayor cantidad de apariciones ejecutando esta función y guardamos
     el resultado dentro de esta variable */
    int asciiMaximasApariciones[] = arregloMaximasApariciones(arregloDeAsciiOrdenado);

    for (int i = 0; i < arregloDeArreglosInt.length; i++) {
      // Si el arreglo comparado es igual al arreglo ordenado se entre, ej -> arreglo comparado [15,25,100,114]
      if (Arrays.equals(asciiMaximasApariciones, arregloDeAsciiOrdenado[i])) {
        // Si son iguales primero aumentamos el tamaño 
        arregloDeAnagramas = Arrays.copyOf(arregloDeAnagramas, n + 1);
        // Y agregamos el arreglo que se encuentre en la misma posición pero dentro del arreglo original
        arregloDeAnagramas[n] = asciiToString(arregloDeArreglosInt[i]);
        // aumentamos el indice de tamaño
        n++;
      }
    }
    return arregloDeAnagramas;
  }

  // PROGRAMA PRINCIPAL
  public static void main(String[]args) throws Exception 
  {
    // Instanceamos el objeto File en la variable txt
    File txt = new File("C:\\test.txt"); // recibe el path del archivo
    Scanner in = new Scanner(txt); // Instanceamos el Scanner que va a leer el archivo instanceado en txt
    String[] arr = new String[0]; // Inciamos un arreglo de strings con valor 0

    int n = arr.length; // Esta variable representa la cantidad de valores que contiene el arrego

    // While que agrega las palabras del txt a un arreglo
    while (in.hasNextLine()) { // Pregunta si hay una siguiente linea, mientras la haya
      // se va a ejecutar el bucle
      String palabra = in.nextLine(); // La palabra va a tener el valor de la linea actual
      // del txt
      arr = Arrays.copyOf(arr, n + 1); // Se crea un array con una cantidad 1 mayor al anterior
      // Y se le asigna los mismo valores solo que tendrá un espacio para uno mas
      arr[n] = palabra; // Se rellena ese espacio pasandole el n que es el tamaño con la palabra
      n++; // Se aumenta la n para en el siguiente bucle se aumente el tamaño del arreglo
    }

    /* Ejecutamos las funciones para lograr el retorno de los anagramas
     con mayor aparición y lo guardamos en la variable */
    String maxAnagramas[] = arregloAnagramas(arr);
    System.out.println("El arreglo de palabras es " + Arrays.toString(arr));
    System.out.println("El arreglo de anagramas con mayores apariciones es " + Arrays.toString(maxAnagramas));

  } 
}
