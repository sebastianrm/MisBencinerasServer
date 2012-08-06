package cl.mobilLoyalty.MisBencinerasServer.data.dto;

import java.util.ArrayList;

public class GeoReferencia {

	private float latitud;
	private float longitud;
	private ServiCentro serviCentro;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direccionGoogle == null) ? 0 : direccionGoogle.hashCode());
		result = prime * result + Float.floatToIntBits(latitud);
		result = prime * result + Float.floatToIntBits(longitud);
		result = prime * result
				+ ((serviCentro == null) ? 0 : serviCentro.hashCode());
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
		GeoReferencia other = (GeoReferencia) obj;
		if (direccionGoogle == null) {
			if (other.direccionGoogle != null)
				return false;
		} else if (!direccionGoogle.equals(other.direccionGoogle))
			return false;
		if (Float.floatToIntBits(latitud) != Float
				.floatToIntBits(other.latitud))
			return false;
		if (Float.floatToIntBits(longitud) != Float
				.floatToIntBits(other.longitud))
			return false;
		if (serviCentro == null) {
			if (other.serviCentro != null)
				return false;
		} else if (!serviCentro.equals(other.serviCentro))
			return false;
		return true;
	}

	public ServiCentro getServiCentro() {
		return serviCentro;
	}

	public void setServiCentro(ServiCentro serviCentro) {
		this.serviCentro = serviCentro;
	}

	private ArrayList<String> direccionGoogle;

	
	


	public ArrayList<String> getDireccionGoogle() {
		return direccionGoogle;
	}

	public void setDireccionGoogle(ArrayList<String> direccionGoogle) {
		this.direccionGoogle = direccionGoogle;
	}

	public GeoReferencia(float latitud, float longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}



	public GeoReferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

}
