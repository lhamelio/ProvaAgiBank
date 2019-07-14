package model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sun.misc.Queue;

public class FileController {
	private final static String env = System.getenv("HOMEPATH");
	private final static File path = new File(env + "/data");
	private final static File input = new File(env+ "/data/in");
	private final static File output = new File(env + "/data/out");
	private static ArrayList<File> listOfFiles = new ArrayList<>();

	/**
	 * Check whether the necessary directories are present, and if not, creates them
	 */
	public static void checkDirectories() {
		System.out.print("Checando diretorios...");
		if (!path.exists()) {
			input.mkdirs();
			output.mkdirs();
			System.out.println("\nPastas necessárias criadas.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao .dat na pasta 'in' em " + path.toString());
			System.out.println("Apos isso, rodar de novo essa aplicacao.");
			System.out.println("Encerrando...");
			System.exit(0);
		} else if (!input.exists()) {
			new File(path + "/in").mkdir();
			System.out.println("\nPastas necessárias criadas.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao .dat na pasta 'in' em " + path.toString());
			System.out.println("Apos isso, rodar de novo essa aplicacao.");
			System.out.println("Encerrando...");
			System.exit(0);
		} else if (!output.exists()) {
			new File(path + "/out").mkdir();
			System.out.println("\nPastas necessárias criadas.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao .dat na pasta 'in' em " + path.toString());
			System.out.println("Apos isso, rodar de novo essa aplicacao.");
			System.out.println("Encerrando...");
			System.exit(0);
		} else {
			System.out.println("OK!");
		}
	}

	/**
	 * Verifies if the files in the directory are suitable to the application
	 * 
	 * @return The <code>File</code> object
	 */
	/**
	public static void openFiles() {
		System.out.print("Verificando a pasta de entrada...");
		File[] aux = input.listFiles();
		listOfFiles = new ArrayList<>();
		for (int i = 0; i < aux.length; i++) {
			listOfFiles.add(aux[i]);
		}
		aux = null;
		if (listOfFiles.isEmpty()) {
			System.out.println("Pasta vazia.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao '.dat' em " + input.toString());
			System.out.println("Encerrando...");
			System.exit(1);
		} else {
			for (File f:listOfFiles) {
				if (!f.getName().endsWith("dat")) {
					listOfFiles.remove(f);
				}
			}
			System.out.println("OK!");
		}
	}
	**/
	public static ArrayList<File> openFiles() {
		System.out.print("Verificando a pasta de entrada...");
		File[] aux = input.listFiles();
		listOfFiles = new ArrayList<>();
		for (int i = 0; i < aux.length; i++) {
			listOfFiles.add(aux[i]);
		}
		aux = null;
		if (listOfFiles.isEmpty()) {
			System.out.println("Pasta vazia.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao '.dat' em " + input.toString());
			System.out.println("Encerrando...");
			System.exit(1);
		} else {
			for (File f:listOfFiles) {
				if (!f.getName().endsWith("dat")) {
					listOfFiles.remove(f);
				}
			}
			System.out.println("OK!");
		}
		return listOfFiles;
	}

	/**
	 * Parse the <code>File</code> and inserts it into the
	 * <code>ArrayList</code>, then returns it
	 * 
	 * @return The aforementioned <code>ArrayList</code> object filled with the data
	 */
	/**
	public static ArrayList<String> parseFiles() {
		ArrayList<String> array = new ArrayList<>();
		for (File f:listOfFiles) {
			try {
				BufferedReader bf = new BufferedReader(new FileReader(f));
				String linha;
				while ((linha = bf.readLine()) != null) { //enquanto o arquivo nao terminar
					array.add(linha); //adicionar ela ao array list
				}
				bf.close();
			} catch (IOException e) {
				System.out.println("Nao pude ler do arquivo.");
			}
		}
		return array;
	}
	**/
	public static ArrayList<String> parseFile(ArrayList<File> listOfFiles, File f) {
		ArrayList<String> array = new ArrayList<>();
		for (File file:listOfFiles) {
			try {
				BufferedReader bf = new BufferedReader(new FileReader(file));
				String linha;
				while ((linha = bf.readLine()) != null) { //enquanto o arquivo nao terminar
					array.add(linha); //adicionar ela ao array list
				}
				bf.close();
			} catch (IOException e) {
				System.out.println("Nao pude ler do arquivo.");
			}
		}
		return array;
	}
}
