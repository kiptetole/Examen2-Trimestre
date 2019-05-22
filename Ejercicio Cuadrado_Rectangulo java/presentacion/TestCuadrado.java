package presentacion;

import negocio.Cuadrado;
import utiles.Teclado;

/**
 * 
 * @author Jose Notario Millan
 */
public class TestCuadrado {

  public static void main(String[] args) {
    Cuadrado a;
    Cuadrado b;

    do {
      a = new Cuadrado(Teclado.leerEntero("Introduzca el valor del lado del cuadrado a: "));
    } while (a.getAlto()==0);

    do {
      b = new Cuadrado(Teclado.leerEntero("Introduzca el valor del lado del cuadrado a: "));
    } while (b.getAlto()==0);

    
    System.out.println(a);
    
    if (a.equals(b))
      System.out.println("Los cuadrados son iguales.");
    else
      System.out.println("Los cuadrados son distintos.");
    
  }
}
