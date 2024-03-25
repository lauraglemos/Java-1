package Project;

/**
 * Clase abstracta que genera la figura de la tesela, que puede ser un circulo, un rectangulo o un triangulo.
 * @author Laura Gonzalez Lemos
 *
 */

public abstract class Figura {

	
	/**
	 * Metodo constructor de la clase figura.
	 */
	public Figura() {
		
	}
	

		public Color color;
		
		/**
		 * Metodo abstracto que calcula el area de la figura.		
		 */
		
		public abstract void area();
		
		/**
		 * Metodo abstracto que se usa para mostrar los atributos de la figura.
		 */
		
		public abstract String toString();
		
		/**
		 * Metodo abstracto que comprueba si las figuras son iguales o no.
		 * @param figura La figura que se pasa como argumento.
		 * @return true si son iguales.
		 * @return false si son distintas.
		 */
		
		public abstract boolean esIgual(Figura figura);

		/**
		 * Metodo getter relativo al color de la figura.
		 * @return color, el color de la figura.
		 */
		
		public Color getColor() {
			return color;
		}

		/**
		 * Metodo setter relativo al color de la figura.
		 * @param color El color de la figura.
		 */
		
		public void setColor(Color color) {
			this.color = color;
		}
	

}