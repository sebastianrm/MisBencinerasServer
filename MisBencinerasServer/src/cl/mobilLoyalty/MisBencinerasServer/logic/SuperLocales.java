/**
 * 
 */
package cl.mobilLoyalty.MisBencinerasServer.logic;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrador
 *
 */
@XmlRootElement(name = "locales")
public class SuperLocales {
	
	private String direccion;
	private double latitud;
	private double longitud;
	private String cadena;
	private long distancia;
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
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public long getDistancia() {
		return distancia;
	}
	public void setDistancia(long distancia) {
		this.distancia = distancia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadena == null) ? 0 : cadena.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + (int) (distancia ^ (distancia >>> 32));
		long temp;
		temp = Double.doubleToLongBits(latitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitud);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SuperLocales other = (SuperLocales) obj;
		if (cadena == null) {
			if (other.cadena != null)
				return false;
		} else if (!cadena.equals(other.cadena))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (distancia != other.distancia)
			return false;
		if (Double.doubleToLongBits(latitud) != Double
				.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double
				.doubleToLongBits(other.longitud))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SuperLocales [direccion=" + direccion + ", latitud=" + latitud
				+ ", longitud=" + longitud + ", cadena=" + cadena
				+ ", distancia=" + distancia + "]";
	}
	public SuperLocales(String direccion, double latitud, double longitud,
			String cadena, long distancia) {
		super();
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.cadena = cadena;
		this.distancia = distancia;
	}
	public SuperLocales() {
		super();
		// TODO Auto-generated constructor stub
	}

}
