package es.accenture.evaluacion.dto;

/**
 * clase que representa un producto no perecedero
 * 
 * @author andrea ravagli
 */
public class NoPerecedero extends Producto {
	private final double DESCUENTO_10 = 0.1;

	/**
	 * metodo utilizado para actualizar el precio
	 */
	public void actualizarPrecio() {
		double descuento = this.getPrecio() * DESCUENTO_10;
		this.setPrecio(this.getPrecio() - descuento);
	}

}
