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
	@Path("/cercana/{latitud}/{longitud}/{ultanaje}/{metros}")
	public HashSet<Bencinas> getPredictor(@PathParam("latitud") Double latitud,
			@PathParam("longitud") Double longitud,
			@PathParam("ultanaje") String ultanaje,
			@PathParam("metros") Double metros) {

		ultanaje = ultanaje.replaceAll("%20", " ");
		System.out.println("latitud:" + latitud + " longitud: " + longitud
				+ " ultanaje: " + ultanaje + " metros: " + metros);

		HashSet<Bencinas> buscaAciertos = CalculoCercania.buscaAciertos(
				latitud, longitud, ultanaje, metros);

		return buscaAciertos;

	}

}
