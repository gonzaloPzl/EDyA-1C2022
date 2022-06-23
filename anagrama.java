
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



    String cadena = "roma";

    int ascii[] = stringToAscii(cadena);

    System.out.println(Arrays.toString(ascii));

    // char[] arra = cadena.toCharArray();
    // int[] cadena_ascii = new int[1];
    // int num = arra[0];
    // cadena_ascii[0] = num;
    // System.out.println(Arrays.toString(arra));
    // char paso = 104;
    // System.out.println(paso);
    // int n1 = 0;
    // int vectorOrdenado[] = quicksort(vector1, 0, vector1.length - 1);
    // System.out.println(Arrays.toString(vectorOrdenado));

    // for (int i = 0;  i < arra.length; i++) {
    //   int parseo = arra[i];
    //   cadena_ascii = Arrays.copyOf(cadena_ascii, n1 + 1);
    //   cadena_ascii[n1] = parseo;
    //   n1++;
    // }
    // System.out.println("Arreglo desordenado"+ Arrays.toString(cadena_ascii));
    // aplico quicksort para ordenar el arreglo
    // int arregloOrdenado[] = quicksort(cadena_ascii, 0, cadena_ascii.length -1);
    // System.out.println("Arreglo desordenado"+ Arrays.toString(arregloOrdenado));
  } 
}