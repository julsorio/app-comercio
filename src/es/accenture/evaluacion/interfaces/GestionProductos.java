package es.accenture.evaluacion.interfaces;

/**
 * interface para la gestion de productos
 * @author andrea ravagli
 */
public interface GestionProductos {
	/**
	 * metodo para incrementar stock
	 * @param cantidad
	 */
	public void incrementarStock(int cantidad);
	
	/**
	 * metodo para disminuir stock
	 */
	public void disminuirStock();
	
	/**
	 * metodo para actualizar precio
	 */
	public void actualizarPrecio();
}
