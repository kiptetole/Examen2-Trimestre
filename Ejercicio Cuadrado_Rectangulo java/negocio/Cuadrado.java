package negocio;

/**
 * Clase Cuadrado que hereda de la clase Rectangulo y ademas añade tiene un metodo mas
 *  - Comparar Cuadrados- Esto recoje por parametro un obejo aparte y compara los lados
 *  de un cuadrado para determinar cual es mas grande.
 * 
 * @author Jose Notario Millan
 */
public class Cuadrado extends Rectangulo implements Comparable<Cuadrado> {

  // Constructor
  public Cuadrado(int lado) {
    super(lado, lado);
  } 

  /**
   * Método para devolver el lado
   * @return lado
   */
  public int getLado() {
    return this.getAncho();
  }

  /**
   * Método para modificar el lado
   * @param lado
   */
  public void setLado(int lado) {
    super.setAncho(lado);
    super.setAlto(lado);
  }
  
  @Override
  public boolean equals(Object obj) { 
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cuadrado other = (Cuadrado) obj;
    if (getLado() != other.getLado())
      return false;
    if (getLado() != other.getLado())
      return false;
    return true; 
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + getLado();
    result = prime * result + getLado();
    return result;
  }
  
  @Override
  public int compareTo(Cuadrado o) {
    if (alto == o.getAlto())
      return 0;

    if (alto > o.getAlto())
      return 1;
    
    return -1;
  
  }
}