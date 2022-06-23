
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class anagrama {
  // Método de ordenamiento
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
    for (int i = 0; i < arreglo.length; i++){
      int arregloAscii[] = stringToAscii(arreglo[i]);
      arregloDeArreglosInt[i] = arregloAscii;
    }
    return arregloDeArreglosInt;
  }

  public static String asciiToString (int[] arreglo) {
    char arregloToChar[] = new char[arreglo.length];
    for (int i = 0; i < arreglo.length; i++) {
      char intToChar = (char) arreglo[i];
      arregloToChar[i] = intToChar;
    }
    return String.valueOf(arregloToChar);

  }
  
  public static int[][] arregloOrdenado (int[][] arreglo) {
    int arregloDeAsciiOrdenado[][] = new int[arreglo.length][];
    for (int i = 0; i < arreglo.length; i++) {
      int arregloOrdenado[] = quicksort(arreglo[i], 0, arreglo[i].length - 1);
      arregloDeAsciiOrdenado[i] = arregloOrdenado;
    }
    return arregloDeAsciiOrdenado;
  }

  public static int[] arregloMaximasApariciones (int[][] arregloOrdenado) {
    int count = 0;
    int indiceOrdenado = 0; // Declaramos un indice 
    int count_max = 0;
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

      count = 0;
      indiceOrdenado++;
    }
    return arregloMax;
  }

  public static String[] arregloAnagramas (int[][] arreglo,int[][] arregloOrdenado, int[] arregloComparador) {
    // System.out.println(Arrays.deepToString(arreglo));
    // System.out.println(Arrays.deepToString(arregloOrdenado));
    String arregloDeAnagramas[] = new String[0];
    int n = arregloDeAnagramas.length;
    for (int i = 0; i < arreglo.length; i++) {
      if (Arrays.equals(arregloComparador, arregloOrdenado[i])) {
        arregloDeAnagramas = Arrays.copyOf(arregloDeAnagramas, n + 1);
        arregloDeAnagramas[n] = asciiToString(arreglo[i]);
        // System.out.println(Arrays.toString(arreglo[i]));
        n++;
      }
    }

    return arregloDeAnagramas;
  }

  public static void main(String[]args) throws Exception 
  {
    File txt = new File("C:\\test.txt");
    Scanner in = new Scanner(txt);
    String[] arr = new String[0];

    int n = arr.length; // Esta variable representa la cantidad de valores que contiene
    // el arrego

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


    int arregloDeAscii[][] = arregloStringToAscii(arr); // Arreglo bidimensional 
    

    // System.out.println(Arrays.toString(arregloMax));
    String maxAnagramas[] = arregloAnagramas(arregloDeAscii, arregloOrdenado(arregloStringToAscii(arr)), arregloMaximasApariciones(arregloOrdenado(arregloStringToAscii(arr))));
    System.out.println(Arrays.toString(maxAnagramas));

  } 
}

// [ [[9,3,17],[3,9,17]],[[17,3,9],[3,9,17]] ]