package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico<Pelicula> peliculas;
	private IArregloDinamico<Elenco> elenco;
	
	
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		peliculas = new ArregloDinamico(120);
		elenco = new ArregloDinamico(120);
		
	}
	
	
	
	



   
    	public void cargarDato() throws IOException 
        {
        
        	String csvFile = "./data/SmallMoviesDetailsCleaned.csv";
        	String archivo = "./data/MoviesCastingRaw-small.csv";
            BufferedReader br = null;
            BufferedReader pr = null;
            String line = "";
            String cvsSplitBy = ";";
           

            try {

                br = new BufferedReader(new FileReader(csvFile));
                while ((line = br.readLine()) != null) {

                    String[] datos = line.split(cvsSplitBy);
                    String id = datos[0];
                    String genres = datos[1];
                    String imbd = datos[2];
                    String originalLang = datos[3];
                    String originalTitle = datos[4];
                    String overview = datos[5];
                    String popularity = datos[6];
                    String proCompanies = datos[7];
                    String proCountries = datos[8];
                    String releaseDate = datos[9];
                    String revenue = datos[10];
                    String runtime = datos[11];
                    String spokenLanguages = datos[12];
                    String status = datos[13];
                    String tagline = datos[14];
                    String title = datos[15];
                    String voteAverage = datos[16];
                    String voteCount = datos[17];
                    String proCompaniesNumber = datos[18];
                    String proCompaniesCountryNumber = datos[19];
                    String spokenLanguagesNumber = datos[20];
                 
                     Pelicula actual = new Pelicula (id,genres,imbd,originalLang, originalTitle,overview,popularity,proCompanies,
                    		proCountries,releaseDate,revenue,runtime,spokenLanguages,status,tagline,title,voteAverage,voteCount,
                    		proCompaniesNumber,proCompaniesCountryNumber,spokenLanguagesNumber);
                     peliculas.agregar(actual);
                     
                    

                }
                pr = new BufferedReader(new FileReader(archivo));
                while ((line = pr.readLine()) != null) {
                	String[] datos = line.split(archivo);
                    String id = datos[0];
                    String actor1 = datos[1];
                    String gender1 = datos[2];
                    String actor2 = datos[3];
                    String gender2 = datos[4];
                    String actor3 = datos[5];
                    String gender3 = datos[6];
                    String actor4 = datos[7];
                    String gender4 = datos[8];
                    String actor5 = datos[9];
                    String gender5 = datos[10];
                    String actorNumber = datos[11];
                    String directorName = datos[12];
                    String directorGender = datos[13];
                    String directorNumber = datos[14];
                    String producerName = datos[15];
                    String producerNumber = datos[16];
                    String screenName = datos[17];
                    String editorName = datos[18];
                    
                    Elenco actual = new Elenco (id, actor1,gender1,actor2, gender2,actor3,gender3, actor4,gender4,actor5,gender5, actorNumber,directorName,directorGender,directorNumber, producerName, producerNumber, screenName, editorName ); 
                   elenco.agregar(actual);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        	
        }
    	
    	
    	public String buenasPeliculas(String director)
    	{
    		String respuesta = "";
    		String idABuscar="";
    		int i = 0;
    		int j =0;
    		while(i<elenco.darTamano())
    		{
    			String directorA = elenco.darElemento(i).darDirectorName();
    			if(directorA.equalsIgnoreCase(director))
    			{
    				idABuscar=elenco.darElemento(i).darId();
    				respuesta += elenco.darElemento(i).darActores();
    			}
    		}
    		while(j<peliculas.darTamano())
    		{
    			String actualID = peliculas.darElemento(j).darId();
    			if (actualID.equalsIgnoreCase(idABuscar))
    			{
    				respuesta+=", "+ peliculas.darElemento(j).darDatosReq();
    			}
    			
    		}
    		
    		return respuesta;
    	}
    

}
