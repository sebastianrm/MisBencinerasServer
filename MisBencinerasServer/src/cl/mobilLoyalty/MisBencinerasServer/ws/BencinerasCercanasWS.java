/**
 * 
 */
package cl.mobilLoyalty.MisBencinerasServer.ws;

import java.util.HashSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import cl.mobilLoyalty.MisBencinerasServer.data.dto.Bencinas;
import cl.mobilLoyalty.MisBencinerasServer.logic.CalculoCercania;
import cl.mobilLoyalty.MisBencinerasServer.logic.Publicidad;
import cl.mobilLoyalty.MisBencinerasServer.logic.SuperLocales;

/**
 * @author Administrador
 * 
 */
@Produces("application/json")
public class BencinerasCercanasWS {

	@GET
	@Path("/supermercados/{latitud}/{longitud}/{key}")
	public HashSet<SuperLocales> getSupermercados(
			@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud, @PathParam("key") String key) {

		System.out.println("latitud:" + latitud + " longitud: " + longitud);

		HashSet<SuperLocales> buscaAciertos = CalculoCercania
				.buscaAciertosSupermercados(latitud, longitud,key);

		return buscaAciertos;
	}
	
	@GET
	@Path("/publicidad/{app}/{pagina}/{key}")
	public Publicidad getPublicidad(
			@PathParam("app") String latitud,
			@PathParam("pagina") String longitud, @PathParam("key") String key) {

		System.out.println("latitud:" + latitud + " longitud: " + longitud);
		Publicidad publicidad = new Publicidad();
		publicidad.setUrlImagen("");
		publicidad.setUrlImagen("http://www.genergy.cl/");
		return publicidad;
	}
	
	
	@GET
	@Path("/cercana/{latitud}/{longitud}/{ultanaje}/{metros}/{key}")
	public HashSet<Bencinas> getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("metros") Double metros, @PathParam("key") String key) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " metros: " + metros);

		HashSet<Bencinas> buscaAciertos = CalculoCercania.buscaAciertosBencineras(
				latitud, longitud, ultanaje, metros);

		return buscaAciertos;

	}

	@GET
	@Path("/cercana/{latitud}/{longitud}/{key}")
	public HashSet<Bencinas> getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud, @PathParam("key") String key) {

		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " key: " + key);

		HashSet<Bencinas> buscaAciertos = CalculoCercania.buscaAciertoBencineras(
				latitud, longitud, key);

		return buscaAciertos;

	}

	@GET
	@Path("/trx/{latitud}/{longitud}/{ultanaje}/{empresa}/{latempresa}/{longempresa}/{key}")
	public void getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("empresa") String empresa,
			@PathParam("latempresa") Double latempresa,
			@PathParam("longempresa") Double longempresa,
			@PathParam("key") String key) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " empresa: " + empresa);

		CalculoCercania.registraTrx(latitud, longitud, ultanaje, empresa,
				latempresa, longempresa, key);

	}

	@GET
	@Path("/trx/{latitud}/{longitud}/{ultanaje}/{empresa}/{latempresa}/{longempresa}/{precio}/{distancia}/{key}")
	public void getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("empresa") String empresa,
			@PathParam("latempresa") Double latempresa,
			@PathParam("longempresa") Double longempresa,
			@PathParam("precio") Double precio,
			@PathParam("distancia") Double distancia,
			@PathParam("key") String key) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " empresa: " + empresa+" precio: "+precio+ " distancia:"+distancia);

		CalculoCercania.registraTrx(latitud, longitud, ultanaje, empresa,
				latempresa, longempresa,precio,distancia,key);

	}

	@GET
	@Path("/trx/{latitud}/{longitud}/{ultanaje}/{empresa}/{key}")
	public void getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("empresa") String empresa, @PathParam("key") String key) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " empresa: " + empresa);

		CalculoCercania.registraTrx(latitud, longitud, ultanaje, empresa, 0.0,
				0.0, key);

	}

}
