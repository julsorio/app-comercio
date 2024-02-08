package es.accenture.evaluacion.dto;

import es.accenture.evaluacion.interfaces.GestionProductos;

/**
 * clase que representa un producto
 * @author andrea ravagli
 */
public class Producto implements GestionProductos, Comparable<Producto> {
	private int codigoProducto;
	private String nombre;
	private double precio;
	private int stock;
	
	private final double DESCUENTO_5 = 0.05;
	
	/**
	 * metodo para mostrar informacion
	 */
	public void mostrarInfo() {
		System.out.println(toString());
	}

	/**
	 * metodo para incrementar el stock
	 */
	@Override
	public void incrementarStock(int cantidad) {
		this.stock += cantidad;
	}

	/**
	 * metodo para disminuir el stock
	 */
	@Override
	public void disminuirStock() {
		this.stock --;
	}

	/**
	 * metodo para actualizar el precio del producto
	 */
	@Override
	public void actualizarPrecio() {
		double descuento = this.precio * DESCUENTO_5;
		this.precio -= descuento;
	}

	/**
	 * metodo para realizar ordenamiento
	 */
	@Override
	public int compareTo(Producto o) {
		return Double.compare(this.codigoProducto, o.codigoProducto);
	}

	/**
	 * metodo para obtener el codigo de producto
	 * @return codigoProducto
	 */
	public int getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * metodo para setear codigo de producto
	 * @param codigoProducto
	 */
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * metodo para obtener el nombre
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * metodo para setear el nombre
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * metood para obtener el precio
	 * @return precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * metodo para setear el precio
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * metodo para obtener el stock
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * metodo para setear el stock
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Datos del producto: " + codigoProducto + " - " + nombre + "\n Precio: " + precio + " - Stock: "
				+ stock;
	}
	
}
