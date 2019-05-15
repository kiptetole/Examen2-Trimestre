package gestion;

/**
 * Clase Articulo.
 * 
 * @author Jose Notario Millan
 */
public class Articulos {

  private int unidades;
  private double precioCompra;
  private double precioVenta;
  private String descripcion;
  private String codigo;
  private iva iva;

  private static int contadorcodigo = 1;

  public enum iva {
    General, Reducido, SuperReducido
  }

  Articulos(int unidades, double precioCompra, double precioVenta, iva iva, String descripcion)
      throws IvaNotNullExeption, PrecioNegativoExeption, StockNegativoExeption {

    setStock(unidades);
    setPrecioVenta(precioVenta);
    setPrecioCompra(precioCompra);
    setIva(iva);
    setDescripcion(descripcion);
    setCodigo();

  }

  Articulos(String codigo) {
    this.codigo = codigo;
  }

  /**
   * Establece el codigo del articulo.
   */
  void setCodigo() {
    this.codigo = Integer.toString(AutoincrementoCodigo());
  }

  /**
   * devuelve el codigo autoincrementado.
   * 
   * @return Codigo Autoincrementado.
   */
  int AutoincrementoCodigo() {
    return contadorcodigo++;
  }

  /**
   * Establece el valor de la descripcion del articulo.
   * 
   * @param descripcion
   */
  void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  /**
   * Se le asigna el iva de un articulo.
   *
   * @param iva
   * @throws IvaNotNullExeption
   */
  void setIva(iva iva) throws IvaNotNullExeption {
    if (iva == null)
      throw new IvaNotNullExeption("El iva no puede ser nulo.");
    this.iva = iva;
  }

  /**
   * Se le asigna el precio de compra de un articulo.
   * 
   * @param precioCompra
   * @throws PrecioNegativoExeption
   */
  void setPrecioCompra(double precioCompra) throws PrecioNegativoExeption {
    if (precioCompra < 0)
      throw new PrecioNegativoExeption("El precio de compra del articulo no puede ser negativo.");
    this.precioCompra = precioCompra;
  }

  /**
   * Se le asigna el precio de venta de un articulo.
   * 
   * @param precioVenta
   * @throws PrecioNegativoExeption
   */
  void setPrecioVenta(double precioVenta) throws PrecioNegativoExeption {
    if (precioVenta < 0)
      throw new PrecioNegativoExeption("El precio de venta del articulo no puede ser negativo.");
    this.precioVenta = precioVenta;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
    Articulos other = (Articulos) obj;
    if (codigo == null) {
      if (other.codigo != null)
        return false;
    } else if (!codigo.equals(other.codigo))
      return false;
    return true;
  }

  /**
   * Se le asigna el stock de un articulo.
   * 
   * @param unidades
   * @throws StockNegativoExeption
   */
  void setStock(int unidades) throws StockNegativoExeption {
    if (unidades < 0)
      throw new StockNegativoExeption("El stock del articulo no puede ser negativo.");
    this.unidades = unidades;
  }

  public int getStock() {
    
    return this.unidades;
    
  }
  
  /**
   * Muestra por pantalla el articulo completo.
   */
  @Override
  public String toString() {
    return "Articulo Codigo:" + codigo + "\n-------------------------------" + "\nUnidades: " + unidades
        + "\nPrecio de Compra: " + precioCompra + "\nPrecio de Venta: " + precioVenta + "\nIva: " + iva
        + "\nDescripcion: " + descripcion + "\n-------------------------------";
  }
}