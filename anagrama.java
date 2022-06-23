
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class anagrama {
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



  // public static int[] foo(){

  // }
  public static void main(String[]args) throws Exception 
  {
    File txt = new File("C:\\test.txt");
    Scanner in = new Scanner(txt);
    String[] arr = new String[0];

    int n = arr.length; // Esta variable representa el inice
    System.out.println(n);   
    // System.out.println(Arrays.toString(arr));

    while (in.hasNextLine()) {
      String palabra = in.nextLine();
      // System.out.println(in.nextLine());
      arr = Arrays.copyOf(arr, n + 1);
      arr[n] = palabra;
      n++;
    }
    String cadena = "roma";
    char[] arra = cadena.toCharArray();
    int[] cadena_ascii = new int[1];
    int num = arra[0];
    cadena_ascii[0] = num;
    System.out.println(Arrays.toString(arra));
    // char paso = 104;
    // System.out.println(paso);
    int n1 = 0;
    // int vectorOrdenado[] = quicksort(vector1, 0, vector1.length - 1);
    // System.out.println(Arrays.toString(vectorOrdenado));

    for (int i = 0;  i < arra.length; i++) {
      int parseo = arra[i];
      cadena_ascii = Arrays.copyOf(cadena_ascii, n1 + 1);
      cadena_ascii[n1] = parseo;
      n1++;
    }
    System.out.println("Arreglo desordenado"+ Arrays.toString(cadena_ascii));
    // aplico quicksort para ordenar el arreglo
    int arregloOrdenado[] = quicksort(cadena_ascii, 0, cadena_ascii.length -1);
    System.out.println("Arreglo desordenado"+ Arrays.toString(arregloOrdenado));
  } 
}