package presentacion;

import negocio.Rectangulo;
import utiles.Teclado;

/**
 * Esta clase es para probar la clase Rectangulo
 * 
 * @author Jose Notario Millan
 */
public class TestRectangulo {

  public static void main(String[] args) {
    Rectangulo a = null;
    
    do {
    try {
      a = new Rectangulo(Teclado.leerEntero("Introduzca la altura del rectangulo: "),
          Teclado.leerEntero("Introduzca el ancho del rectangulo: "));
    } catch (ArithmeticException e) {
      System.err.println(e.getMessage());
    }
    }while(a.getAlto()==0 || a.getAncho()==0);
    
    System.out.println(a);

  }

}
