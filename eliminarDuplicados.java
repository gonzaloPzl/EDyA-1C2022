import java.util.Arrays;

class eliminarDuplicados {
  public static int[] quicksort(int[] arreglo, int primero, int ultimo ){
    int i,j,pivote,aux; //Inicializamos las variables
    i = primero; // a la variable i se le asigna el numero inicial que nos viene por parámetro
    j = ultimo; // a la variable j le asignamos el ultimo numero de la lista, que nos viene por parámetro

    pivote = arreglo[(primero + ultimo) / 2]; // Para definir un pivote cualquiera sumamos el primero con el ultimo y lo
    // dividimos por 2

    // Para recorrer el arreglo vamos a incrementar la i y disminuir la j dependiendo el pivote
    do {
      while (arreglo[i] < pivote) {
        i++;
      }
      while (arreglo[j] > pivote) {
        j--;
      }
      // Intercambio de la posición de los numeros para ubicarlos a la izquierda 
      if (i <= j) {
        aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
        i++;
        j--;
      }
    } while (i <= j);

    // Utilización de la recursividad
    if (primero <= j) {
      // Si el primer numero es menor que la j, es decir que no se encuentra a la izquierda
      // volvemos a aplicar la función de ordenamiento pasandole el mismo primer numero
      quicksort(arreglo, primero, j);
    }
    if (i < ultimo) {
      // Si el i es menor que el ultimo indice volvemos a ejecutar el ordenamiento de forma recursiva
      quicksort(arreglo, i, ultimo);
    }
    // Cuando no se cumpla ningun if se retorna el arreglo que ya debe estar ordenado
    return arreglo;
  }
  public static void main (String[] args) {
    // Creamos arreglo y los inicializamos con numeros al azar
    int arrayNums[] = {15,15,15,33,2,42,12,33,15};
    // creamos un arreglo dandole el valor devuelto por el método de quicksort
    // como parámetros le pasamos el array creado, el 0 como inicio del arreglo y el ultimo indice 
    // pasandole el tamaño menos 1
    int arregloOrdenado[] = quicksort(arrayNums, 0, arrayNums.length - 1);
    // Inciamos el nuevo arreglo donde iran los numeros sin repetir con 0 elementos
    int arregloNoRepetido [] = new int[0];
    int n = arregloNoRepetido.length; // iniciaamos con el valor del largo del array un indice para crecer el tamaño
    // Recorremos el arreglo ordenado con un for
    for (int i = 0; i < arregloOrdenado.length; i++) {
      // Vamos a ir comparando el numero siguiente para saber si esta repetido
      if ( i >= 0 && i < arregloOrdenado.length -1) {
        // En casa de no ser el mismo entra en este if
        if (arregloOrdenado[i] != arregloOrdenado[i+1]){
          // Se añade un nuevo espacio al arreglo no repetido sobreescribiendolo
          arregloNoRepetido = Arrays.copyOf(arregloNoRepetido, n+1);
          // en ese indice agregamos el correspondiente
          arregloNoRepetido[n] = arregloOrdenado[i];
          // aumentamos el indice que recorre
          n++;
        }
      }
      // En el caso de ser la última posición se analiza con el anterior numero
      if ( i == arregloOrdenado.length -1) {
        // Si es diferente se realiza el mismo procedimiento
        if(arregloOrdenado[i] != arregloOrdenado[i-1]){
          arregloNoRepetido = Arrays.copyOf(arregloNoRepetido, n+1);
          arregloNoRepetido[n] = arregloOrdenado[i];
          n++;
        }
      }
    }

    // Mostramos los resultados arrojados por los métodos
    System.out.println("Arreglo de numeros " + Arrays.toString(arrayNums));
    System.out.println("Arreglo de numeros ordenados con quicksort " + Arrays.toString(arregloOrdenado));
    System.out.println("Arreglo de numeros no repetidos " + Arrays.toString(arregloNoRepetido));
    System.out.println("Cantidad de numeros sin contar los repetidos " + arregloNoRepetido.length);
  }

}
