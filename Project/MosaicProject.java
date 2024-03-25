package Project;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Clase que recibe las instrucciones y requiere informacion para la creacion del mosaico.
 * @author Laura Gonzalez Lemos.
 *
 */

public class MosaicProject {
	
	/**
	 * Metodo principal del proyecto el cual lee de un fichero las instrucciones para crear el mosaico.
	 * @param args
	 * @exception FileNotFoundException Excepcion que se lanza cuando no se encuentra el fichero.
	 */

	public static void main(String[] args) {
		
		String instrucciones = null;
		if(args.length >0) {
			instrucciones= args[0];
		}
		Scanner keyboard = new Scanner (System.in);
	Scanner entrada = null;
	Mosaico mosaico = null;	
	Mosaico.RegionRectangular region = null;

		try {
			entrada = new Scanner(new FileInputStream("Project/"+instrucciones));
			
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
		

		String linea= null;	

		while (entrada.hasNextLine()) { 
			linea = entrada.nextLine();							
		
			
			
			if(linea.length()>0) {
				
				

			if(linea.startsWith("ReadMosaic")) {     
							
                 
				 String fichero = linea.substring(linea.indexOf(" ")+1,linea.length());
				 
				 mosaico = new Mosaico ("Project/"+fichero);
				 
			}
			
			
			if (linea.startsWith("CreateRegion")) {
				
				
				 String nombre = linea.substring(linea.indexOf(" ")+1,linea.indexOf(","));
				 
				 String caracteristicas = linea.substring(linea.indexOf(",")+1,linea.length());              
				
					String array []= caracteristicas.split (",");  
																																																		
																																															
	
				 int r0=  Integer.parseInt(array [0]);
				 int c0 =  Integer.parseInt (array [1]);
			     int h =  Integer.parseInt (array [2]);
			     int w =  Integer.parseInt (array [3]);
			     
			    		     
			     region = mosaico.new RegionRectangular( mosaico,nombre, r0, c0, h,w );
			     mosaico.anadirRegion(region);
			}
				
				 

				if (linea.startsWith("ChangeLuminosityMosaic")) {
				
				int luminosidad =  Integer.parseInt (linea.substring(linea.indexOf(" ")+1,linea.length()));
				
				mosaico.changeLuminosity(luminosidad);

				
			}
				
				
				
			if (linea.startsWith("ChangeLuminosityRegion")) {
			
				
				int luminosidad =  Integer.parseInt (linea.substring(linea.indexOf(" ")+1,linea.indexOf(",")));
				String nombre = linea.substring(linea.indexOf(",")+1,linea.length());
				
				
				mosaico.getRegion(nombre).changeLuminosity(luminosidad);
			}
			
			
			
			if(linea.startsWith("ChangeLuminosityTile")) {
				
				String cosastesela = linea.substring(linea.indexOf(" ")+1,linea.length());
				
				String array[] = cosastesela.split(",");
				int luminosidad =  Integer.parseInt (array[0]);
				int fila =  Integer.parseInt (array [1]);
				int columna =  Integer.parseInt (array [2]);
							
				Coordenada c = new Coordenada(fila, columna);
				
				
				mosaico.getTesela(c).changeLuminosity(luminosidad);
			}
			
			
			
			if(linea.startsWith("ChangeStatusMosaic")) {
	
				
				int estado =  Integer.parseInt (linea.substring(linea.indexOf(" ")+1,linea.length()));
				mosaico.changeStatus(estado);
				
				
			}
			
			
			
			if(linea.startsWith("ChangeStatusRegion")) {
				
				int estado =  Integer.parseInt (linea.substring(linea.indexOf(" ")+1,linea.indexOf(",")));
				String nombre = linea.substring(linea.indexOf(",")+1,linea.length());
				
				mosaico.getRegion(nombre).changeStatus(estado);
				
				
			}
			
			
			
			if(linea.startsWith("ChangeStatusTile")) {
				
				
				String cosastesela = linea.substring(linea.indexOf(" ")+1,linea.length());
				
				String array[] = cosastesela.split(",");
				int estado =  Integer.parseInt (array[0]);
				
				int fila =  Integer.parseInt (array [1]);
				int columna =  Integer.parseInt (array [2]);
				
				
				Coordenada coordenada = new Coordenada(fila, columna);
				
				
				mosaico.getTesela(coordenada).changeStatus(estado);
			}
			
			
			if(linea.startsWith("SortRegionsByArea")) {
			
				String fichero = linea.substring(linea.indexOf(" ")+1,linea.length());
				mosaico.ordenarRegionesXAreaAsc();
				
				PrintWriter regionesporarea=null;
				
				try {	
						 
					regionesporarea = new PrintWriter(new FileOutputStream (new File ("Project/"+fichero))); 
					
					for (Mosaico.RegionRectangular regiones : mosaico.getRegiones()){ 
						
                        regionesporarea.print(regiones.toString());
                    }
					
					regionesporarea.close();
					
				}
				catch(FileNotFoundException e) {
					
				
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
			
				
			if(linea.startsWith("SaveMosaic")) {
				
				String fichero = linea.substring(linea.indexOf(" ")+1,linea.length());
				mosaico.salvarAFichero("Project/"+ fichero);
				
			}
			
			}
			}
	
}
}