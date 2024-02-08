package es.accenture.evaluacion.dto;

/**
 * clase que representa un producto perecedero
 * @author andrea ravagli
 */
public class Perecedero extends Producto {
	private int diasCaducar;
	
	private final double DESCUENTO_30 = 0.3;
	private final double DESCUENTO_10 = 0.1;
	
	/**
	 * metodo utilizado para mostrar informacion
	 */
	public void mostrarInfo() {
		System.out.println(toString());
	}
	
	/**
	 * metodo utilizado para actualizar el precio
	 */
	public void actualizarPrecio() {
		double descuento = 0;
		if(this.diasCaducar <= 2) {
			//se aplica 30% de descuento
			descuento = this.getPrecio() * DESCUENTO_30;
		} else {
			//se aplica 10% de descuento
			descuento = this.getPrecio() * DESCUENTO_10;
		}
		
		this.setPrecio(this.getPrecio() - descuento);
	}

	/**
	 * metodo para obtener los dias caducar
	 * @return diasCaducar
	 */
	public int getDiasCaducar() {
		return diasCaducar;
	}

	/**
	 * metodo para setear los dias caducar
	 * @param diasCaducar
	 */
	public void setDiasCaducar(int diasCaducar) {
		this.diasCaducar = diasCaducar;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Dias a caducar:" + diasCaducar;
	}
	
	
}
