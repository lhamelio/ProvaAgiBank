package main; 
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import controller.FileController;
import model.Cliente;
import model.Operations;
import model.Venda;
import model.Vendedor;

public class Main {
	public static void main(String[] args) {
		FileController fC = new FileController();
		Operations op = new Operations();
		fC.checkDirectories();
		run(fC, op);
		
		try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(System.getenv("HOMEPATH") + "/data/in");
            path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
            while (true) {
            	System.out.println("Monitorando por adicoes na pasta...");
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (StandardWatchEventKinds.ENTRY_CREATE.equals(kind)) {
                    	Thread.sleep(1000);
                        run(fC, op);
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public static void run(FileController fC, Operations op) {
		ArrayList<File> listOfFiles = fC.openFiles();
		for (int i = 0; i < listOfFiles.size(); i++) {
			ArrayList<String> fileData = fC.parseFile(listOfFiles.get(i));
			ArrayList<Vendedor> arrayVendedor = new ArrayList<>();
			ArrayList<Cliente> arrayCliente = new ArrayList<>();
			ArrayList<Venda> arrayVenda = new ArrayList<>();
			op.createDataFromFile(fileData, arrayVendedor, arrayCliente, arrayVenda);
			File report = fC.createReportFile(listOfFiles.get(i));
			op.generateReport(report, arrayVendedor, arrayCliente, arrayVenda);
		}
	}

}
