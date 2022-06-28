
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class anagrama {

  public static void main(String[]args) throws Exception 
  {
    File txt = new File("C:\\test.txt");
    Scanner in = new Scanner(txt);
    String[] arr = new String[0];

    int n = arr.length; // Esta variable el numero de elementos del arreglo
    System.out.println(n);   
    // System.out.println(Arrays.toString(arr));

    while (in.hasNextLine()) {
      String palabra = in.nextLine();
      // System.out.println(in.nextLine());
      arr = Arrays.copyOf(arr, n + 1); // Se crea un arreglo con una capacidad 1 mayor
      arr[n] = palabra; // Se añade a ese espacio nuevo creado la palabra que nos viene del archivo
      System.out.println(palabra); 
      n++; // Aumentamos el N para añadir un epacio mas en el siguiente bucle
    }

    System.out.println(Arrays.toString(arr));
  } 
}