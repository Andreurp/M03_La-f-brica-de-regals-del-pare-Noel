package net.andreu.Fabrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * La fàbrica del pare Noel...
 *
 */
public class App {
	private String arxiu = "src/main/resources/llista.txt";
	private ArrayList<String> regals = new ArrayList<String>();
	private HashMap<String,Integer> contador = new HashMap<String,Integer>();
	private ArrayList<String> llista = new ArrayList<String>();

	public static void main(String[] args) {
		App a = new App();
		a.inici();
	}

	public void inici() {
		llegirFitxer();
		procesaFitxer();
		saparaRegals();
		ordena();
		imprimir();
	}

	public void llegirFitxer() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(arxiu));
			String linia;
			while ((linia = br.readLine()) != null) {
				regals.add(linia);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void procesaFitxer() {
		// eliminem la ultima linea del array list de regals
		regals.remove(regals.size() - 1);
	}
	public void saparaRegals() {
		String[] nen;
		String[] desitjos;
		String clau;
		int valor;
		//separem el nen dels regals
		for(int i=0; i<regals.size(); i++){
			nen=regals.get(i).split(":");
			desitjos=nen[1].split(",");
			for(int r=0; r<desitjos.length; r++){
				clau=desitjos[r].trim();
				if (contador.containsKey(clau)){
					valor=contador.get(clau);
					contador.put(clau, valor+1);
				}else{
					contador.put(clau, 1);
				}
			}
		}
	}
	public void ordena(){
		String patit;
		int mida=contador.size();
		
		for(int i=0; i<mida; i++){
			patit=null;
			for(String clau:contador.keySet()){
				if(patit==null){
					patit=clau;
				}else{
					if(contador.get(clau)<contador.get(patit)){
						patit=clau;
					}
				}
			}
			llista.add(patit);
			contador.remove(patit);
		}
	}
	
	public void imprimir(){
		int tongada=0;
		for(int i=0; i<llista.size(); i++){
			if(i%5==0){
				tongada++;
				System.out.println();
				System.out.print(tongada+" - ");
			}
			System.out.print(llista.get(i)+", ");
			
			
		}
	}
}
