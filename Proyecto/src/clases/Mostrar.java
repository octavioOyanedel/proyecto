package clases;
import java.util.*;
import listas.*;

public class Mostrar {
	
	private Sorteo sorteo;
	private Numero numero;
	private Fila fila;
	private ListaFila listaFila;
	
	public Mostrar() {				
		
	}

	public void mostrarMapas(ArrayList<Object> lista) {
		
		for(int i = 0;i < lista.size();i++) {

			listaFila = (ListaFila)lista.get(i);
			mostrarMapa(listaFila.getMapa());
			System.out.println();
		}
		
	}
	
	public void mostrarMapa(HashMap<Integer,Object> mapa) {
		
		for(Map.Entry<Integer, Object> entry : mapa.entrySet()) {
			
			if(entry.getValue() instanceof Sorteo) {
				
				sorteo = (Sorteo)mapa.get(entry.getKey());
				mostrarMapa(sorteo.getLista());
				System.out.println("");
				
			}
			
			if(entry.getValue() instanceof Fila) {
				
				fila = (Fila)mapa.get(entry.getKey());
				mostrarMapa(fila.getLista());
				System.out.println("");
				
			}
			
		}
		
	}
	
	public void mostrarMapa(ArrayList<Object> lista) {
		
		for(int i = 0; i < lista.size(); i++) {
			
			numero = (Numero)lista.get(i);
			System.out.print(formatoNumero(numero.getNumero()));
			
		}
		
	}
	
	public String formatoNumero(int numero) {
		
		String cadenaNumero = String.valueOf(numero);
		
		if(numero >= 0 && numero < 10) {
			
			String formato = "%02d";
			String cadena = String.format(formato, numero);
			cadena = "["+cadena+"]";
			return cadena;
		
		}
		
		cadenaNumero = "["+cadenaNumero+"]";
		return cadenaNumero;
		
	}		
	
}//fin clase