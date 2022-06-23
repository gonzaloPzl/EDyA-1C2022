
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class anagrama {

  public static void main(String[]args) throws Exception 
  {
    File txt = new File("C:\\test.txt");
    Scanner in = new Scanner(txt);
    String[] arr = new String[2];
    arr[0] = "Esto";
    arr[1] = "Es";

    int n = arr.length; // Esta variable representa el inice
    System.out.println(n);   
    // System.out.println(Arrays.toString(arr));

    while (in.hasNextLine()) {
      String palabra = in.nextLine();
      // System.out.println(in.nextLine());
      arr = Arrays.copyOf(arr, n + 1);
      arr[n] = palabra;
      System.out.println(palabra);
      n++;
    }

    System.out.println(Arrays.toString(arr));
  } 
}