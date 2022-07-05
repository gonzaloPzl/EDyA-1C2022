import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class anagrama_compareTo {
 
  // Funcion que ordena las letras de una palabra
  public static String[] ordenarLetras(String[] letras)
  {
      // Recorre el arreglo exepto el ultimo, esto es para que no arroje error la comparación con el ultimp
      for(int i = 0; i < letras.length - 1; i++)
      {
          // La j comienza 1 mas para comparar el anterior con el siguoente
          for(int j = i+1; j < letras.length; j++)
          {
              if(letras[i].compareTo(letras[j]) > 0) // Pregunta si el numero es mayor a 0 ya que si es 0 significa que son iguales
              // Si es mayor significa que tiene un peso de unicode mayor, por lo tanto tiene que moverse a la derecha
              {
                  String aux = letras[i]; // Utilizamos el auxiliar para guardar el valor que vamos a cambiar
                  letras[i] = letras[j]; // con estas 2 lineas intercambiamos las posiciones
                  letras[j] = aux; 
              }
          }
      }
      /* Este for en el for compara una posición conta todas las demas para dejar ubicada por lo que tiene que recorrer
        El arreglo una vez por cada letra para dejarla en su lugar */
      return letras;
  }

  // Función que devuelve un arreglo con las letras ordenadas lexicamente
  public static String[] orden(String[] arreglo) {
    String arregloOrdenado[] = new String[arreglo.length];

    for (int i = 0; i < arreglo.length; i++) {
      String palabra = arreglo[i]; // Guarda la palabra
      String caracteres[] = palabra.split(""); // transforma la palbra a un arreglo de letras
      String cadenaOrdenada[] =  ordenarLetras(caracteres); // ordena el arreglo de letras
      
      // System.out.println(Arrays.toString(cadenaOrdenada));
      palabra = String.join("", cadenaOrdenada); // une las letras ordenadas en un string
      // System.out.println(palabra);
      arregloOrdenado[i] = palabra;

    }
    return arregloOrdenado;
  }
  
  public static String[] anagramas_maximas(String[] arreglo) {
    String anagramas[] = new String[0];
    int n = anagramas.length;
    int count = 0; // iniciamos contador
    int indiceOrdenado = 0; // Declaramos un indice para recorrer 
    int count_max = 0; // Declaramos un contador para el que tenga las máximas apariciones
    String anagramaMax = "";
    String arregloOrdenado[] = orden(arreglo); // guardamos el arreglo con las palabras ordenadas lexicamente

    while (indiceOrdenado < arregloOrdenado.length) { // hacemos un bucle para recorrer el arreglo 1 vez por cada palabra
      for (int i = 0; i < arregloOrdenado.length; i++) { 
        if (arregloOrdenado[indiceOrdenado].compareTo(arregloOrdenado[i]) == 0){ // usamos el comparateTo para saber si es igual a 0
          count++; // aumentamos el contador si los strings son iguales
        }
      }
      if (count > count_max) { // si el contador termina siendo mayor al contador maximo lo reemplazamos
        count_max = count;
        anagramaMax = arregloOrdenado[indiceOrdenado];
      }
      count = 0; // Reiniciamos el count
      indiceOrdenado++; // aumentamos el indice
    }

    for (int i = 0; i < arregloOrdenado.length; i++) { // 
      if (anagramaMax.compareTo(arregloOrdenado[i]) == 0) { // comparamos los strings y si son iguales aumentamos el arrelo
        anagramas = Arrays.copyOf(anagramas, n + 1);
        anagramas[n] = arreglo[i]; // añadimos en esa posición del arreglo la palabra correspondiente al arreglo original
        n++; // aumentamos el indice
      }
    }
    return anagramas;
  }
  public static void main (String[]args) throws Exception {
    File txt = new File("C:\\test.txt");
    Scanner in = new Scanner(txt);
    String[] arr = new String[0];
    
    int n = 0;

    while (in.hasNextLine()) { 
      String palabra = in.nextLine(); 
      arr = Arrays.copyOf(arr, n + 1);
      arr[n] = palabra; 
      n++;
    }
    
    String anagramas_maximas_apariciones[] = anagramas_maximas(arr);
    String arreglo_ordenado[] = orden(arr);

    System.out.println("Arreglo de palabras");
    System.out.println(Arrays.toString(arr));
    
    System.out.println(" ");
    
    System.out.println("Arreglo de palabras ordenadas lexicamente");
    System.out.println(Arrays.toString(arreglo_ordenado));

    System.out.println(" ");
     
    System.out.println("Anagramas con maximas apariciones");
    System.out.println(Arrays.toString(anagramas_maximas_apariciones));

  }
}