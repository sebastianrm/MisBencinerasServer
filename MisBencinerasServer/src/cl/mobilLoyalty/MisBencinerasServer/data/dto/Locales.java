package cl.mobilLoyalty.MisBencinerasServer.data.dto;

import java.io.Serializable;

public class Locales implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String direccion;
	private double latitud;
	private double longitud;
	private Cadena fk_cadena;
	private Region fk_region;
	private long distancia;
	
	
	public long getDistancia() {
		return distancia;
	}
	public void setDistancia(long distancia) {
		this.distancia = distancia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public Cadena getFk_cadena() {
		return fk_cadena;
	}
	public void setFk_cadena(Cadena fk_cadena) {
		this.fk_cadena = fk_cadena;
	}
	public Region getFk_region() {
		return fk_region;
	}
	public void setFk_region(Region fk_region) {
		this.fk_region = fk_region;
	}
	@Override
	public String toString() {
		return "Locales [nombre=" + nombre + ", direccion=" + direccion
				+ ", latitud=" + latitud + ", longitud=" + longitud
				+ ", fk_cadena=" + fk_cadena + ", fk_region=" + fk_region + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + (int) (distancia ^ (distancia >>> 32));
		result = prime * result
				+ ((fk_cadena == null) ? 0 : fk_cadena.hashCode());
		result = prime * result
				+ ((fk_region == null) ? 0 : fk_region.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locales other = (Locales) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (distancia != other.distancia)
			return false;
		if (fk_cadena == null) {
			if (other.fk_cadena != null)
				return false;
		} else if (!fk_cadena.equals(other.fk_cadena))
			return false;
		if (fk_region == null) {
			if (other.fk_region != null)
				return false;
		} else if (!fk_region.equals(other.fk_region))
			return false;
		if (Double.doubleToLongBits(latitud) != Double
				.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double
				.doubleToLongBits(other.longitud))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	

}
