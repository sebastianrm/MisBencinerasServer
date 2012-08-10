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

/**
 * @author Administrador
 * 
 */
@Produces("application/json")
public class BencinerasCercanasWS {

	@GET
	@Path("/cercana/{latitud}/{longitud}/{ultanaje}/{metros}/{key}")
	public HashSet<Bencinas> getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("metros") Double metros, @PathParam("key") String key) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " metros: " + metros);

		HashSet<Bencinas> buscaAciertos = CalculoCercania.buscaAciertos(
				latitud, longitud, ultanaje, metros);

		return buscaAciertos;

	}

	@GET
	@Path("/cercana/{latitud}/{longitud}/{key}")
	public HashSet<Bencinas> getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud, @PathParam("key") String key) {

		System.out.println("latitud:" + latitud + " longitud: ");

		HashSet<Bencinas> buscaAciertos = CalculoCercania.buscaAciertos(
				latitud, longitud);

		return buscaAciertos;

	}
	
	
	@GET
	@Path("/trx/{latitud}/{longitud}/{ultanaje}/{empresa}/{latempresa}/{longempresa}/{key}")
	public void getPredictor(
			@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("empresa") String empresa,
			@PathParam("latempresa") Double latempresa,
			@PathParam("longempresa") Double longempresa,
			@PathParam("key") String key) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " empresa: " + empresa);

		CalculoCercania.registraTrx(latitud, longitud, ultanaje, empresa,latempresa,longempresa,key);


	}
	

}
