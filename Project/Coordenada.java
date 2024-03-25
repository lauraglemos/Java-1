package Project;

import java.lang.Comparable;

/**
 * Clase que genera las coordenadas que tiene cada region del mosaico.
 * @author Laura Gonzalez Lemos.		
 *
 */
public class Coordenada implements Comparable <Coordenada> {                       
	
	//Atributos
	
		private int fila;
		private int columna;
		
		
		//Constructor
		
		/**
		 * 	Metodo constructor que crea las coordenadas a partir de filas y columnas.
		 * @param fila Numero de filas.
		 * @param columna Numero de columnas.
		 */
		
		Coordenada (int fila, int columna) {
			this.fila = fila;
			this.columna = columna;
		}
		
		/**
		 * Metodo que compara la coordenada y otra que se pasa como parametro fila por fila y columna por columna, y las ordena de forma ascendente.
		 * @return 0 si las filas y columnas son iguales.
		 * @return -1 si las filas y columnas son menores.
		 * @return 1 si las filas y columnas son mayores.
		 */
		
		public int compareTo(Coordenada o) {
			if (this.fila <o.getFila()) return -1;
			
			else if (this.fila == o.getFila()) {
				
				if (this.columna <o.getColumna()) return -1;
				
				else if (this.columna == o.getColumna()) return 0;
				
			}
			
			return 1;
		}
		

		/**
		 * Metodo que muestra los valores de los atributos de la coordenada( filas y las columnas).
		 * @return la cadena con los atributos.
		 */
		
		public String toString() {
			return "(" + this.fila + ","+this.columna + ")";
		}
		
		/**
		 * Metodo que compara si la coordenada del objeto this es la misma que la coordenada del objeto pasado en el argumento del metodo.	
		 * @param o Coordenada que se pasa como parametro.
		 * @return true, si las filas y columnas son iguales.
		 * @return false, si son distintas.
		 */
		
		public boolean esIgual (Coordenada o) {
			if ((this.fila == o.getFila())&& (this.columna == o.getColumna())) {
				return true;
			}
			else {
				return false;
			}
			}
		
		
		
		//Getters and Setters

		/**
		 * Metodo getter relativo a la fila de la coordenada.
		 * @return la fila.
		 */
		
		public int getFila() {
			return this.fila;
		}

		/**
		 * Metodo setter  relativo a la fila de la coordenada.
		 * @param fila El valor de la fila.
		 */
		
		public void setFila(int fila) {
			this.fila = fila;
		}

		/**
		 * Metodo getter relativo a la columna de la coordenada.
		 * @return la columna.
		 */
		
		public int getColumna() {
			return this.columna;
		}


		/**
		 * Metodo setter relativo a la columna de la coordenada.
		 * @param columna El valor de la columna.
		 */
		
		public void setColumna(int columna) {
			this.columna = columna;
		}

	}