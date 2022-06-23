import java.util.Arrays;

class eliminarDuplicados {
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
  public static void main (String[] args) {
    int numList[] = {6,3,5,8,5,15,10,6,3,7,8,6};
    int arregloOrdenado[] = quicksort(numList, 0, numList.length - 1);
    int arregloNoRepetido [] = new int[0];
    int n = arregloNoRepetido.length;
    int numeroActual;
    // System.out.println(Arrays.toString(arregloOrdenado));
    int cantidadNoRepetida = 0;
    for (int i = 0; i < arregloOrdenado.length; i++) {
      if ( i >= 0 && i < arregloOrdenado.length -1) {
        if (arregloOrdenado[i] != arregloOrdenado[i+1]){
          arregloNoRepetido = Arrays.copyOf(arregloNoRepetido, n+1);
          arregloNoRepetido[n] = arregloOrdenado[i];
          n++;
        }
      }
      if ( i == arregloOrdenado.length -1) {
        if(arregloOrdenado[i] != arregloOrdenado[i-1]){
          arregloNoRepetido = Arrays.copyOf(arregloNoRepetido, n+1);
          arregloNoRepetido[n] = arregloOrdenado[i];
          n++;
        }
      }
    }
    // System.out.println(Arrays.toString(arregloOrdenado));
    // System.out.println(Arrays.toString(arregloNoRepetido));

    // Mostramos los resultados arrojados por los métodos
    System.out.println("Arreglo de numeros " + Arrays.toString(numList));
    System.out.println("Arreglo de numeros ordenados con quicksort " + Arrays.toString(arregloOrdenado));
    System.out.println("Arreglo de numeros no repetidos " + Arrays.toString(arregloNoRepetido));
    System.out.println("Cantidad de numeros sin contar los repetidos " + arregloNoRepetido.length);
  }

}



      // if (i == 0 && i != arregloOrdenado.length) {
      //   if (arregloOrdenado[i] != arregloOrdenado[i+1]) {
      //     System.out.println(arregloOrdenado[i]);
      //     cantidadNoRepetida++;
      //   }
      // }
      // if ( i > 0 && i != arregloOrdenado.length -1) {
      //   if (arregloOrdenado[i] != arregloOrdenado[i-1] && arregloOrdenado[i] != arregloOrdenado[i+1]) {
      //     System.out.println(arregloOrdenado[i]);
      //     cantidadNoRepetida++;
      //   }
      // }
      // if (i == arregloOrdenado.length -1) {
        
      //   if (arregloOrdenado[i] != arregloOrdenado[i -1]) {
      //     System.out.println(arregloOrdenado[i]);
      //     cantidadNoRepetida++;
      //   }
      // }