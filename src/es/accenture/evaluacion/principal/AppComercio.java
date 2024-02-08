package es.accenture.evaluacion.principal;

import es.accenture.evaluacion.dto.Cliente;
import es.accenture.evaluacion.dto.Persona;
import es.accenture.evaluacion.dto.Producto;
import es.accenture.evaluacion.utils.Utilidades;

/**
 * Clase principal
 * @author andrea ravagli
 */
public class AppComercio {
	
	/**
	 * metodo donde se inicia la aplicacion de comercio
	 * @param args
	 */
	public static void main(String[] args) {
		
		//se crea el arreglo que contiene Productos con 10 posiciones
		Producto[] arregloProductos = new Producto[10];
		//se crea el almacen
		Utilidades.crearAlmacen(arregloProductos);
		
		//la lista de los productos que tenemos en el almacén ordenados por el codigo del producto de menor a mayor
		Utilidades.mostrarProductos(arregloProductos);
		
		//se crea una instancia de cliente
		Cliente cliente = new Cliente();
		Persona persona = new Persona();
		persona.setDireccion("Calle Federico Garcia Lorca, 3");
		persona.setDni("11111111H");
		persona.setNombreCompleto("Rodrigo Tapias Herrero");
		cliente.setCliente(persona);
		
		Utilidades.anadirProductoCarrito(arregloProductos, cliente);
		
		cliente.mostrarCarrito();
		
		cliente.enviarPedido();
		
		Utilidades.mostrarProductos(arregloProductos);
	}

}
