/**
 * 
 */
package cl.mobilLoyalty.MisBencinerasServer.logic;

import java.util.HashSet;
import java.util.Iterator;

import cl.mobilLoyalty.MisBencinerasServer.data.dao.BencinasDao;
import cl.mobilLoyalty.MisBencinerasServer.data.dto.Bencinas;

/**
 * @author Administrador
 * 
 */
public class CalculoCercania {

	/**
	 * @param args
	 */

	public static HashSet<Bencinas> buscaAciertos(Double lat, Double lng,
			String ultanaje, Double metros) {

		// re cupero una coneccion a la base de datos

		// recupero todo

		BencinasDao rlDAO = new BencinasDao();

			HashSet<Bencinas> loadAll = rlDAO.selectLatLogCeroHash();

			System.out.println("ANTES lat del hash: " + loadAll.size());
			arregloLocalesCercanos(lat, lng, loadAll,metros,ultanaje);
			System.out.println("DESPUES Largo del hash: " + loadAll.size());

			return loadAll;

	}

	/**
	 * 
	 * @param latitud
	 * @param longitud
	 * @param loadAll
	 */
	private static void arregloLocalesCercanos(Double latitud, Double longitud,
			HashSet<Bencinas> loadAll, Double metros,String ultanaje) {
		// Creo arrglo con locales cercanos
		Iterator<Bencinas> iterator = loadAll.iterator();

		HashSet<Bencinas> quitar = new HashSet<Bencinas>();

		// REcupero los locales mas cercanos
		while (iterator.hasNext()) {
			Bencinas next = iterator.next();

			double calcularVectorMovimiento;

			if (next.getServiCentro().getGeoRef().getLatitud() != 0
					&& next.getServiCentro().getGeoRef().getLongitud() != 0) {
				
				calcularVectorMovimiento = CalculoDistancia
						.calcularVectorMovimiento(latitud, longitud, next.getServiCentro()
								.getGeoRef().getLatitud(), next.getServiCentro().getGeoRef()
								.getLongitud());
				next.setDistancia(calcularVectorMovimiento);
				
				// si no se encuentra en el rango, se quita del arrego
				if (calcularVectorMovimiento > metros || !next.getDescripcion().equals(ultanaje.toString())) {
					quitar.add(next);
				}else{
					System.out.println();
				}
			}
		}
		System.out.println("Cantidad a quitar: " + quitar.size());
		loadAll.removeAll(quitar);

	}

}
