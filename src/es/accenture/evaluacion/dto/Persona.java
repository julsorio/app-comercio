package es.accenture.evaluacion.dto;

/**
 * clase que representa una persona
 * 
 * @author andrea ravagli
 */
public class Persona {
	private String nombreCompleto;
	private String dni;
	private String direccion;

	/**
	 * metodo para obtener el nombre completo
	 * @return nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * metodo para setear el nombre completo
	 * @param nombreCompleto
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * metodo para obtener el dni
	 * @return dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * metodo para setear el dni
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * metodo para obtener la direccion
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * metodo para setear la direccion
	 * @param direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
