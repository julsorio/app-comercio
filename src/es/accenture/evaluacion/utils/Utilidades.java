package es.accenture.evaluacion.utils;

import java.util.Arrays;
import java.util.Scanner;

import es.accenture.evaluacion.dto.Cliente;
import es.accenture.evaluacion.dto.NoPerecedero;
import es.accenture.evaluacion.dto.Perecedero;
import es.accenture.evaluacion.dto.Producto;

/**
 * Clase para metodos utilitarios
 * @author andrea ravagli
 */
public class Utilidades {
	private static Scanner input;
	
	private static final int INCREMENTO_STOCK = 5;
	
	static {
		input = new Scanner(System.in);
	}
	
	/**
	 * metodo utilitario para crear un almacen
	 * @param arrayProductos
	 */
	public static void crearAlmacen(Producto[] arregloProductos) {
		Perecedero leche = new Perecedero();
		leche.setCodigoProducto(101);
		leche.setDiasCaducar(10);
		leche.setNombre("Leche entera");
		leche.setPrecio(1.25);
		leche.setStock(10);
		arregloProductos[0] = leche;
		
		Perecedero yogurt = new Perecedero();
		yogurt.setCodigoProducto(103);
		yogurt.setDiasCaducar(2);
		yogurt.setNombre("Yogurt natural");
		yogurt.setPrecio(0.55);
		yogurt.setStock(5);
		arregloProductos[1] = yogurt;
		
		Perecedero pan = new Perecedero();
		pan.setCodigoProducto(122);
		pan.setDiasCaducar(25);
		pan.setNombre("Pan de molde");
		pan.setPrecio(1.65);
		pan.setStock(0);
		arregloProductos[2] = pan;
		
		Perecedero queso = new Perecedero();
		queso.setCodigoProducto(115);
		queso.setDiasCaducar(3);
		queso.setNombre("Queso curado");
		queso.setPrecio(5.25);
		queso.setStock(10);
		arregloProductos[3] = queso;
		
		Perecedero huevos = new Perecedero();
		huevos.setCodigoProducto(134);
		huevos.setDiasCaducar(12);
		huevos.setNombre("Huevos");
		huevos.setPrecio(1.55);
		huevos.setStock(5);
		arregloProductos[4] = huevos;
		
		NoPerecedero manta = new NoPerecedero();
		manta.setCodigoProducto(201);
		manta.setNombre("Manta polar");
		manta.setPrecio(30.0);
		manta.setStock(5);
		arregloProductos[5] = manta;
		
		NoPerecedero cojin = new NoPerecedero();
		cojin.setCodigoProducto(222);
		cojin.setNombre("Cojin floral");
		cojin.setPrecio(7.55);
		cojin.setStock(10);
		arregloProductos[6] = cojin;

		NoPerecedero almohada = new NoPerecedero();
		almohada.setCodigoProducto(213);
		almohada.setNombre("Almohada de plumas");
		almohada.setPrecio(15.95);
		almohada.setStock(10);
		arregloProductos[7] = almohada;
		
		NoPerecedero sabanasB = new NoPerecedero();
		sabanasB.setCodigoProducto(244);
		sabanasB.setNombre("Sabanas blancas");
		sabanasB.setPrecio(22.10);
		sabanasB.setStock(5);
		arregloProductos[8] = sabanasB;
		
		NoPerecedero sabanasR = new NoPerecedero();
		sabanasR.setCodigoProducto(205);
		sabanasR.setNombre("Sabanas rosas");
		sabanasR.setPrecio(22.10);
		sabanasR.setStock(0);
		arregloProductos[9] = sabanasR;
		
	}
	
	/**
	 * metodo utilitario para mostrar los productos
	 */
	public static void mostrarProductos(Producto[] arregloProductos) {
		System.out.println("Lista de productos");
		System.out.println("------------------");
		//lista con una cabecera y datos ordenados por cod producto de menor a mayor
		
		
		Arrays.sort(arregloProductos);
		
		for(Producto prod : arregloProductos) {
			prod.mostrarInfo();
		}
	}
	
	/**
	 * metodo utilitario para anadir productos al carrito
	 * @param arrayProductos
	 * @param cliente
	 */
	public static void anadirProductoCarrito(Producto[] arrayProductos, Cliente cliente) {
		//solicitar el codigo del producto a incluir
		System.out.println("--- Comenzamos con la compra ---");
		String continuaCompra = "S";
		int codigoProducto = 0;
		
		do {
			try {
				System.out.println("Introduce el codigo del producto deseado:");
				codigoProducto = input.nextInt();
				//comprobar si tenemos dicho producto en el almacen (array de productos)
				Producto prod = Utilidades.existeProductoEnAlmacen(codigoProducto, arrayProductos);
				if(prod != null) {
					//existe el producto en el almacen
					//validamos si hay stock
					if(prod.getStock() >= 1) {
						cliente.getCarrito().add(prod);
						prod.disminuirStock();
						prod.actualizarPrecio();
						System.out.println("Producto anadido al carrito");
					} else {
						System.out.println("No hay stock suficiente");
						prod.incrementarStock(INCREMENTO_STOCK);
					}
				} else {
					//no existe el producto en el almacen
					System.out.println("No existe el producto en el almacen");
					
				}
				
				System.out.println("Desea anadir otro producto? (S/N)");
				continuaCompra = input.next().toUpperCase();
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error inesperado");
			}
			
		} while (continuaCompra.equals("S"));
		
		System.out.println("--- Fin de compra ---");
		
	}
	
	public static Producto existeProductoEnAlmacen(int codigoProducto, Producto[] arrayProductos) {
		Producto producto  = null;
		
		for(int pos = 0; pos < arrayProductos.length; pos ++) {
			Producto prd = arrayProductos[pos];
			
			//validamos que exista un producto con ese codigo en el almacen
			if(codigoProducto == prd.getCodigoProducto()) {
				producto = prd;
				break;
			}
		}
		
		return producto;
	}
}
