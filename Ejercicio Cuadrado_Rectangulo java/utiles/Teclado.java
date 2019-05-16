package utiles;

import java.util.Scanner;

/**
 * Permite lectura desde teclado
 */
public class Teclado {
  static Scanner s = new Scanner(System.in);

  /**
   * Lee un carácter del teclado
   * 
   * @return carácter introducido por el usuario
   */
  public static char leerCaracter() {
    char caracter;
    try {
      caracter = leerCadena().charAt(0);
    } catch (Exception e) {
      caracter = 0;
    }
    return caracter;
  }

  /**
   * Lee un carácter del teclado
   * 
   * @param msj
   *          mensaje mostrado al usuario
   * @return carácter introducido por el usuario
   */
  public static char leerCaracter(String msj) {
    System.out.println(msj);
    return leerCaracter();
  }

  /**
   * Lee una cadena del teclado
   * 
   * @param msj
   *          mensaje mostrado al usuario
   * @return cadena introducida por el usuario
   */
  public static String leerCadena(String msj) {
    System.out.println(msj);
    return leerCadena();
  }

  /**
   * Muestra un mensaje y devuelve una cadena
   * 
   * @return
   */
  public static String leerCadena() {
    return s.nextLine();
  }

  /**
   * Lee un entero del teclado
   * 
   * 
   * @return entero introducido por el usuario
   */
  public static int leerEntero() {
    do {
      try {
        return Integer.parseInt(leerCadena().trim());
      } catch (NumberFormatException e) {
        System.err.println("Formato de numero invalido.");
      }
    } while (true);
  }

  /**
   * Lee una entero del teclado
   * 
   * @param msj
   *          mensaje mostrado al usuario
   * @return entero introducida por el usuario
   */
  public static int leerEntero(String msj) {
    System.out.println(msj);
    return leerEntero();
  }

  /**
   * Lee un decimal del teclado
   * 
   * @return decimal introducido por el usuario
   */
  public static double leerDecimal() {
    do {
      try {
        return Double.parseDouble(leerCadena().trim());
      } catch (NumberFormatException e) {
        System.err.println("Formato de numero invalido.");
      }
    } while (true);
  }

  /**
   * Lee una decimal del teclado
   * 
   * @param msj
   *          mensaje mostrado al usuario
   * @return decimal introducida por el usuario
   */
  public static double leerDecimal(String msj) {
    System.out.println(msj);
    return leerDecimal();
  }

}