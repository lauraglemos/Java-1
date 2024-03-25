package Project;

/**
 * Interfaz que genera los cambios de la luminosidad del mosaico, de las teselas y de las regiones. Esta implementado en Tesela, RegionRectangular y Mosaico.
 * @author Laura Gonzalez Lemos.
 *
 */

public interface Luminosity{
	
	/**
	 * Metodo abstracto que sirve para variar la luminosidad del mosaico, region o tesela.
	 * @param luminosidad El valor que varia los valores originales del color.
	 */
	
	public abstract void changeLuminosity(int luminosidad);


}