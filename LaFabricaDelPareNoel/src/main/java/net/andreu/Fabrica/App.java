package net.andreu.Fabrica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La fàbrica del pare Noel...
 *
 */
public class App {
	private String arxiu = "src/main/resources/llista.txt";
	private ArrayList<String> regals = new ArrayList<String>();

	public static void main(String[] args) {
		App a = new App();
		a.inici();
	}

	public void inici() {
		llegirFitxer();
		procesaFitxer();
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
}
