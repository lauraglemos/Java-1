package Project;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;


/**
 * Clase que genera el mosaico.
 * @author Laura Gonzalez Lemos.		
 *
 */

public class Mosaico implements Luminosity {
	
	
	private int filas;
	private int columnas;
	private int anchoTesela;
	private int altoTesela;
	private int posicionX;
	private int posicionY;
	private int estado;
	private List <RegionRectangular> regiones;                       
	private TreeMap<Coordenada, Tesela> mosaico = new TreeMap <Coordenada, Tesela>();

	
	
	
	/**
	 * Metodo constructor que lee el fichero (antes comprueba que existe) y crea teselas por cada linea, siempre que sea posible, hasta acabar.	
	 * @param fichero El fichero donde estan declaradas las teselas.
	 */
	
		Mosaico (String fichero) { 
			
		Scanner entrada = null;								
		
		try {
			entrada = new Scanner(new FileInputStream(fichero));  
			
		} 
		
		catch (FileNotFoundException e) {   
			
			PrintWriter error=null;
			
			try {
			error = new PrintWriter(new FileOutputStream (new File ("Project/error.txt"))); 
												
			}
			catch (FileNotFoundException e1) {                        
				System.exit(-1);                                         
			}
			
			error.print("FileNotFoundException");
			error.close();
			System.exit(-1);
			
		}
			                                        
		
		
		
		String linea= null;	
		
        int nLinea = 0;
        
        
		while (entrada.hasNextLine()) {                              
			
			linea = entrada.nextLine();								
			 
				 
			if( !linea.startsWith("*")) { 
				           
				
				if (nLinea ==0) {
					
					primeraLinea(linea);
					
					
				}
				
				else {
					
					crearTeselas(linea);
				}
				nLinea ++;
			}
			
			
			}
							                                               

				entrada.close();
			}
		
		
		/**
		 * Metodo con el cual se lee la primera linea del fichero, donde estan los atributos del mosaico.
		 * @param linea El String que corresponde a la primera linea.
		 */
			
				private void primeraLinea(String linea) {																			
					
					if (linea.length() >0) {
						
					linea = linea.trim();
		
					String tamanoMosaico = linea.substring(0,linea.indexOf(","));  
					
					String tamanoTesela = linea.substring(linea.indexOf(",")+1,linea.length());
					
					this.filas=  Integer.parseInt (tamanoMosaico.substring(0, tamanoMosaico.indexOf("x")));
				    this.columnas=  Integer.parseInt (tamanoMosaico.substring(tamanoMosaico.indexOf("x")+1,tamanoMosaico.length()));
					
				
			    this.anchoTesela=  Integer.parseInt (tamanoTesela.substring(0, tamanoTesela.indexOf("x")));
			     this.altoTesela=  Integer.parseInt (tamanoTesela.substring(tamanoTesela.indexOf("x")+1,tamanoTesela.length()));
					
			   
				}
					 this.inicializar();
				}
				
				
				
