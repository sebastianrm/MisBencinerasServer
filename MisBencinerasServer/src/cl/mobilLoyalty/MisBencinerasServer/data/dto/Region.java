/**
 * 
 */
package cl.mobilLoyalty.MisBencinerasServer.data.dto;

import java.util.Set;

/**
 * @author Sebastian Retamal
 * 
 */
public class Region {

	private String nombre;
	
	private Set<ServiCentro> serviCentros;
	
	public Set<ServiCentro> getServiCentros() {
		return serviCentros;
	}

	public void setServiCentros(Set<ServiCentro> serviCentros) {
		this.serviCentros = serviCentros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Region other = (Region) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
	
	
}
