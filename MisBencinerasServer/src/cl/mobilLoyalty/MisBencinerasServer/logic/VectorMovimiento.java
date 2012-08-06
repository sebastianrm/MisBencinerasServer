/**
 * 
 */
package cl.mobilLoyalty.MisBencinerasServer.logic;


/**
 * @author Administrador
 * 
 */
public class VectorMovimiento {

	/**
	 * 1 minuto en sistema sexagesimal equivale a 1 milla nautica
	 */
	private static final double millaNauticaEnMetros = 1852;
	/**
	 * 60 minutis sexagecimales equvalen a 1 grado
	 */
	private static final double sesenta = 60;

	/**
	 * dato en degrees y separador de decimales '.'
	 */
	private double latitudDesde;
	/**
	 * dato en degrees y separador de decimales '.'
	 */
	private double latitudHasta;
	/**
	 * dato en degrees y separador de decimales '.'
	 */
	private double longitudDesde;
	/**
	 * dato en degrees y separador de decimales '.'
	 */
	private double longitudHasta;

	/**
	 * Calculada en Metros
	 */
	private double distancia;
	// private static final String unidadMedidaDistancia = "metros";

	private double anguloRadianes;
	private double anguloGradianes;

	private static final double noventaGradosRadianes = Math.PI / 2;

	/**
	 * posicion 0 a el mediano de greenwich o eje x . posicion 1 respecto es
	 * respecto a linea del ecuador o eje Y
	 */
	private double[] vectorMovimientoMetros = new double[2];

	public VectorMovimiento(double latitudDesde, double latitudHasta,
			double longitudDesde, double longitudHasta) {
		super();
		this.latitudDesde = latitudDesde;
		this.latitudHasta = latitudHasta;
		this.longitudDesde = longitudDesde;
		this.longitudHasta = longitudHasta;
		calcularVectorMovimiento();

	}

	public VectorMovimiento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * 
	 * 
	 */
	public void calcularVectorMovimiento() {

		double difAngularLatitud = latitudHasta - latitudDesde;
		double difAngularLongitud = longitudHasta - longitudDesde;

		if (difAngularLatitud != 0 && difAngularLongitud != 0) {
			double distMetrosLatitud = difAngularLatitud * millaNauticaEnMetros
					* sesenta;
			double distMetrosLongitud = difAngularLongitud * millaNauticaEnMetros
					* sesenta;
			vectorMovimientoMetros[0] = distMetrosLongitud;
			vectorMovimientoMetros[1] = distMetrosLatitud;

			distancia = Math.sqrt(Math.pow(distMetrosLongitud, 2)
					+ Math.pow(distMetrosLatitud, 2));

			// Existen 4 casos para realizar en calculo del angulo en el plano
			// cartesiano.
			// se deve considerar que el angulo es tomado respecto al eje X.
			
			
			
			
			// si en angulo se encuentra en el primer cuadrante X es Positivo e
			// Y positivo
			// el calculo del angulo es directo
			double abs = Math.abs(distMetrosLongitud/ distancia);
			anguloRadianes = Math.acos(abs);


			// si el angulo es calculado en el segundo cuadrante X negativo e Y
			// positivo
			if (vectorMovimientoMetros[0] <= 0 && vectorMovimientoMetros[1] >= 0) {
				
				anguloRadianes = noventaGradosRadianes + noventaGradosRadianes
						- anguloRadianes;

			} else

			// si el angulo es calculado en el Tercer cuadrante X negativo e Y
			// negativo
			if (vectorMovimientoMetros[0] <= 0 && vectorMovimientoMetros[1] <= 0) {
				
				anguloRadianes = noventaGradosRadianes + noventaGradosRadianes
						+ noventaGradosRadianes - anguloRadianes;

			} else
			// si el angulo es calculado en el Cuarto cuadrante X positivo e Y
			// negativo

			if (vectorMovimientoMetros[0] >= 0 && vectorMovimientoMetros[1] <= 0) {
				
				anguloRadianes = noventaGradosRadianes + noventaGradosRadianes
						+ noventaGradosRadianes + noventaGradosRadianes
						- anguloRadianes;

			}

			// calculo el angulo en degrees
			anguloGradianes = Math.toDegrees(anguloRadianes);

		}

	}

	public static double getMillanauticaenmetros() {
		return millaNauticaEnMetros;
	}

	public static double getSesenta() {
		return sesenta;
	}

	public double getDistancia() {
		return distancia;
	}

	public double getAnguloRadianes() {
		return anguloRadianes;
	}

	public double getAnguloGradianes() {
		return anguloGradianes;
	}

	public static double getNoventagradosradianes() {
		return noventaGradosRadianes;
	}

	public double[] getVectorMovimientoMetros() {
		return vectorMovimientoMetros;
	}

	public double getLatitudDesde() {
		return latitudDesde;
	}

	public void setLatitudDesde(double latitudDesde) {
		this.latitudDesde = latitudDesde;
	}

	public double getLatitudHasta() {
		return latitudHasta;
	}

	public void setLatitudHasta(double latitudHasta) {
		this.latitudHasta = latitudHasta;
	}

	public double getLongitudDesde() {
		return longitudDesde;
	}

	public void setLongitudDesde(double longitudDesde) {
		this.longitudDesde = longitudDesde;
	}

	public double getLongitudHasta() {
		return longitudHasta;
	}

	public void setLongitudHasta(double longitudHasta) {
		this.longitudHasta = longitudHasta;
	}

}
