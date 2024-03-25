package Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Clase que genera el color de los elementos del mosaico.
 * @author Laura Gonzalez Lemos.
 *
 */

public class Color {

	
		private int r;
		private int g;
		private int b;
		
		private static final int MAX = 255;

		
		/**
		 * Metodo constructor que crea el color de la figura de acuerdo al estándar RGB.
		 * @param r El color rojo (red).
		 * @param g El color verde (green).
		 * @param b El color azul (blue).
		 * @exception ColorException Excepcion que se lanza cuando alguno de los valores es mayor de 255.
		 */
				
		 public Color (int r, int g, int b){
			
			try {
			
			if((r > MAX) || (g >MAX) ||(b >MAX)) {
				this.r = MAX;
				this.g = MAX;
				this.b = MAX;
				
				throw new ColorException();
				
			}
			
			else {
				this.r = r;
				this.g = g;
				this.b = b;
				
			}
		}
			catch(ColorException e) {
			
			 PrintWriter error=null;
				
				try {
					 
				error = new PrintWriter(new FileOutputStream (new File ("Project/error.txt")));
			
				}
				
				catch (FileNotFoundException e1) {                       
					System.exit(-1);                                         
				}
				
				error.print("ColorException");
				error.close();
			}
		}
		
		
		
		/**
		 * Metodo que genera el color blanco.		
		 * @return El color blanco con sus valores.
		 */
		
		public static final Color BLANCO() {
			return new Color (255,255,255);
			
		}
		
		/**
		 * Metodo que genera el color negro.
		 * @return El color negro con sus valores.
		 */		
		
		public static final Color NEGRO () {
			return new Color (0,0,0);
			
		}
		
		/**
		* Metodo que genera el color rojo.
		* @return El color rojo con sus valores.
		*/

		public static final Color ROJO () {
			return new Color(255,0,0);
			
		}
		
		/**
		* Metodo que genera el color azul.
		* @return El color azul con sus valores.	
		*/

		public static final Color AZUL () {
			return new Color(0,0,255);
			
		}
		
		/**
		* Metodo que genera el color verde.
		* @return El color verde con sus valores.
		*/

		public static final Color VERDE () {
			return new Color(0,255,0);
			
		}
		
		/**
		* Metodo que genera el color amarillo.
		* @return El color amarillo con sus valores.
		*/

		public static final Color AMARILLO () {
			return new Color(255,255,0);
			
		}
		
		/**
		* Metodo que genera el color cyan.
		* @return El color cyan con sus valores.
		*/

		public static final Color CYAN () {
			return new Color(0,255,255);

		}
		
		/**
		* Metodo que genera el color magenta.
		* @return El color magenta con sus valores.
		*/

		public static final Color MAGENTA () {
			return new Color(255,0,255);
			
		}
		

		/**
		 * Metodo boolean que compara  si el color del objeto this es el mismo que el color del objeto pasado en el argumento del metodo.
		 * @param color El color
		 * @return true si los atributos de color son iguales.
		 * @return false si son distintos.
		 */
		
		public boolean esIgualA (Color color) { 
			if ((this.r==color.r )&& (this.g==color.g) && (this.b==color.b)) {
				
				return true;
			}
			
			else {
				
				return false;
			}

		}
		

		/**
		 * Metodo que muestra los atributos de color.
		 * @return La cadena con los valores RGB del color.
		 */
		public String toString () {
			return "R"+r+"G"+g+"B"+b;

		}
		
		
		

		// Getters y Setters
		/**
		 * Metodo getter del color rojo.
		 * @return el color rojo.
		 */

		public int getR () {
			return this.r;
			
		}
		
		/**
		 * Metodo getter del color verde.
		 * @return el color verde.
		 */

		public int getG () {
			return this.g;
			
		}
		
		/**
		 * Metodo getter del color azul.
		 * @return el color azul.
		 */

		public int getB () {
			return this.b;
			
		}
		
		/**
		 * Metodo setter del color rojo.		
		 * @param r El color rojo.
		 */

		public void setR(int r) {
			this.r = r;
		}
		
		/**
		 * Metodo setter del color verde.		
		 * @param g El color verde.
		 */

		public void setG(int g) {
			this.g = g;
		}
		
		/**
		 * Metodo setter del color azul.		
		 * @param b El color azul.
		 */

		public void setB(int b) {
			this.b = b;
		}

		
	}