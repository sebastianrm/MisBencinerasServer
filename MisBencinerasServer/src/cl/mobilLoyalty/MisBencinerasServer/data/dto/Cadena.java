package cl.mobilLoyalty.MisBencinerasServer.data.dto;

import java.io.Serializable;
import java.util.LinkedList;

public class Cadena implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private LinkedList<Locales> locales;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Locales> getLocales() {
		return locales;
	}

	public void setLocales(LinkedList<Locales> locales) {
		this.locales = locales;
	}

	@Override
	public String toString() {
		return "Cadena [nombre=" + nombre + ", locales=" + locales + "]";
	}
	

}
