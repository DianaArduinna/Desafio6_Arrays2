package fotolikes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Likes {

	/*
	 * Leer el archivo y almacenar los datos en un arreglo. Crear un arreglo con los
	 * nombres de las fotos (sin repetir) ordenadas de menor a mayor. Metodos
	 * Calcular la frecuencia de cada una de las fotos. metodo Calcular cuál o
	 * cuáles es la foto con más likes. metodo Calcular cuál o cuáles es la foto
	 * con menos likes. metodo Calcular el promedio de likes de las fotos. metodo
	 * 
	 */

	public static void main(String[] args) {

		String nombre = "likes";

		ArrayList<String> lectura = leerArch(nombre); // arreglo con el resultado del metodo leer

		List<String> ordenadas = orden(lectura); // arreglo que entrega la lectura del archivo ordenada

		ArrayList<Integer> cantidad = frequency(ordenadas, lectura);

		// System.out.println(cantidad);

		maximo(cantidad, ordenadas);

		minimo(cantidad, ordenadas);

		System.out.println("El promedio de like por foto es: " + promedio(cantidad));

	}

	// ----------------Metodo 1 --------------------
	// Metodo lectura de archivo - lee y archiva

	static ArrayList<String> leerArch(String archivolikes) {
		FileReader fr = null; // reads character files
		BufferedReader br = null; // reads text buffering characters/efficient reading
		String data = ""; // datos que recibe cada vez que pasa

		ArrayList<String> fotos = new ArrayList<String>(); // Array donde guardara lo que leera

		try {
			fr = new FileReader(archivolikes); // reads the characters of the file
			br = new BufferedReader(fr);

			data = br.readLine();
			while (data != null) { // data sea distinta a null

				String[] dataSplit = data.split(" "); // array del ciclo/Split permite separar String bajo un criterio
				for (int i = 0; i < dataSplit.length; i++) {
					fotos.add(dataSplit[i]); // filtra lo que necesita del archivo

				}
				data = br.readLine();
			}
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println("Excepcion leyendo fichero " + e);
		}

		return fotos;

	}

	// ----------------Metodo 2--------------------

	/*
	 * metodo distinct crear un arreglo con los nombres de las fotos (sin repetir)
	 * metodo sort ordenadas de menor a mayor.
	 */

	static List<String> orden(ArrayList<String> entradaAOrdenar) {

		List<String> fotosordenadas = entradaAOrdenar.stream().distinct().sorted().collect(Collectors.toList());
		// arreglo donde estan ordenadas

		return fotosordenadas;// devuelve las fotos ya ordenadas

	}

	// ----------------Metodo 3--------------------
	// Calcular la frecuencia de cada una de las fotos. metodo

	static ArrayList<Integer> frequency(List<String> ordenadas, ArrayList<String> leidas) {

		ArrayList<Integer> frecuencia = new ArrayList<Integer>();

		for (int i = 0; i < ordenadas.size(); i++) {

			frecuencia.add(Collections.frequency(leidas, ordenadas.get(i)));

			System.out.println(ordenadas.get(i) + " : " + frecuencia.get(i));

		}
		System.out.println();

		return frecuencia;

	}

	// ----------------Metodo 4--------------------
	/*
	 * Calcular foto con más likes. metodo Calcular foto con menos likes. metodo
	 */

	static void maximo(ArrayList<Integer> frecuenciaMax, List<String> nombre) {

		int maxima = Collections.max(frecuenciaMax);
		ArrayList<String> maxLikes = new ArrayList<>();

		for (int i = 0; i < frecuenciaMax.size(); i++) {
			if (frecuenciaMax.get(i) == maxima) {
				maxLikes.add(nombre.get(i));
			}
		}
		if (maxLikes.size() == 1) {
			System.out.println("La foto con mas likes es " + maxLikes.get(0) + " con " + maxima + " likes.");
		} else {
			String texto = "Las fotos con mas likes son: ";
			for (int i = 0; i < maxLikes.size(); i++) {
				texto = texto + String.format("%s", maxLikes.get(i));
			}
			texto = texto + String.format(" con %d likes", maxima);
			System.out.println(texto);

		}
		System.out.println("******************************************");

	}

	// ---------------Metodo 5---------------------

	static void minimo(ArrayList<Integer> frecuenciaMin, List<String> nombre) {

		int minima = Collections.min(frecuenciaMin);
		ArrayList<String> minLikes = new ArrayList<>();

		for (int i = 0; i < frecuenciaMin.size(); i++) {
			if (frecuenciaMin.get(i) == minima) {
				minLikes.add(nombre.get(i));
			}
		}
		if (minLikes.size() == 1) {
			System.out.println("La foto con menos likes es " + minLikes.get(0) + " con " + minima + " likes.");
		} else {
			String texto = "Las fotos con menos likes son: ";
			for (int i = 0; i < minLikes.size(); i++) {
				texto = texto + String.format("%s", minLikes.get(i));
			}
			texto = texto + String.format(" con %d likes", minima);
			System.out.println(texto);

		}
		System.out.println("******************************************");

	}

	// ----------------Metodo 6--------------------

	// Calcular el promedio de likes de las fotos. metodo

	static int promedio(ArrayList<Integer> numeros) {

		int acum = 0;
		int n = numeros.size();

		// desarrollo

		for (int i = 0; i < numeros.size(); i++) {

			acum = acum + numeros.get(i);

		}
		int promedio = acum / n;
		return promedio;
	}

}
