package presentacion;

import javax.sound.midi.SysexMessage;

import gestion.Almacen;
import gestion.Articulos.iva;
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
        try {
          annadirArticulo();
        } catch (IvaNotNullExeption | PrecioNegativoExeption | StockNegativoExeption e) {
          System.err.println(e.getMessage());
          System.err.println("El articulo no se ha creado.");
        }
        break;
      case 2:
        try {
          almacen.borrar(Teclado.leerCadena("Introduzca el codigo del articulo a borrar: "));
        } catch (CodigoNoExisteException e) {
          System.err.println(e.getMessage());
        }
        break;
      case 3:
        try {
          modifica(Teclado.leerCadena("Introduzca el codigo del articulo a modificar: "));
        } catch (StockNegativoExeption | CodigoNoExisteException | PrecioNegativoExeption | IvaNotNullExeption e) {
          System.err.println(e.getMessage());
        }
        break;
      case 4:
        try {
          almacen.annadirStock(Teclado.leerCadena("Introduzca el codigo del articulo a añadir las unidades: "),
              Teclado.leerEntero("Introduzca el numero de unidades a A�adir: "));
        } catch (StockNegativoExeption | CodigoNoExisteException e) {
          System.err.println(e.getMessage());
        }
        break;
      case 5:
        try {
          almacen.quitarStock(Teclado.leerCadena("Introduzca el codigo del articulo a añadir las unidades: "),
              Teclado.leerEntero("Introduzca el numero de unidades a restar"));
        } catch (StockNegativoExeption | CodigoNoExisteException e) {
          System.err.println(e.getMessage());
          System.out.println("No se pudo quitar tanto stock.");
        }
        break;
      case 6:
        System.out.println("Lista de Articulos\n----------------------------------");
        
        try {
          if (!(almacen.get("1")!= null)) {
            throw new CodigoNoExisteException("");
          }
        } catch (CodigoNoExisteException e) {
          System.err.println("No existe ningun articulo en el Almacen");
        }
        
        almacen.mostrar();
        break;
      default:
        System.out.println("Adios             :)");
        break;
      }
    } while (selector != 7);
  }

  /**
   * Selector del iva del articulo.
   * 
   * @return
   */
  public static iva elegirIva() {
    String opciones[] = { "General", "Reducido", "Super Reducido" };
    Menu Iva = new Menu("Menu elegir Iva: ", opciones);
    int selector;

    selector = Iva.gestionar();

    switch (selector) {
    case 1:
      return iva.General;
    case 2:
      return iva.Reducido;
    default:
      return iva.SuperReducido;
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

  public static void modifica(String codigo)
      throws StockNegativoExeption, CodigoNoExisteException, PrecioNegativoExeption, IvaNotNullExeption {

    String opciones[] = { "Unidades", "Precio de Compra", "Precio de Venta", "Descripcion", "Iva", "Salir" };
    Menu modifica = new Menu("Que campo del articulo quieres cambiar:\n CodigoArticulo:" + codigo, opciones);
    int selector;
    
    if (!(almacen.get(codigo)!= null)) {
      throw new CodigoNoExisteException("El codigo introducido no existe.");
    }

    do {
      selector = modifica.gestionar();

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