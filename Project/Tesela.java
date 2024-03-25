package Project;

/**
 * Clase que genera las teselas.
 * @author Laura Gonzalez Lemos.
 *
 */
public class Tesela implements Luminosity{
	
	// Atributos
	
	private Color color;
	private static int wTesela;
	private static int hTesela;    
    private String posicion;
	public static String R; //pegada al lado derecho
	public static String U; //pegada arriba
	public static String C; //centrada
	public static String D; //pegada abajo
	public static String L; //pegada al lado izquierdo
	private Figura figura;
	private int estado;
	private int luminosityChange;  
	

	
	// Métodos
	
	/**
	 * 	Metodo constructor que crea una tesela (la cual tiene figura) a partir de su figura, color, posicion y estado.
	 * @param figura El tipo de figura que forma parte de la tesela.
	 * @param color El color de la tesela.
	 * @param posicion La posicion de la tesela.
	 * @param estado El estado de la tesela (encendido, apagado y figura apagada).
	 
	 */
	 
	public Tesela (Figura figura, Color color, String posicion, int estado) {    // Tesela con figura
	   this.figura= figura;
	   this.color = color;
	   this.posicion = posicion ;
	   this.estado = estado;
	   this.luminosityChange = 0;
	 
	  }
	 
	
	
	/**
	 * Metodo constructor que crea una tesela (la cual no tiene figura) a partir de su color y estado.
	 * @param color El color.
	 * @param estado El estado de la tesela (encendido, apagado y figura apagada).
	 */
	
	public Tesela (Color color, int estado) {             // Tesela vacía
		this.color = color;
		this.estado = estado;
		this.luminosityChange = 0;
	}
	
	
	
	/**
	* Metodo que comprueba si la tesela tiene figura.
	* @return true si tiene figura.
	* @return false si no tiene.
	*/
	
	public boolean tieneFigura () {
		
		if (this.figura != null) {
			return true;
		}
		
		else {
			return false;
		}	
	
	}	
	
	
	
	
	/**
	 * Metodo que muestra el valor de los atributos de tesela.
	 * @return La cadena con los valores de la tesela.		
	 */
	
	public String toString() {
				
			if((this.figura instanceof Rectangulo)&&(this.posicion!= null)){
			return "Posicion: " + posicion + ", Color: "+ color + ", Rectangulo: " + figura;
		}
			
			
		if ((this.figura instanceof Circulo)&&(this.posicion!= null)){
			return "Posicion: " + posicion + ", Color: "+ color + ", Circulo: " + figura;
		}
		
		if((this.figura instanceof Triangulo)&&(this.posicion!= null)){
			return "Posicion: " + posicion + ", Color: "+ color + ", Triangulo: " + figura;
		}
		
		
		else {
			return " Color: " + color;
		}
		
	}
	
	
	
	/**
	 * Metodo que se utiliza para cambiar el estado de una tesela.	
	 * @param estado El nuevo estado.
	 */
	
	public void changeStatus (int estado) {
		
		this.estado = estado;
	 }

	
	
	
	/**
	 * Metodo que se utiliza para cambiar la luminosidad de una tesela.
	 * @param luminosidad El valor de la luminosidad que se utilizara para variar los valores RGB de color.	
	 */
	
	public void changeLuminosity(int luminosidad) {
	
	
		this.color.setB((this.color.getB()+ luminosidad)%256);
		this.color.setG((this.color.getG()+luminosidad)%256);
		this.color.setR((this.color.getR()+luminosidad)%256);
		
		
		if (this.color.getB() <0 ) {
			
			this.color.setB(this.color.getB()+256);
		}
		
		if  (this.color.getG()<0) {
			
			this.color.setG(this.color.getG()+ 256);
		}
		
		if (this.color.getR()<0) {
			
			this.color.setR(this.color.getR()+ 256);
		}
			

		
		if(this.tieneFigura()) {
			
		getFigura().color.setB((getFigura().color.getB()+ luminosidad)%256);
		getFigura().color.setG((getFigura().color.getG()+ luminosidad)%256);
		getFigura().color.setR((getFigura().color.getR()+ luminosidad)%256);
		
		
		if (getFigura().color.getB()<0 ) {
			getFigura().color.setB(getFigura().color.getB()+ 256);
		}
		
		if  (getFigura().color.getG()<0 ) {
			
			getFigura().color.setG(getFigura().color.getG()+ 256);
	
		}

		if (getFigura().color.getR()<0 ) {
			
			getFigura().color.setR(getFigura().color.getR()+ 256);
		}
		
	}
		}
	
	
	


		/**
		 * Metodo que da los valores de la altura y la anchura de la tesela.		
		 * @param w, la anchura. 
		 * @param h, la altura.
		 */
		
		public static void SetTamano (int w, int h ) {
			wTesela = w;
			hTesela = h;
		}
		
		
		
		//Getters and Setters
		
		
		
		/**
		 * Metodo getter relativo al ancho de la tesela.		
		 * @return el ancho de la tesela.
		 */
		
			public static int getAncho() {
				return Tesela.wTesela;
					}
			
			/**
			 * Metodo setter relativo al ancho de la tesela.		
			 * @param wTesela El ancho de la tesela.
			 */
			
			public static void setAncho(int wTesela) {
				Tesela.wTesela = wTesela;
			}
			
			/**
			 * Metodo getter relativo a la altura de la tesela .			
			 * @return la altura de la tesela.
			 */
			
		    public static int getAlto() {
		    	return Tesela.hTesela;
		    }
		    
		    /**
			 * Metodo setter relativo a la altura de la tesela.		
			 * @param hTesela La altura de la tesela.
			 */
			
		    
		    public static void setAlto(int hTesela) {
				Tesela.hTesela = hTesela;
			}
		    
		    
		    /**
		     * Metodo getter relativo al color de la tesela .
		     * @return el color.
		     */

			public Color getColor() {
				return this.color;
			}

			/**
			 * Metodo setter relativo al color de la tesela .
			 * @param color El valor del color.
			 */
			
			public void setColor(Color color) {
				this.color = color;
			}
			
			/**
			 * Metodo getter relativo al estado de la tesela.
			 * @return el estado de la tesela.
			 */

			public int getEstado() {
				return this.estado;
			}
			
			/**
			 * Metodo setter relativo al estado de la tesela.
			 * @param estado El valor del estado.
			 */

			public void setEstado(int estado) {
				this.estado = estado;
			}
			
			/**
			 * Metodo getter relativo a la figura de la tesela.
			 * @return la figura.
			 */

			public Figura getFigura() {
				return this.figura;
			}
			
			/**
			 * Metodo setter relativo a la figura de la tesela.
			 * @param figura La figura de la tesela.
			 */

			public void setFigura(Figura figura) {
				this.figura = figura;
			}
			
			/**
			 *Metodo getter relativo a la posicion de la tesela.
			 * @return la posicion de la tesela.
			 */
			
			public String getPosicion () {
				return this.posicion;
				
			}

			/**
			 * Metodo setter relativo a la posicion de la tesela.
			 * @param posicion El valor de la posicion.
			 */
			
			public void setPosicion(String posicion) {
				this.posicion = posicion;
			}
		
			
	}
