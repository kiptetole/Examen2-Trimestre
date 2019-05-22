package negocio;

/**
 * Clase Cuadrado que hereda de la clase Rectangulo y ademas añade tiene un metodo mas
 *  - Comparar Cuadrados- Esto recoje por parametro un obejo aparte y compara los lados
 *  de un cuadrado para determinar cual es mas grande.
 * 
 * @author Jose Notario Millan
 */
public class Cuadrado extends Rectangulo {

  public Cuadrado(int lado) {
    super(lado, lado);
  }

}
