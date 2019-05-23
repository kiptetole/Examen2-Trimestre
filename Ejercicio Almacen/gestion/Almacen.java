package gestion;

import java.util.ArrayList;

import gestion.Articulo.IVA;

public class Almacen {

  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();

  /**
   * Añade un articulo al array almacen.
   * 
   * @param unidades
   * @param precioCompra
   * @param precioVenta
   * @param iva
   * @param descripcion
   * @throws IvaNotNullExeption
   * @throws PrecioNegativoExeption
   * @throws StockNegativoExeption
   */
  public void annadir(int unidades, double precioCompra, double precioVenta, IVA iva, String descripcion)
      throws IvaNotNullExeption, PrecioNegativoExeption, StockNegativoExeption {

    almacen.add(new Articulo(unidades, precioCompra, precioVenta, iva, descripcion));

  }

  /**
   * Encontrar el Articulo con el codigo pedido
   * 
   * @param codigo
   * @return
   * @throws CodigoNoExisteException
   */
  public Articulo get(int codigo) throws CodigoNoExisteException {

    try {
      return almacen.get(almacen.indexOf(new Articulo(codigo)));
    } catch (IndexOutOfBoundsException e) {
      throw new CodigoNoExisteException("El Codigo no Existe");
    }

  }

  /**
   * Borra el articulo del codigo pasado.
   * 
   * @param codigo
   * @throws CodigoNoExisteException
   */
  public void borrar(int codigo) throws CodigoNoExisteException {

    almacen.remove(get(codigo));

  }

  /**
   * Modifica el numero de unidades
   * 
   * @param unidades
   * @param codigo
   * @throws StockNegativoExeption
   * @throws CodigoNoExisteException
   */
  public void modUnidades(int unidades, int codigo) throws StockNegativoExeption, CodigoNoExisteException {

    get(codigo).setStock(unidades);

  }

  /**
   * Modifica el precio de Compra
   * 
   * @param precioCompra
   * @param codigo
   * @throws PrecioNegativoExeption
   * @throws CodigoNoExisteException
   */
  public void modPrecioCompra(double precioCompra, int codigo)
      throws PrecioNegativoExeption, CodigoNoExisteException {

    get(codigo).setPrecioCompra(precioCompra);

  }

  /**
   * Modifica el precio de Venta
   * 
   * @param precioVenta
   * @param codigo
   * @throws PrecioNegativoExeption
   * @throws CodigoNoExisteException
   */
  public void modPrecioVenta(double precioVenta, int codigo) throws PrecioNegativoExeption, CodigoNoExisteException {

    get(codigo).setPrecioVenta(precioVenta);

  }

  /**
   * Modifica la descripcion
   * 
   * @param descripcion
   * @param codigo
   * @throws CodigoNoExisteException
   */
  public void modDescripcion(String descripcion, int codigo) throws CodigoNoExisteException {

    get(codigo).setDescripcion(descripcion);

  }

  /**
   * Modifica el iva
   * 
   * @param iva
   * @param codigo
   * @throws IvaNotNullExeption
   * @throws CodigoNoExisteException
   */
  public void modIva(IVA iva, int codigo) throws IvaNotNullExeption, CodigoNoExisteException {

    get(codigo).setIva(iva);

  }

  /**
   * Añade stock al articulo con el codigo pasado.
   * 
   * @param codigo
   * @param unidades
   * @throws StockNegativoExeption
   * @throws CodigoNoExisteException
   */
  public void annadirStock(int codigo, int unidades) throws StockNegativoExeption, CodigoNoExisteException {

    get(codigo).setStock(get(codigo).getStock() + unidades);

  }
  
  /**
   * Resta stock al articulo con el codigo pasado, y si resta mas del que hay no se quita el stock.
   * 
   * @param codigo
   * @param unidades
   * @throws StockNegativoExeption
   * @throws CodigoNoExisteException
   */
  public void quitarStock(int codigo, int unidades) throws StockNegativoExeption, CodigoNoExisteException {

    get(codigo).setStock(get(codigo).getStock() - unidades);

  }
  
  /**
   * Muestra el arraylist por pantalla
   */
  public String mostrar() {
    String aux = "";
    
    for (Articulo articulo : almacen)
      aux += articulo.toString();

    return aux;
    
  }
  
  public boolean isEmpty() {
    return almacen.isEmpty();
  }
}