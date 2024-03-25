package Project;

/**
 * Clase hija de Figura que genera la figura circulo.
 * @author Laura Gonzalez Lemos.
 */

public class Circulo extends Figura {

	
	private int radio; 
	private int areaRadio;
	
	private static final double PI = 3.1416;  
	
	
	/**
	 * Metodo constructor que crea un circulo a partir de su radio y color.	
	 * @param radio El radio del circulo.
	 * @param color El color del circulo.
	 */	
	
	 Circulo (int radio, Color color){  
		 if (radio>50) {
			 this.radio = 50;
		 }
		 else if (radio<0) {
			 this.radio = 0;
		 }
		 else {
		this.radio = radio;
		 }
		this.color = color;
			
	 }
	
	 
	 
	 /**
	  * Metodo que calcula el area del circulo de forma porcentual a partir de su radio.		
	  */
	
	public void area () {     
		areaRadio=((int)(PI * this.radio * this.radio))/100;
	
	
	}
	
	
	/**
	 * Metodo que muestra los atributos (radio y color) del circulo.
	 * @return Una cadena con los valores de radio y color.
	 */
	
	public String toString () {     
		return "Radio: " + radio + ", Color: " + color;
	}
	
	
	/**
	 * Metodo boolean  que compara si el circulo del objeto this es el mismo que el circulo del objeto pasado en el argumento del metodo.
	 * @param figura La figura que se pasa como argumento.
	 * @return true si los atributos de círculo son iguales.
	 * @return false si los atributos son distintos.
	 */
	
	public boolean esIgual (Figura figura) {   
		if((this.radio == ((Circulo)figura).radio)&&(this.color == ((Circulo)figura).color)){
			return true;
			
		}
		else {
			
			return false;
		}
	}
	
	
	//Getters and setters
	
	
	
	/**
	 * Metodo getter relativo al radio del circulo.		
	 * @return el valor del radio.
	 */
	
	public int getRadio () {     
	return this.radio;
	}
	
	/**
	 * Metodo setter relativo al radio del circulo.		
	 * @param radio El valor del radio.
	 */
	public void setRadio (int radio) {    
		 if (radio>50) {
			 this.radio = 50;
		 }
		 else if (radio<0) {
			 this.radio = 0;
		 }
		 else {
		this.radio = radio;
		 }
	}
	
	/**
	 * Metodo getter relativo al area del circulo  .		
	 * @return el area del circulo.
	 */
	
	public int getAreaRadio() {   
		
		return this.areaRadio;
	}
	
	/**
	 * Metodo setter relativo al area del circulo
	 * @param areaRadio El valor del area del circulo.
	 */
	
	public void setAreaRadio(int areaRadio) {
		this.areaRadio = areaRadio;
	}
	
	/**
	 * Metodo getter relativo al color del circulo.
	 * @return el color del circulo.
	 */
	
	
	
	}
