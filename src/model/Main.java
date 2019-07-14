package model;
import java.io.File;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		FileController.checkDirectories();
		ArrayList<File> listOfFiles = FileController.openFiles();
		for (File f:listOfFiles) {
			ArrayList<String> fileData = FileController.parseFile(listOfFiles, f);
			ArrayList<Vendedor> arrayVendedor = new ArrayList<Vendedor>();
			ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
			ArrayList<Venda> arrayVenda = new ArrayList<Venda>();
			Operations.createDataFromFile(fileData, arrayVendedor, arrayCliente, arrayVenda);
			
		}
	}

}
