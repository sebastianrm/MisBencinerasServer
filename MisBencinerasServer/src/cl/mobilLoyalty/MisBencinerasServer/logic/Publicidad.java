package cl.mobilLoyalty.MisBencinerasServer.logic;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "publicidad")
public class Publicidad {
	private String urlImagen;
	private String urlLink;
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getUrlLink() {
		return urlLink;
	}
	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}

	
}
