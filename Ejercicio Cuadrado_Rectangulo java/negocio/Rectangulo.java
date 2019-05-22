package negocio;

/**
 * Esta es la clase Rectangulo donde va a tener en cuenta: Campos: - Ancho:
 * valor de la base del rectangulo - Alto: Valor de la altura del rectangulo.
 * 
 * Metodos: 
 *  - Getters y setters: Respectivamente de cada campo. 
 *  - Dibuja : Este metodo devuelve la cadena de caracteres que representa graficamente
 *      el cuadrado.
 * 
 * @author Jose Notario Millan.
 */
public class Rectangulo {

  private int ancho;
  private int alto;

  public Rectangulo(int alto, int ancho) {
    
    setAlto(alto);
    setAncho(ancho);

  }

  /**
   * Asigna el valor del ancho del rectangulo.
   * 
   * @param ancho
   */
  private void setAncho(int ancho) throws ArithmeticException {
    if (ancho <= 0 || ancho > 10)
      throw new ArithmeticException("EL ancho no puede ser negativo, ni sobrepasar 10");
    this.ancho = ancho;
  }

  /**
   * devuelve el valor del ancho del rectangulo
   * 
   * @return
   */
  public int getAncho() {
    return this.alto;
  }

  /**
   * Asigna el valor del alto del rectangulo.
   * 
   * @param alto
   */
  private void setAlto(int alto) throws ArithmeticException {
    if (alto <= 0 || alto > 10)
      throw new ArithmeticException("La altura no puede ser negativa, ni sobrepasar 10");
    this.alto = alto;
  }

  /**
   * Devuelve el valor del alto del rectangulo
   * 
   * @return
   */
  public int getAlto() {
    return this.alto;
  }

  /**
   * Devuelve la cadena con la representacion gráfica del rectangulo.
   * 
   * @return
   */
  public String toString() {
    String aux = "";

    for (int i = 0; i < this.ancho; i++) {
      aux += "[]";
    }

    aux += "\n";

    for (int j = 1; j < this.alto - 1; j++) {
      for (int i = 0; i < this.ancho; i++) {
        if (i == 0 || i == (this.ancho - 1))
          aux += "[]";
        else
          aux += "  ";
      }
      aux += "\n";
    }

    if (this.alto > 1)
      for (int i = 0; i < this.ancho; i++) {
        aux += "[]";
      }
    return aux;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + alto;
    result = prime * result + ancho;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Rectangulo other = (Rectangulo) obj;
    if (alto != other.alto)
      return false;
    if (ancho != other.ancho)
      return false;
    return true;
  }
}