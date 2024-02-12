package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> valoresComoLista = new ArrayList<String>(mapaCadenas.values());
    	valoresComoLista.sort(String.CASE_INSENSITIVE_ORDER);
        return valoresComoLista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> llavesComoLista = new ArrayList<String>(mapaCadenas.keySet());
    	llavesComoLista.sort(String.CASE_INSENSITIVE_ORDER);
    	
    	for (int i = 0, j = llavesComoLista.size() - 1; i < j; i++) {
            llavesComoLista.add(i, llavesComoLista.remove(j));
        }

    	
        return llavesComoLista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	if (mapaCadenas.size() > 0) {
    		List<String> llavesComoLista = new ArrayList<String>(mapaCadenas.keySet());
    		llavesComoLista.sort(null);
    		return llavesComoLista.get(0);	
    	}
    	
    	else {
    		return null;
    	}
    	

    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if (mapaCadenas.size() > 0) {
    		String cadena = getValoresComoLista().get(mapaCadenas.size()-1);
    		return cadena;	
    	}
    	
    	else {
    		return null;
    	}
       
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	List<String> llavesMayusculas = new ArrayList<String>();
    	
    	for (String element : mapaCadenas.keySet()) {
    		String elementx = element.toUpperCase();
    		llavesMayusculas.add(elementx);
    	}
        return llavesMayusculas;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {

    	ArrayList <String> visitados;
    	visitados = new ArrayList <String>();
    	
    	for (String cadena : getValoresComoLista()) {
    		if (visitados.contains(cadena) == false) {
    			visitados.add(cadena);
    		}
    	}

        return visitados.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	if (mapaCadenas.containsKey(cadena) == false) {
    		String cadenaInvertida = "";

    		for (int i = cadena.length() - 1; i >= 0; i--) {

    			cadenaInvertida = cadenaInvertida + cadena.charAt(i);
    		}
    		mapaCadenas.put(cadena, cadenaInvertida);
    	}

    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);

    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	String llave = "";

		for (int i = valor.length() - 1; i >= 0; i--) {
			llave = llave + valor.charAt(i);		
			}
		
		mapaCadenas.remove(llave, valor);
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	for (String element : getLlavesComoListaInvertida()) {
    		mapaCadenas.remove(element);
    	}
    	
    	for (Object element: objetos) {
    		String llave = element.toString();
    		String valor = "";

    		for (int i = llave.length() - 1; i >= 0; i--) {
    			valor = valor + llave.charAt(i);		
    			}
    		
    		mapaCadenas.put(llave, valor);
    		
    	}

    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	List <String> copiaLlaves = new ArrayList<String>( );
    	
    	for (String element : getLlavesComoListaInvertida())
    		{
    		copiaLlaves.add(element);
    		}
    	
    	mapaCadenas.clear();
    	
    	for (String llave : copiaLlaves) {
    		
    		String valor = "";
    		for (int i = llave.length() - 1; i >= 0; i--) {
    			valor = valor + llave.charAt(i);		
    			}
    		
    		mapaCadenas.put(llave.toUpperCase(), valor);
    	}	
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	int contadorNoPertenecientes = 0;
    	boolean retorno = true;
    	
    	for (String valorArreglo : otroArreglo) {
    		if (mapaCadenas.containsValue(valorArreglo) == false )  {
    			contadorNoPertenecientes++;
    		}
    	} 
    	
    	if (contadorNoPertenecientes != 0) {
    		retorno = false;
	
    	}
        return retorno;
    }

}
