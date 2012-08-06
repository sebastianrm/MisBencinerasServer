package cl.mobilLoyalty.MisBencinerasServer.data.dto;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "servicios")
public class Bencinas {

	private String descripcion;
	private float precios;
	@XmlJavaTypeAdapter( TimestampAdapter.class)
	private Timestamp fechaUlmtimaModificacion;
	private ServiCentro serviCentro;
	private Double distancia;
		

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Timestamp getFechaUlmtimaModificacion() {
		return fechaUlmtimaModificacion;
	}

	public void setFechaUlmtimaModificacion(Timestamp fechaUlmtimaModificacion) {
		this.fechaUlmtimaModificacion = fechaUlmtimaModificacion;
	}

	public ServiCentro getServiCentro() {
		return serviCentro;
	}

	public void setServiCentro(ServiCentro serviCentro) {
		this.serviCentro = serviCentro;
	}
	
	
	public float getPrecios() {
		return precios;
	}

	public void setPrecios(float precios) {
		this.precios = precios;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime
				* result
				+ ((fechaUlmtimaModificacion == null) ? 0
						: fechaUlmtimaModificacion.hashCode());
		result = prime * result + Float.floatToIntBits(precios);
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
		Bencinas other = (Bencinas) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaUlmtimaModificacion == null) {
			if (other.fechaUlmtimaModificacion != null)
				return false;
		} else if (!fechaUlmtimaModificacion
				.equals(other.fechaUlmtimaModificacion))
			return false;
		if (Float.floatToIntBits(precios) != Float
				.floatToIntBits(other.precios))
			return false;
		if (serviCentro == null) {
			if (other.serviCentro != null)
				return false;
		} else if (!serviCentro.equals(other.serviCentro))
			return false;
		return true;
	}
	

}
