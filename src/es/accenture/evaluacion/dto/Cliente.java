package es.accenture.evaluacion.dto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import es.accenture.evaluacion.interfaces.GestionClientes;

/**
 * clase que representa un cliente
 * @author andrea ravagli
 */
public class Cliente implements GestionClientes {

	private Persona cliente;
	private List<Producto> carrito;
	private DecimalFormat decimalFormat;
	
	public Cliente() {
		carrito = new ArrayList<>();
		decimalFormat = new DecimalFormat("##.0");
	}

	/**
	 * metodo para obtener la informacion del cliente
	 */
	@Override
	public void infoCliente() {
		System.out.println("Cliente: " + cliente.getNombreCompleto() + " ; D.N.I: " + cliente.getDni() + "\n" +
				"Direccion: " + cliente.getDireccion());
	}

	/**
	 * metodo para mostrar el contenido del carrito
	 */
	@Override
	public void mostrarCarrito() {
		// TODO ver salida en resultado esperado
		
		/**
		 * mostrar la lista de todos los productos del carrito para el cliente. 
		 * Dicha lista saldra ordenada por el precio del producto de mayor a menor, 
		 * implementacion necesaria para dicha ordenacion. Al final de la lista, 
		 * sacara el precio total de todos los productos que tenemos en el carrito para el cliente
		 */
		
		System.out.println("Contenido del carrito de " + cliente.getNombreCompleto());
		
		Comparator<Producto> porPrecio = (Producto p2, Producto p1) -> Double.compare(p1.getPrecio(), p2.getPrecio());
		this.getCarrito().sort(porPrecio);
		double total = 0;
		
		for(Producto prod : this.getCarrito()) {
			System.out.println(prod.getCodigoProducto() + " - " + prod.getNombre() + " - " + prod.getPrecio());
			total += prod.getPrecio();
		}
		
		System.out.println("Total del pedido: " + decimalFormat.format(total));
	}

	/**
	 * metodo para enviar el pedido
	 */
	@Override
	public void enviarPedido() {
		// TODO ver salida en resultado esperado
		System.out.println("Enviando pedido a ...");
		infoCliente();
	}



	/**
	 * metodo para obtener el cliente
	 * @return cliente
	 */
	public Persona getCliente() {
		return cliente;
	}

	/**
	 * metodo para setear el cliente
	 * @param cliente
	 */
	public void setCliente(Persona cliente) {
		this.cliente = cliente;
	}

	/**
	 * metodo para obtener la lista de productos
	 * @return carrito
	 */
	public List<Producto> getCarrito() {
		return carrito;
	}

	/**
	 * metodo para setear la lista de productos
	 * @param carrito
	 */
	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}
	
	
}
