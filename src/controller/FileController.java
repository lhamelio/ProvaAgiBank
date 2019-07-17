package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileController {
	private final  String env = System.getenv("HOMEPATH");
	private final  File path = new File(env + "/data");
	private final  File input = new File(env+ "/data/in");
	private final  File output = new File(env + "/data/out");
	private  ArrayList<File> listOfFiles = new ArrayList<>();

	/**
	 * Check whether the necessary directories are present, and if not, creates them
	 */
	public void checkDirectories() {
		System.out.print("Checando diretorios...");
		if (!path.exists()) {
			input.mkdirs();
			output.mkdirs();
			System.out.println("\nPastas necessárias criadas.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao .dat na pasta 'in' em " + path.toString());
		} else if (!input.exists()) {
			new File(path + "/in").mkdir();
			System.out.println("\nPastas necessárias criadas.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao .dat na pasta 'in' em " + path.toString());
		} else if (!output.exists()) {
			new File(path + "/out").mkdir();
			System.out.println("\nPastas necessárias criadas.");
			System.out.println("Para o correto funcionamento da aplicacao, coloque os arquivos com a extensao .dat na pasta 'in' em " + path.toString());
		} else {
			System.out.println("OK!");
		}
	}

	/**
	 * Returns a <code>ArrayList</code> are suitable to the application.
	 * If there's any file that does not end with the .dat extension, it is
	 * removed from the <code>ArrayList<></code> before returning
	 * 
	 */
	public ArrayList<File> openFiles() {
		System.out.print("Verificando a pasta de entrada...");
		File[] aux = input.listFiles();
		listOfFiles = new ArrayList<>();
		for (int i = 0; i < aux.length; i++) {
			listOfFiles.add(aux[i]);
		}
		aux = null;
		for (File f:listOfFiles) {
			if (!f.getName().endsWith("dat")) {
				listOfFiles.remove(f);
			}
		}
		System.out.println("OK!");
		return listOfFiles;
	}

	public ArrayList<String> parseFile(File f) {
		ArrayList<String> array = new ArrayList<>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(f));
			String linha;
			while ((linha = bf.readLine()) != null) { //enquanto o arquivo nao terminar
				array.add(linha); //adicionar ela ao array list
			}
			bf.close();
		} catch (IOException e) {
			System.out.println("Nao pude ler do arquivo.");
			e.printStackTrace();
		}
		return array;
	}

	public File createReportFile(File f) {
		File report = new File(output.getAbsolutePath() + "/" + f.getName().replaceFirst("[.][^.]+$", "") + ".done.dat");
		if (report.exists()) {
			report.delete();
		}
		try {
			report.createNewFile();
		} catch (IOException e) {
			System.out.println("Nao consegui criar o relatorio..");
			e.printStackTrace();
		}
		return report;
	}
}
