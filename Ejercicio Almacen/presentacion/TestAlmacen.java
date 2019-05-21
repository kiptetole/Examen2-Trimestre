package presentacion;

import gestion.Almacen;
import gestion.Articulo.iva;
import gestion.CodigoNoExisteException;
import gestion.IvaNotNullExeption;
import gestion.PrecioNegativoExeption;
import gestion.StockNegativoExeption;
import utiles.Menu;
import utiles.Teclado;

/**
 * Clase Test almacen que prueba los metodos del almacen.
 * 
 * @author Jose Notario Millan
 */
public class TestAlmacen {

  private static Menu modificacion = new Menu("Que campo del articulo quieres cambiar:" , new String[] { "Unidades", "Precio de Compra", "Precio de Venta", "Descripcion", "Iva", "Salir" });
  
  private static Menu Iva = new Menu("Menu elegir Iva: ", new String[] { "General", "Reducido", "Super Reducido" });

  static Almacen almacen = new Almacen();

  public static void main(String[] args) {

    String opciones[] = { "Añadir un Articulo", "Quitar un articulo", "Modificar un articulo", "Añadir Stock",
        "Quitar Stock", "Mostrar Articulos", "Salir" };
    Menu general = new Menu("Menu del almacen:", opciones);
    int selector;

    do {
      
      selector = general.gestionar();
      
      switch (selector) {
      case 1:
        annadir();
        break;
      case 2:
        borrar();
        break;
      case 3:
        modificar();
        break;
      case 4:
        annadirStock();
        break;
      case 5:
        quitarStock();
        break;
      case 6:
        mostrar();
        break;
      default:
        System.out.println("Adios             :)");
        break;
      }
    } while (selector != 7);
  }

  /**
   * Muestra el almacen
   */
  public static void mostrar() {
    System.out.println("Lista de Articulos\n----------------------------------");

    try {
      if (!(almacen.get(1) != null)) {
        throw new CodigoNoExisteException("");
      }
    } catch (CodigoNoExisteException e) {
      System.err.println("No existe ningun articulo en el Almacen");
    }

    System.out.println(almacen.mostrar());
    
  }

  /**
   * Quita stock de un articulo del almacen pero si este se restara menos de cero no se restaria.
   */
  public static void quitarStock() {
    try {
      almacen.quitarStock(Teclado.leerEntero("Introduzca el codigo del articulo a añadir las unidades: "),
          Teclado.leerEntero("Introduzca el numero de unidades a restar"));
    } catch (StockNegativoExeption | CodigoNoExisteException e) {
      System.err.println(e.getMessage());
      System.out.println("No se pudo quitar tanto stock.");
    }
  }

  /**
   * Añade unidades de un articulo al stock que ya tiene
   */
  public static void annadirStock() {
    try {
      almacen.annadirStock(Teclado.leerEntero("Introduzca el codigo del articulo a añadir las unidades: "),
          Teclado.leerEntero("Introduzca el numero de unidades a A�adir: "));
    } catch (StockNegativoExeption | CodigoNoExisteException e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * modifica cualquier campo del articulo del almacen.
   */
  public static void modificar() {
    try {
      modifica(Teclado.leerEntero("Introduzca el codigo del articulo a modificar: "));
    } catch (StockNegativoExeption | CodigoNoExisteException | PrecioNegativoExeption | IvaNotNullExeption e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * Borra un articulo del almacen pasandole un codigo.
   */
  public static void borrar() {
    try {
      almacen.borrar(Teclado.leerEntero("Introduzca el codigo del articulo a borrar: "));
    } catch (CodigoNoExisteException e) {
      System.err.println(e.getMessage());
    }
  }

  /**
   * añade un articulo al almacen
   */
  public static void annadir() {
    try {
      annadirArticulo();
    } catch (IvaNotNullExeption | PrecioNegativoExeption | StockNegativoExeption e) {
      System.err.println(e.getMessage());
      System.err.println("El articulo no se ha creado.");
    }
  }

  /**
   * Selector del iva del articulo.
   * 
   * @return
   */
  public static iva elegirIva() {

    switch (Iva.gestionar()) {
    case 1:
      return iva.GENERAL;
    case 2:
      return iva.REDUCIDO;
    default:
      return iva.SUPERREDUCIDO;
    }
  }

  /**
   * Introduce el articulo en el almacen
   * 
   * @throws IvaNotNullExeption
   * @throws PrecioNegativoExeption
   * @throws StockNegativoExeption
   */
  public static void annadirArticulo() throws IvaNotNullExeption, PrecioNegativoExeption, StockNegativoExeption {
    almacen.annadir(Teclado.leerEntero("Introduzca el numero de unidades: "),
        Teclado.leerDecimal("Introduzca el precio de Compra: "), Teclado.leerDecimal("Introduzca el precio de Venta: "),
        elegirIva(), Teclado.leerCadena("Introduzca la descripcion"));
  }

  public static void modifica(int codigo)
      throws StockNegativoExeption, CodigoNoExisteException, PrecioNegativoExeption, IvaNotNullExeption {

    if (!(almacen.get(codigo) != null)) {
      throw new CodigoNoExisteException("El codigo introducido no existe.");
    }
    
    int selector;

    do {

      selector = modificacion.gestionar();
      
      switch (selector) {
      case 1:
        almacen.modUnidades(Teclado.leerEntero("Introduzca el stock nuevo: "), codigo);
        break;
      case 2:
        almacen.modPrecioCompra(Teclado.leerDecimal("Introduzca el nuevo precio de Compra: "), codigo);
        break;
      case 3:
        almacen.modPrecioVenta(Teclado.leerDecimal("Introduzca el nuevo precio de Venta: "), codigo);
        break;
      case 4:
        almacen.modDescripcion(Teclado.leerCadena("Introduzca la nueva descripcion: "), codigo);
        break;
      case 5:
        almacen.modIva(elegirIva(), codigo);
        break;
      default:
        System.out.println("Modificacion Terminada ;)");
        break;
      }

    } while (selector != 6);

  }

}