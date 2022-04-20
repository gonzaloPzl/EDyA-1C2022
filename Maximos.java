import java.util.Scanner; // Importo Scanner para leer lo que ingresa el usuario

public class Maximos {
  
  static void max4 () {
    Scanner leer = new Scanner(System.in); // creo una instania de Scanner
    int max = 0; // Inicializo en 0 la variable max
    int num; // inicializo la variable num
    int cant = 4;
    System.out.println("Ingrese " + cant +  " numeros para saber cual es el mayor");
    for (int i = 1; i <= cant; i++) { // creo un bucle for para el ingreso de datos
      System.out.println("Ingrese un numero, faltan " + ((cant + 1) - i)+ " " + "numero/s"); 
      num = leer.nextInt(); // capturamos el numero ingresado por el usuario
      if (max == 0) { // en la primera vuelta del bucle max siempre va a ser el primer numero
        max = num;
      }
      else if (num > max) { // si el numero es mayor al maximo anterior se reemplaza
        max = num;
      }
      else if (i == cant){ // Si ya se ingresaron todos los numeros se muestra el maximo
        System.out.println("El numero mas grande es " + max);
      }
    }
  }
  static void max5 () {
    Scanner leer = new Scanner(System.in);
    int max = 0; 
    int num; 
    int cant = 5; // modificamos la cantidad de numeros para ingresar 5
    System.out.println("Ingrese " + cant +  " numeros para saber cual es el mayor");
    for (int i = 1; i <= cant; i++) { 
      System.out.println("Ingrese un numero, faltan " + ((cant + 1) - i)+ " " + "numero/s"); 
      num = leer.nextInt(); 
      if (max == 0) {
        max = num;
      }
      else if (num > max) { 
        max = num;
      }
      else if (i == cant){
        System.out.println("El numero mas grande es " + max);
      }
    }
  }
  public static void main (String [] args) {
    Scanner leer = new Scanner(System.in);
    int menu = 0;
    while (menu != 3) {
      System.out.println("Ingrese el numero de la opción que desee ejecutar");
      System.out.println("1. Mayor entre 4 numeros\n2. Mayor entre 5 numeros");
      System.out.println("3. Salir");

      menu = leer.nextInt();

      if (menu == 1) {
        max4();
      }
      else if (menu == 2) {
        max5();
      } else if (menu == 3) {
        break;
      } else {
        System.out.println("El numero ingresado es invalido, ingrese un numero del menu");
      }
    }
  }
}