				/**
				 * Metodo que coge el resto de lineas del fichero, con las cuales crea las teselas que forman el mosaico.
				 * @param linea El String que corresponde a la linea.
				 * @exception TileOutOfBoundsException Excepcion que se lanza en caso de encontrar en el fichero una tesela definida fuera del rango del mosaico, es decir, fuera de (1,1).
				 * @exception FileNotFoundException Excepcion que se lanza cuando no se encuentra el fichero.
				 */	
						
				
				private void crearTeselas(String linea) {
					
					if(this.mosaico == null) {
						this.mosaico = new TreeMap <Coordenada, Tesela>();
					}
					
				
					if (linea.length()>0) {           
						
						linea.trim();
					int coordAcaba = linea.indexOf(":");
					String coordenada = linea.substring(0,coordAcaba);
					posicionX = Integer.parseInt(coordenada.substring(1,linea.indexOf(",")));     
					posicionY = Integer.parseInt(coordenada.substring(coordenada.indexOf(",")+1,coordenada.length()-1));      
					estado = Integer.parseInt(linea.substring(coordAcaba+1,coordAcaba+2));
					
					
					
					
					  try {
							if (posicionX < 1 ||posicionY <1 || posicionX > this.filas|| posicionY > this.columnas )   
								
								throw new TileOutOfBoundsException();
							
							}catch(TileOutOfBoundsException t) {
									
									PrintWriter error=null;
									
									try {
										
									error = new PrintWriter(new FileOutputStream (new File ("Project/error.txt"))); 
									}
									
									catch (FileNotFoundException e) {                        
										System.exit(-1);                                         
									}
									error.print("TileOutOfBoundsException");   
									error.close();
									System.exit(-1);
								}
					 
					  
					  String caracteristicas = linea.substring(linea.indexOf("{")+1,linea.indexOf("}"));    
					  caracteristicas = caracteristicas.trim();
					  caracteristicas = caracteristicas.replace(":{", ",");
					  			
						String array []= caracteristicas.split (","); 
						
						
						
						if(array.length==1) {
							String colorTesela =array[0];
							int R = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("R")+1,colorTesela.indexOf("G")));
							
							int G = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("G")+1,colorTesela.indexOf("B")));
							int B = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("B")+1,colorTesela.length())); 
							Tesela teselaVacia = new Tesela (new Color(R,G,B),estado);
							
							mosaico.put(new Coordenada (posicionX, posicionY),teselaVacia);
							
						
				}
						
						else {
							
								if (caracteristicas.contains("CIR")){                           //si la figura es un círculo
									
									String colorTesela =array[0];
									int R = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("R")+1,colorTesela.indexOf("G")));
									int G = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("G")+1,colorTesela.indexOf("B")));
									int B = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("B")+1,colorTesela.length())); 
									
									
									String colorFigura = array[2];
									int RCirculo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("R")+1,colorFigura.indexOf("G")));
									int GCirculo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("G")+1,colorFigura.indexOf("B")));
									int BCirculo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("B")+1,colorFigura.length()));
									int radio = Integer.parseInt(array[4]);
									
									String posicionCirculo = array[3];
									
									
									
									Tesela teselaCirculo = new Tesela(new Circulo (radio, new Color (RCirculo,GCirculo,BCirculo)),new Color(R,G,B),posicionCirculo,estado);
									
									
									mosaico.put (new Coordenada (posicionX,posicionY),teselaCirculo);
								
									
							
								}
								
								else if (caracteristicas.contains("REC")){                           //si la figura es un rectángulo
									
									String colorTesela =array[0];
									int R = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("R")+1,colorTesela.indexOf("G")));
									int G = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("G")+1,colorTesela.indexOf("B")));
									int B = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("B")+1,colorTesela.length())); 
									
									
									String colorFigura = array[2];
									int RRectangulo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("R")+1,colorFigura.indexOf("G")));
									int GRectangulo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("G")+1,colorFigura.indexOf("B")));
									int BRectangulo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("B")+1,colorFigura.length()));
									int baseRectangulo = Integer.parseInt(array[4]);
									int alturaRectangulo = Integer.parseInt(array[5]);
									
									
									String posicionRectangulo = array[3];
									
									
									Tesela teselaRectangulo = new Tesela(new Rectangulo (baseRectangulo,alturaRectangulo, new Color (RRectangulo,GRectangulo,BRectangulo)),new Color(R,G,B),posicionRectangulo,estado);
									
									
								   mosaico.put (new Coordenada (posicionX,posicionY),teselaRectangulo);
									
								
								}
								
								else if (caracteristicas.contains("TRI")){                           //si la figura es un triángulo
									
									String colorTesela =array[0];
									int R = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("R")+1,colorTesela.indexOf("G")));
									int G = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("G")+1,colorTesela.indexOf("B")));
									int B = Integer.parseInt(colorTesela.substring(colorTesela.indexOf("B")+1,colorTesela.length())); 
									
									
									String colorFigura = array[2];
									int RTriangulo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("R")+1,colorFigura.indexOf("G")));
									int GTriangulo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("G")+1,colorFigura.indexOf("B")));
									int BTriangulo = Integer.parseInt(colorFigura.substring(colorFigura.indexOf("B")+1,colorFigura.length()));
									int baseTriangulo = Integer.parseInt(array[4]);
									int alturaTriangulo = Integer.parseInt(array[5]);
									
									
									String posicionTriangulo = array[3];
									
									
									Tesela teselaTriangulo = new Tesela(new Triangulo(baseTriangulo,alturaTriangulo, new Color (RTriangulo,GTriangulo,BTriangulo)),new Color(R,G,B),posicionTriangulo,estado);
									
									mosaico.put (new Coordenada (posicionX,posicionY),teselaTriangulo);
									
								
					
							}
						}
					}
				}
	
	
	
	
			
					
				
				
		
		/**
		 * Metodo que inicializa el mapa del mosaico con sus coordenadas y teselas. Tambien crea una tesela por defecto.
		 */
	
	public void inicializar() {     
		
	
		
		for (int i =1; i<=filas; i++) {
			for (int j =1; j<=columnas; j++) {
				
				
				
				Tesela teselaPorDefecto = new Tesela (Color.BLANCO(),1);
				
				
					mosaico.put (new Coordenada (i,j),teselaPorDefecto);                    
				
			}
		}
		
		
		
	}
	
	/**
	 * Metodo que muestra la información del mosaico y teselas con sus atributos.
	 * @return datos Una String con toda la informacion.
	 */
	
	public String toString() {
	
		String datos = new String("");
		datos = datos.concat(this.filas+"x"+ this.columnas + ","+this.altoTesela+"x"+ this.anchoTesela +"\n");
		
		
	     
      
		for( Map.Entry<Coordenada, Tesela> entry : this.mosaico.entrySet()){ 
	      	Coordenada coordenada = entry.getKey();
	      	Tesela tesela = entry.getValue();
	      	
	      	if (tesela.getEstado()==2) { 
	       	   if(tesela.getFigura()!= null){
	         		
	         	    if(tesela.getFigura() instanceof Circulo) {  
	         		
	         		datos= datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor()+",CIR:{" + Color.NEGRO().toString() +","+ tesela.getPosicion()+ ","+ ((Circulo)tesela.getFigura()).getRadio()+ "}}\n");
	         		 
	   			}
	         	
	         	if(tesela.getFigura() instanceof Rectangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor() + ",REC:{" +Color.NEGRO().toString() +","+ tesela.getPosicion()+ ","+((Rectangulo)tesela.getFigura()).getBase()+","+((Rectangulo) tesela.getFigura()).getAltura()+ "}}\n");
	         		
	         	}
	         	if(tesela.getFigura() instanceof Triangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor() + ",TRI:{" + Color.NEGRO().toString()+","+ tesela.getPosicion()+ ","+((Triangulo) tesela.getFigura()).getAltura()+","+((Triangulo)tesela.getFigura()).getBase()+ "}}\n");
	         	}
	         	}
	         	else {
	         		
	         	  
	         	    datos = datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor()+"}\n");
	         	 
	         	}
	      		
	      	}
	      
	      
      		
	      	else if (tesela.getEstado()== 3) {
	      		
	       	   if(tesela.getFigura()!= null){
	         		
	         	    if(tesela.getFigura() instanceof Circulo) {  
	         		
	         		datos= datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString()+",CIR:{" + ((Circulo)tesela.getFigura()).getColor()+","+ tesela.getPosicion()+ ","+ ((Circulo)tesela.getFigura()).getRadio()+ "}}\n");
	         		
	         		 
	   			}
	         	
	         	if(tesela.getFigura() instanceof Rectangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString() + ",REC:{" + ((Rectangulo)tesela.getFigura()).getColor()+","+ tesela.getPosicion()+ ","+((Rectangulo)tesela.getFigura()).getBase()+","+((Rectangulo) tesela.getFigura()).getAltura()+ "}}\n");
	         		
	         	}
	         	if(tesela.getFigura() instanceof Triangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString()+ ",TRI:{" + ((Triangulo)tesela.getFigura()).getColor()+","+ tesela.getPosicion()+ ","+((Triangulo) tesela.getFigura()).getAltura()+","+((Triangulo)tesela.getFigura()).getBase()+ "}}\n");
	         	}
	         	}
	         	else {
	         		
	         	  
	         	    datos = datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString()+"}\n");
	         	 
	         	}
      				
      		}
	      	
	    	
	      	else if (tesela.getEstado()== 0) { 
	      		
	       	   if(tesela.getFigura()!= null){
	         		
	         	    if(tesela.getFigura() instanceof Circulo) {  
	         		
	         		datos= datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString()+",CIR:{" + Color.NEGRO().toString()+","+ tesela.getPosicion()+ ","+ ((Circulo)tesela.getFigura()).getRadio()+ "}}\n");
	         		
	         		 
	   			}
	         	
	         	if(tesela.getFigura() instanceof Rectangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString() + ",REC:{" +Color.NEGRO().toString()+","+ tesela.getPosicion()+ ","+((Rectangulo)tesela.getFigura()).getBase()+","+((Rectangulo) tesela.getFigura()).getAltura()+ "}}\n");
	         		
	         	}
	         	if(tesela.getFigura() instanceof Triangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString() + ",TRI:{" + Color.NEGRO().toString()+","+ tesela.getPosicion()+ ","+((Triangulo) tesela.getFigura()).getAltura()+","+((Triangulo)tesela.getFigura()).getBase()+ "}}\n");
	         	}
	         	}
	         	else {
	         		
	         	  
	         	    datos = datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+Color.NEGRO().toString()+"}\n");
	         	 
	         	}
	      		}
	      	else {
	      	   if(tesela.getFigura()!= null){
	         		
	         	    if(tesela.getFigura() instanceof Circulo) {  
	         		
	         		datos= datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor()+",CIR:{" + ((Circulo)tesela.getFigura()).getColor()+","+ tesela.getPosicion()+ ","+ ((Circulo)tesela.getFigura()).getRadio()+ "}}\n");
	         		
	         		 
	   			}
	         	
	         	if(tesela.getFigura() instanceof Rectangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor() + ",REC:{" + ((Rectangulo)tesela.getFigura()).getColor()+","+ tesela.getPosicion()+ ","+((Rectangulo)tesela.getFigura()).getBase()+","+((Rectangulo) tesela.getFigura()).getAltura()+ "}}\n");
	         		
	         	}
	         	if(tesela.getFigura() instanceof Triangulo) {
	         		datos = datos.concat( "("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor() + ",TRI:{" + ((Triangulo)tesela.getFigura()).getColor()+","+ tesela.getPosicion()+ ","+((Triangulo) tesela.getFigura()).getAltura()+","+((Triangulo)tesela.getFigura()).getBase()+ "}}\n");
	         	}
	         	}
	         	else {
	         		
	         	  
	         	    datos = datos.concat("("+ (coordenada.getFila())+","+(coordenada.getColumna())+"):"+ tesela.getEstado()+"{"+tesela.getColor()+"}\n");
	         	 
	         	}
	      	
	      	}
      	
     
	      	
			}
			  return datos.trim();
      
	}
	
	
	/**
	 * Metodo que guarda en un nuevo fichero nuestro mosaico con sus atributos.
	 * @param fichero El nuevo fichero donde se desea guardar.
	 * @exception FileNotFoundException Excepcion que se lanza cuando no se encuentra el fichero.
	 */
	
	public void salvarAFichero (String fichero) {
		
			
				 
				 PrintWriter ficheroMosaico = null;
				 try {
					ficheroMosaico = new PrintWriter(new FileOutputStream(fichero));
					
					ficheroMosaico.println(toString());
					ficheroMosaico.close();
				 
		 } 
		 
		 catch (FileNotFoundException e){
		 PrintWriter error=null;
		
			try {
				 
			error = new PrintWriter(new FileOutputStream (new File ("Project/error.txt")));
		
			}
			
			catch (FileNotFoundException e1) {                       
				System.exit(-1);                                         
			}
			
			error.print("FileNotFoundException");
			error.close();
			System.exit(-1);
		}
	}
		
	/**
	 * Metodo que sirve para obtener una tesela a partir de una coordenada.		
	 * @param c La coordenada de la cual queremos obtener la tesela.
	 * @return la tesela del mapa que tenga esa coordenada.
	 */	
	
	public Tesela getTesela(Coordenada coordenada) {
		
		return this.mosaico.get(coordenada);
			
			
	
	}
		
	
	/**
	 * Metodo que anade una nueva region a la lista de regiones.		
	 * @param r La nueva region.
	 */
		public void anadirRegion(RegionRectangular region) {
			 if (this.regiones == null) {
				 this.regiones = new ArrayList <RegionRectangular>();
			 }
			 this.regiones.add(region);
		 }
		
		
	/**
	 * Metodo que ordena las regiones por sus areas, de mayor a menor.			 
	 */
				 
			 public void ordenarRegionesXAreaAsc() {
				 Collections.sort(this.regiones, new CompararArea());             
			 }
			 

			 
			 
	 /**
	  *Metodo que se utiliza para cambiar la luminosidad de una tesela.
	  * @param luminosidad El valor de la luminosidad que se utilizara para variar los valores RGB de color.			 
	  */
			 public void changeLuminosity(int luminosidad) {
				 				 
				 for (Tesela tesela: mosaico.values()) {
							tesela.changeLuminosity(luminosidad);
							
						
				}
			 }
			 
	 /**
	  * Metodo que sirve para cambiar el estado de la tesela (encendido, apagado o figura apagada)			 
	  * @param estado El nuevo estado.
	  */
			 
			public void  changeStatus (int estado) {
				for (Tesela tesela: mosaico.values()) {
					
					
					tesela.changeStatus(estado);
				
			}
			}
			 
	 /**
	  * Metodo que sirve para encontrar una region en la lista de regiones a partir de su nombre.			 
	  * @param nombre El nombre de la region que se quiere obtener.
	  * @return region , la region que queremos obtener.
	  * @return null, si el nombre no coincide con ninguno.
	  */
				
			 public RegionRectangular getRegion(String nombre) {
				 for (RegionRectangular region : this.regiones) {
					 
					 if (nombre.equals(region.getNombre())) {
						 return region;
					 }
				 }
				 return null;
		 }
		
			
			
			//Getters and Setters

			


				/**
				 *Metodo getter relativo al mapa que tiene el mosaico.
				 * @return El mapa con el mosaico.
				 */
				
				public TreeMap<Coordenada, Tesela> getMosaico() {
					return this.mosaico;
				}
				
				/**
				 * Metodo setter relativo al mapa que tiene el mosaico. 
				 * @param mosaico, el valor del mapa.
				 */

				public void setMosaico(TreeMap<Coordenada, Tesela> mosaico) {
					this.mosaico = mosaico;
				}

				/**
				* Metodo getter relativo a la coordenada x.
				* @return El valor de la coordenada x.
				*/
						
				public int getPosicionX() {
					return this.posicionX;
				}
				
				/**
				 * Metodo setter relativo a la coordenada x.
				 * @param posicionX El valor de la coordenada x.
				 */
				
				public void setPosicionX(int posicionX) {
					this.posicionX = posicionX;
				}
				
				/**
				 * Metodo getter relativo a la coordenada y.
				 * @return La coordenada y.
				 */

				public int getPosicionY() {
					return this.posicionY;
				}

				/**
				 * Metodo setter relativo a la coordenada y.
				 * @param posicionY El valor de la coordenada y.
				 */

				public void setPosicionY(int posicionY) {
					this.posicionY = posicionY;
				}

				
				/**
				 * Metodo getter que sirve para obtener el ancho de las teselas que forman el mosaico.
				 * @return el ancho de las teselas.
				 */

				public int getAnchoTesela() {
				        return this.anchoTesela;
				    }

				/**
				 *  Metodo setter que sirve para obtener el ancho de las teselas que forman el mosaico.
				 * @param anchoTesela El valor del ancho de las teselas.
				 */
				
			  public void setAnchoTesela(int anchoTesela) {
				        this.anchoTesela = anchoTesela;
				    }
			  
			  	/**
			  	 * Metodo getter que sirve para obtener el alto de las teselas que forman el mosaico.
			  	 * @return el alto de las teselas.
			  	 */

			  public int getAltoTesela() {
				        return this.altoTesela;
				    }
			  
			  	/**
			  	 * Metodo setter que sirve para obtener el alto de las teselas que forman el mosaico.
			  	 * @param altoTesela El valor del alto de las teselas.
			  	 */

				public void setAltoTesela(int altoTesela) {
				        this.altoTesela = altoTesela;
				    }
				
				/**
			  	 * Metodo getter para obtener la lista de regiones.
			  	 * @return la lista con las regiones.
			  	 */
				
				
				public List<RegionRectangular> getRegiones(){
					return this.regiones;
				}
				
				/**
			  	 * Metodo setter para obtener la lista de regiones.
			  	 * @param regiones La lista con las regiones.
			  	 */
				

				public void setRegiones(List<RegionRectangular> regiones) {
					this.regiones = regiones;
				}







	/**
	 * Clase interna de Mosaico que se usa para crear las regiones que forman el mosaico.
	 */
	
		
		//REGION RECTANGULAR
		public class  RegionRectangular implements Luminosity  {  
				
				//Atributos
				private String nombre;    
				private Coordenada origen;         
				private int w;             
				private int h;            

				private List <Coordenada> coordenadas;
				Mosaico m;
				
		
		
		//Constructor
				
				/**
				 * Metodo constructor que sirve para crear las regiones teniendo en cuenta: el mosaico, el nombre, el ancho, la altura, filas y columnas, el estado y la luminosidad.
				 * @param mosaico El mosaico que contiene la region.
				 * @param nombre El nombre de la region.
				 * @param f0 La fila donde empieza la region.
				 * @param c0 La columna donde empieza la region. 
				 * @param w La anchura de la region.
				 * @param h La altura de la region.
				 */
		
		public RegionRectangular (Mosaico mosaico,String nombre, int f0, int c0, int w, int h) { 
			
															

			this.w = w;
			this.h = h;
			this.nombre =nombre;
			
			coordenadas = new ArrayList <Coordenada>();
				
			this.origen = new Coordenada (f0,c0);
			
			for (int i = f0, w1 = w; w1 !=0; w1--,i++) {
				for (int j = c0, h1 = h; h1 !=0; h1--,j++) {
					Coordenada coordenada = new Coordenada (i,j);
					coordenadas.add(coordenada);
				}
			}
			
			m = mosaico;
		}
		
		
		/**
		 * Metodo que desordena las coordenadas de una region.
		 */

	public void Desordenar() {					

	    Collections.shuffle(this.coordenadas);

	 }


	/**
	 * Metodo que ordena las coordenadas de una region por orden ascendente.
	 */

	public void ordenarXCoordenadaAsc() {

	    Collections.sort(this.coordenadas);  
	}

	
	/**
	 * Metodo que calcula el area de una región.
	 * @return el valor del area.
	 */

	public int Area () {  

	 int area = this.coordenadas.size();
	return area ;
	}



	
	/**
	 * Metodo que muestra la informacion de los atributos de la region.
	 * @return Una String con la informacion.
	 */


	public String toString() {       
	String primeraLinea = this.nombre + ":(" + this.origen.getFila()+","+ this.origen.getColumna() + ")," + this.w + "-" + this.h + ":" + this.coordenadas.toString() + "\n";

	return primeraLinea;


	}


	/**
	 * Metodo que se utiliza para cambiar la luminosidad de una region.
	 * @param luminosidad El valor de la luminosidad que se utilizara para variar los valores RGB de color.	
	 */
	
		public void changeLuminosity(int luminosidad) {
			for (Coordenada c : this.coordenadas) {
				
			
			this.m.getTesela(c).changeLuminosity(luminosidad);
		}
		}
	
		/**
		 * Metodo que se utiliza para cambiar el estado de una region.	
		 * @param estado El nuevo estado.
		 */

		public void changeStatus(int estado) {
			for (Coordenada c : this.coordenadas) {
				
				this.m.getTesela(c).changeStatus(estado);
			}
			}


	//Getters and Setters
	
	/**
	 * Metodo getter relativo al nombre de la region.
	 * @return el nombre de la region.
	 */

	public String getNombre() {
	return this.nombre;
	}

	/**
	 * Metodo setter relativo al nombre de la region.
	 * @param nombre El valor del nombre.
	 */

	public void setNombre(String nombre) {
	this.nombre = nombre;
	}

	/**
	 * Metodo getter relativo a la anchura de la region.
	 * @return la anchura de la region.
	 */

	public int getW() {
	return this.w;
	}

	/**
	 * Metodo setter relativo a la anchura de la region.
	 * @param w El valor de la anchura.
	 */

	public void setW(int w) {
	this.w = w;
	}

	/**
	 * Metodo getter relativo a la altura de la region.
	 * @return la altura de la region.
	 */

	public int getH() {
	return this.h;
	}

	/**
	 * Metodo setter relativo a la altura de la region.
	 * @param h El valor de la altura.
	 */

	public void setH(int h) {
	this.h = h;
	}
	
	/**
	 * Metodo getter relativo a la coordenada de origen de la region.
	 * @return la coordenada de origen.
	 */

	
	public Coordenada getOrigen() {
		return origen;
	}
	
	/**
	 * Metodo setter relativo a la coordenada de origen de la region.
	 * @param origen La coordenada.
	 */


	public void setOrigen(Coordenada origen) {
		this.origen = origen;
	}

	/**
	 * Metodo getter relativo a la lista que contiene las coordenadas de la region.
	 * @return  La lista de las coordenadas.
	 */ 


	public List <Coordenada> getCoordenadas () { 
		
		return this.coordenadas;                    

	}
	
	/**
	 * Metodo setter relativo a la lista que contiene las coordenadas de la region.
	 * @param coordenadas La lista de las coordenadas.
	 */ 

	public void setCoordenadas(List<Coordenada> coordenadas) {
	this.coordenadas = coordenadas;
	}

		}
		

		/**
		 * Clase interna de Mosaico que se usa para comparar el area de las regiones y asi poder ordenarlas.
		 */

	class CompararArea implements Comparator<RegionRectangular>{

		
		/**
		 * Metodo que recibe dos regiones y compara sus areas, y sus nombres si las areas son iguales.
		 * @param o1 La primera region.
		 * @param o2 La segunda region.
		 * @return -1 si la segunda es mayor.
		 * @return 1 si la primera es mayor.
		 * @return 0 si las dos son iguales.
		 */
		
			public int compare(RegionRectangular o1, RegionRectangular o2) {
				if (o1.Area() <o2.Area()) return -1;
				else if (o1.Area() == o2.Area()) {
				 return o1.getNombre().compareTo(o2.getNombre());                                          
					}
				else return 1;
				
				
				
			}

			}
	}