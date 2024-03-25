package Project;


/**
 * Clase hija de Figura que genera la figura triangulo .
 * @author Laura Gonzalez Lemos.		
 *
 */

public class Triangulo extends Figura {
	
	private int base;
	private int altura;
	private int areaTriangulo;
	

	
	/**
	*Metodo constructor que crea un triangulo a partir de su color, su base y su altura.
	*@param base La base del triangulo.
	*@param altura La altura del triangulo.
	*@param color El color del triangulo.
	*/
	
	public Triangulo(int base, int altura, Color color) {
		
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
	 * Metodo que calcula el area del triangulo de forma porcentual a partir de su base y altura.		
	 */
	
	public void area() {
		 areaTriangulo = (this.base * this.altura)/(2*100);
		 
		
	}
	
	/**
	 * Metodo que muestra el valor de los atributos(base, altura y color) del triangulo.
	 * @return Una cadena con los valores del triangulo.		
	 */
	
	public String toString () {
		return "Base: " + base + ", Altura: " + altura + ",Color: " + color;
		
	}
	
	/**
	 * Metodo boolean que compara si el triangulo del objeto this es el mismo que el triangulo del objeto pasado en el argumento del metodo.	
	 * @param figura La figura que se pasa como argumento.
	 * @return  true si los atributos del triangulo son iguales.
	 * @return false si los atributos son distintos.
	 */
		
		
	public boolean esIgual (Figura figura) {   
		if((this.base == ((Triangulo)figura).base)&&(this.altura == ((Triangulo)figura).altura)&&(this.color == ((Triangulo)figura).color)){
			return true;
			
		}
		else {
			return false;
		}
	}
	
	
	//Getters and Setters
	
	
	/**
	 * Metodo getter relativo a la base del triangulo.		
	 * @return la base del triangulo.
	 */
	
	public int getBase (){
		
		return this.base;
	}
	
	
	/**
	 * Metodo setter relativo a la base del triangulo.		
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
	 * Metodo getter relativo a la altura del triangulo .
	 * @return la altura del triangulo.
	 */
	
	
	public int getAltura() {
		return this.altura;
	}
	
	/**
	 * Metodo setter relativo a la altura del triangulo.
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
	 * Metodo getter relativo al area del triangulo.		
	 * @return el area del triangulo.
	 */
	
	public int getAreaTriangulo() {
		return this.areaTriangulo;
	}
	
	/**
	 * Metodo getter del triangulo relativo a su color.
	 * @return el color del triangulo.
	 */

	
	
	/**
	 * Metodo setter relativo al area del triangulo
	 * @param areaTriangulo El valor del area del triangulo.
	 */

	public void setAreaTriangulo(int areaTriangulo) {
		this.areaTriangulo = areaTriangulo;
	}


}