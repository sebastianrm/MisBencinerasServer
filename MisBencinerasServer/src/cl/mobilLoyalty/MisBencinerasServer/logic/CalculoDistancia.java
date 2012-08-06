package cl.mobilLoyalty.MisBencinerasServer.logic;

public class CalculoDistancia {

	/**
	 * 1 minuto en sistema sexagesimal equivale a 1 milla nautica
	 */
	private static final double millaNauticaEnMetros = 1852;
	/**
	 * 60 minutis sexagecimales equvalen a 1 grado
	 */
	private static final double sesenta = 60;

	public static double calcularVectorMovimiento(double latitudDesde,
			double longitudDesde, double latitudHasta, double longitudHasta) {

		double difAngularLatitud = latitudHasta - latitudDesde;
		double difAngularLongitud = longitudHasta - longitudDesde;

		double distancia = 0;

		if (difAngularLatitud != 0 && difAngularLongitud != 0) {
			double distMetrosLatitud = difAngularLatitud * millaNauticaEnMetros
					* sesenta;
			double distMetrosLongitud = difAngularLongitud
					* millaNauticaEnMetros * sesenta;

			distancia = Math.sqrt(Math.pow(distMetrosLongitud, 2)
					+ Math.pow(distMetrosLatitud, 2));
			return distancia;
		}
		return distancia;

	}

}
