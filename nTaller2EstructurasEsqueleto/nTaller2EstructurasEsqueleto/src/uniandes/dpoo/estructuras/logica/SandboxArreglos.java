package uniandes.dpoo.estructuras.logica;

import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] copiaEnteros = arregloEnteros.clone();    

        return copiaEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copiaCadenas = arregloCadenas.clone();    

        return copiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidadValoresEnteros = arregloEnteros.length;
        return cantidadValoresEnteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidadValoresCadenas = arregloCadenas.length;
        return cantidadValoresCadenas;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
		
    	  int[] result = new int[arregloEnteros.length + 1];
          
          for (int i = 0; i < arregloEnteros.length-1; i++) {
              result[i] = arregloEnteros[i];
          }
   

   
  		arregloEnteros = result;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
		String[] result = new String[arregloCadenas.length + 1];
		
		for (int i = 0, j = 0; i < arregloCadenas.length; i++, j++)
		{
			if (i == arregloCadenas.length -1)
			{
				result[j] = cadena;
				j++;
			}
			result[j] = arregloCadenas[i];
		}
		arregloCadenas = result;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        for (int i = 0; i < getCantidadEnteros() - 1; i++) {
            if (arregloEnteros[i] == valor) {
              arregloEnteros = new int[getCantidadEnteros() - 1];
              for (int index = 0; index < i; index++) {
                arregloEnteros[index] = getCopiaEnteros()[index];
              }
              for (int j = i; j < getCantidadEnteros() - 1; j++) {
                arregloEnteros[j] = getCopiaEnteros()[j + 1];
              }
              
            }
          } 
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
        for (int i = 0; i < getCantidadCadenas() - 1; i++) {
            if (arregloCadenas[i] == cadena) {
              arregloCadenas = new String[getCantidadCadenas() - 1];
              for (int index = 0; index < i; index++) {
                arregloCadenas[index] = getCopiaCadenas()[index];
              }
              for (int j = i; j < getCantidadCadenas() - 1; j++) {
                arregloCadenas[j] = getCopiaCadenas()[j + 1];
              }
              
            }
          } 

    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion >= 0 && posicion < arregloEnteros.length) {
    		
            int[] result = new int[arregloEnteros.length + 1];
            
            for (int i = 0; i < posicion; i++) {
                result[i] = arregloEnteros[i];
            }
     
            result[posicion] = entero;
     
            for (int i = posicion + 1; i <= arregloEnteros.length; i++) {
                result[i] = arregloEnteros[i - 1];
            }
     
    		arregloEnteros = result;
    		
    	} else if (posicion > arregloEnteros.length) {
    		agregarEntero(entero);
    		
    	} else if(posicion < 0) {
    		int[] result = new int[arregloEnteros.length + 1];
              
              for (int i = 0; i < 0; i++) {
                  result[i] = arregloEnteros[i];
              }
       
              result[0] = entero;
       
              for (int i = 0 + 1; i <= arregloEnteros.length; i++) {
                  result[i] = arregloEnteros[i - 1];
              }
       
      		arregloEnteros = result;
    		
    	}
    	
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int elementoParaEliminar = 0;
    	int busquedaPosicion = 0;
    	
    	for (int element : arregloEnteros) {
    		if (busquedaPosicion == posicion) {
    			elementoParaEliminar = element;
    		}
    		busquedaPosicion++;
    	}
    		
    	
        for (int i = 0; i < arregloEnteros.length - 1; i++) {
            if (arregloEnteros[i] == elementoParaEliminar) {
              int[] newArr = new int[arregloEnteros.length - 1];
              for (int index = 0; index < i; index++) {
                newArr[index] = arregloEnteros[index];
              }
              for (int j = i; j < arregloEnteros.length - 1; j++) {
                newArr[j] = arregloEnteros[j + 1];
              }
              arregloEnteros = newArr;
              break;
            }
          }

    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int [] nuevoArreglo = new int [0];
    	for (double element : valores) {
    		int elementx = (int) element;
    		
    	  nuevoArreglo = new int[nuevoArreglo.length + 1];
          
          for (int i = 0; i < nuevoArreglo.length-1; i++) {
        	  nuevoArreglo[i] = nuevoArreglo[i];
          }
   
          nuevoArreglo[nuevoArreglo.length-1] = elementx;
   
  	
    	}
    	arregloEnteros = nuevoArreglo.clone();
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String [] nuevoArreglo = new String [0];
    	for (Object element : objetos) {
    		String elementx = element.toString();
    		
    	  nuevoArreglo = new String[nuevoArreglo.length + 1];
          
          for (int i = 0; i < nuevoArreglo.length-1; i++) {
        	  nuevoArreglo[i] = nuevoArreglo[i];
          }
   
          nuevoArreglo[nuevoArreglo.length-1] = elementx;
   
          for (int i = nuevoArreglo.length-1 + 1; i <= nuevoArreglo.length; i++) {
        	  arregloCadenas[i] = nuevoArreglo[i - 1];
          }
  	
    	}
    	

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int posicion = 0;
    	for (int element : arregloEnteros) {
    		if (element < 0) {
    			arregloEnteros[posicion] = element*(-1);
    		}
    		posicion++;
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
        for(int i=0;i<(arregloEnteros.length-1);i++){
            for(int j=i+1;j<arregloEnteros.length;j++){
                if(arregloEnteros[i]>arregloEnteros[j]){
                    
                    int variableAuxiliar=arregloEnteros[i];
                    arregloEnteros[i]=arregloEnteros[j];
                    arregloEnteros[j]=variableAuxiliar;
                }
            }
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int contador = 0;
    	for (int element : arregloEnteros) {
    		if(element == valor) {
    			contador++;
    		}
    	}
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
        	int contador = 0;
        	for (String element : arregloCadenas) {
        		if(element.equalsIgnoreCase(cadena)) {
        			contador++;
        		}
        	}
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int [] arregloPosiciones = new int [0];
    	int posicionEncontrada = 0;
    	
    	for (int element : arregloEnteros) {
    		if (element == valor) {
    			arregloPosiciones = new int[arregloPosiciones.length + 1];
    			
    	          for (int i = 0; i < arregloPosiciones.length-1; i++) {
    	        	  arregloPosiciones[i] = arregloPosiciones[i];
    	          }
    	   
    	          arregloPosiciones[arregloPosiciones.length-1] = posicionEncontrada;
    	   
    	          for (int i = arregloPosiciones.length-1 + 1; i <= arregloPosiciones.length; i++) {
    	        	  arregloPosiciones[i] = arregloPosiciones[i - 1];
    	          }
    			
    		}
    		
    	}
    	
        return arregloPosiciones;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
        for(int i=0;i<(arregloEnteros.length-1);i++){
            for(int j=i+1;j<arregloEnteros.length;j++){
                if(arregloEnteros[i]>arregloEnteros[j]){
                    
                    int variableAuxiliar=arregloEnteros[i];
                    arregloEnteros[i]=arregloEnteros[j];
                    arregloEnteros[j]=variableAuxiliar;
                }
            }
        }
    	int tamaño = arregloEnteros.length;
    	int mayor = arregloEnteros[tamaño-1];
    	int menor = arregloEnteros[0];
    	
    	if(arregloEnteros.length > 0) {
    		int [] rangoEnteros = new int[] {menor, mayor};
    		return rangoEnteros;
    		
    	} else {
    		
    		int [] rangoEnteros = new int[] {};
    		return rangoEnteros;
    		
    	}
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	ArrayList <Integer> revisados = new ArrayList<Integer>( );
    	HashMap<Integer, Integer> histograma = new HashMap<Integer, Integer>();
    	
    	for (int element : arregloEnteros) {
    		
    		Integer elementx = (Integer)element;
    		
    		int contadorVeces = 0;
    		if (revisados.contains(elementx) == false) {
    			for(int similares : arregloEnteros) {
    				if(similares == element) {
    					contadorVeces++;
    				}
    		}
    			revisados.add(elementx);
    			histograma.put(elementx, contadorVeces-1);
    			
    		}
    		
    	}
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteros diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int contadorRepetidos = 0;
    	Integer enteroComparado = null;
    	ArrayList <Integer> visitados;
    	visitados = new ArrayList <Integer>();
    	
    	for (int element : arregloEnteros)
    	{
    		int contadorApariciones = 0;
    		enteroComparado = (Integer) element;
    		
    		if(visitados.contains(enteroComparado) == false ) {
    			
    			for (Integer elementx : arregloEnteros) {
    				if(enteroComparado == elementx) {
    					contadorApariciones++;
    					visitados.add(enteroComparado);
    				}
    			}
    			
    			if(contadorApariciones > 1) {
    				contadorRepetidos++;
    			}
    			
    		}
    	}
    	return contadorRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean retorno = false;
    	if( Arrays.equals(arregloEnteros, otroArreglo)) {
    		retorno = true;
    	} 
    	return retorno;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        for(int i=0;i<(arregloEnteros.length-1);i++){
            for(int j=i+1;j<arregloEnteros.length;j++){
                if(arregloEnteros[i]>arregloEnteros[j]){
                    
                    int variableAuxiliar=arregloEnteros[i];
                    arregloEnteros[i]=arregloEnteros[j];
                    arregloEnteros[j]=variableAuxiliar;
                }
            }
        }
        
        for(int i=0;i<(otroArreglo.length-1);i++){
            for(int j=i+1;j<otroArreglo.length;j++){
                if(otroArreglo[i]>otroArreglo[j]){
                    
                    int variableAuxiliar=otroArreglo[i];
                    otroArreglo[i]=otroArreglo[j];
                    otroArreglo[j]=variableAuxiliar;
                }
            }
        }
        
        if (arregloEnteros == otroArreglo) {
        	return true;
        } else {
        	return false; 	
        }
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	ArrayList <Integer> listaEnteros = new ArrayList<Integer>();
    	
    	while (listaEnteros.size() <= cantidad) {
    		int min = minimo + 1;
    		int numeroAñadido = (int)Math.floor(Math.random()*maximo+min);
    		
    		Integer numeroNuevo = (Integer) numeroAñadido;
    		
    		listaEnteros.add(numeroNuevo);
    	}
    	
    	arregloEnteros = listaEnteros.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
