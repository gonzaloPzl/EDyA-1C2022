public class tarea3 {

  public static void resize (int [ ] arr){
    int [] old = arr;
    arr = new int[ old.length * 2 + 1 ];

    for ( int i = 0; i < old.length; i++ ) {
      arr[i] = old[i];
    }
  }

  public static int foo () {
    try {
      return 0;
    }
    finally {
      return 1;
    }
  }
  public static void bar () {
    try 
    {
      throw new NullPointerException();
    } catch (NullPointerException e) {
      System.out.println(e);
    }
    finally 
    {
      try {
        throw new ArithmeticException();
      } catch (ArithmeticException e) {
        System.out.println(e);
      }
    } 

  }

  public static void main (String[] args) {
    System.out.println(foo());
    bar();
  }
}
