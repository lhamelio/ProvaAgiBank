package main;
import java.io.File;
import java.util.ArrayList;

import controller.FileController;
import model.Cliente;
import model.Operations;
import model.Venda;
import model.Vendedor;

public class Main {
	public static void main(String[] args) {
		FileController fC = new FileController();
		fC.checkDirectories();
		ArrayList<File> listOfFiles = fC.openFiles();
		for (File f:listOfFiles) {
			ArrayList<String> fileData = fC.parseFile(listOfFiles, f);
			ArrayList<Vendedor> arrayVendedor = new ArrayList<>();
			ArrayList<Cliente> arrayCliente = new ArrayList<>();
			ArrayList<Venda> arrayVenda = new ArrayList<>();
			Operations.createDataFromFile(fileData, arrayVendedor, arrayCliente, arrayVenda);
			File report = fC.createReportFile(f);
		}
	}

}
