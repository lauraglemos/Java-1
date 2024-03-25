package Project;

/**
 * Clase hija de Figura que genera la figura rectangulo .
 * @author Laura Gonzalez Lemos.		
 *
 */

public class Rectangulo extends Figura {

		
		private int base;
		private int altura;
		private int areaRectangulo;
		

		
		/**
		*Metodo constructor que crea un rectangulo a partir de su color, su base y su altura.
		*@param base La base del rectangulo.
		*@param altura La altura del rectangulo.
		*@param color El color del rectangulo.
		*/
		
		public Rectangulo(int base, int altura, Color color) {
			
			 if(base > 100) {
			        this.base = 100;
			 }
			 
			 else if(base < 0) {
			        this.base = 0;
			 }
			 
			 else {
			        	
			          this.base = base;
			 }
			 
	         if(altura > 100) {
	        	 
			        this.altura = 100;
	         }
	         
			  else if(altura < 0) {
			        	
			        this.altura = 0;
			        
		     }
			        
			  else {
			        this.altura= altura;
			  }
			this.color = color;
		
		}
		
	
		
		/**
		 * Metodo que calcula el area del rectangulo de forma porcentual a partir de su base y altura.		
		 */
		
		public void area() {
			 areaRectangulo = (this.base * this.altura)/100;
			 
			
		}
		
		
		/**
		 * Metodo que muestra el valor de los atributos(base, altura y color) del rectangulo.
		 * @return Una cadena con los valores del rectangulo.		
		 */
		
		public String toString () {
			return "Base: " + base + ", Altura: " + altura + ",Color: " + color;
			
		}
		
		
		/**
		 * Metodo boolean que compara si el rectangulo del objeto this es el mismo que el rectangulo del objeto pasado en el argumento del metodo.	
		 * @param figura La figura que se pasa como argumento.
		 * @return  true si los atributos del rectangulo son iguales.
		 * @return false si los atributos son distintos.
		 */
			
		public boolean esIgual (Figura figura) {   
			if((this.base == ((Rectangulo)figura).base)&&(this.altura == ((Rectangulo)figura).altura)&&(this.color == ((Rectangulo)figura).color)){
				return true;
				
			}
			else {
				return false;
			}
		}
		
		
		
		//Getters and setters
		
		
		/**
		 * Metodo getter relativo a la base del rectangulo.		
		 * @return la base del rectangulo.
		 */
		
		public int getBase (){
			
			return this.base;
		}
		
		/**
		 * Metodo setter relativo a la base del rectangulo.		
		 * @param base El valor de la base.
		 */
		
		public void setBase (int base) {
			
			if(base > 100) {
		        this.base = 100;
		 }
		 
		 else if(base < 0) {
		        this.base = 0;
		 }
		 
		 else {
		        	
		          this.base = base;
		 }
		 
		}
		
		/**
		 * Metodo getter relativo a la altura del rectangulo .
		 * @return la altura del rectangulo.
		 */
		
		public int getAltura() {
			return this.altura;
		}
		
		/**
		 * Metodo setter relativo a la altura del rectangulo.
		 * @param altura El valor de la altura.
		 */
		
		public void setAltura (int altura){
			 if(altura > 100) {
	        	 
			        this.altura = 100;
	         }
	         
			  else if(altura < 0) {
			        	
			        this.altura = 0;
			        
		     }
			        
			  else {
			        this.altura= altura;
			  }
		}
		
		
		/**
		 * Metodo getter relativo al area del rectangulo.		
		 * @return el area del rectangulo.
		 */
		
		public int getAreaRectangulo() {
			return this.areaRectangulo;
		}
		
		/**
		 * Metodo setter relativo al area del rectangulo
		 * @param areaRectangulo El valor del area del rectangulo.
		 */

		public void setAreaRectangulo(int areaRectangulo) {
			this.areaRectangulo = areaRectangulo;
		}
		

	}