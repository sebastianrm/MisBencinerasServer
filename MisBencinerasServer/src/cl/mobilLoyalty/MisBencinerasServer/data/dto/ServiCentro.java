/**
 * 
 */
package cl.mobilLoyalty.MisBencinerasServer.data.dto;

import java.util.Set;

/**
 * @author Sebastian Retamal
 * 
 */

public class ServiCentro {

	private String empresa;
	private String direccion;
	private GeoReferencia geoRef;

	private Set<Bencinas> Bencinas;

	private Region region;

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Set<Bencinas> getBencinas() {
		return Bencinas;
	}

	public void setBencinas(Set<Bencinas> bencinas) {
		Bencinas = bencinas;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public GeoReferencia getGeoRef() {
		return geoRef;
	}

	public void setGeoRef(GeoReferencia geoRef) {
		this.geoRef = geoRef;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((geoRef == null) ? 0 : geoRef.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
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
		ServiCentro other = (ServiCentro) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (geoRef == null) {
			if (other.geoRef != null)
				return false;
		} else if (!geoRef.equals(other.geoRef))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		return true;
	}

}
