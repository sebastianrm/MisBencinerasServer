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

	private Float distancia = new Float(0);
	
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

	public Float getDistancia() {
		return distancia;
	}

	public void setDistancia(Float distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Bencinas == null) ? 0 : Bencinas.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result
				+ ((distancia == null) ? 0 : distancia.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((geoRef == null) ? 0 : geoRef.hashCode());
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
		if (Bencinas == null) {
			if (other.Bencinas != null)
				return false;
		} else if (!Bencinas.equals(other.Bencinas))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (distancia == null) {
			if (other.distancia != null)
				return false;
		} else if (!distancia.equals(other.distancia))
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
		return true;
	}

	@Override
	public String toString() {
		return "ServiCentro [empresa=" + empresa + ", direccion=" + direccion
				+ ", geoRef=" + geoRef + ", Bencinas=" + Bencinas + ", region="
				+ region + ", distancia=" + distancia + "]";
	}

	
	
	

}
