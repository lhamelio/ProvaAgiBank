package model;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.Queue;

public class Operations {
	public void createDataFromFile(ArrayList<String> array, ArrayList<Vendedor> arrayVendedor, ArrayList<Cliente> arrayCliente, ArrayList<Venda> arrayVenda) {
		System.out.println("Populando...");
		for (String s:array) {
			String[] linha = s.split("ç");
			switch (linha[0]) {
			case "001":
				Vendedor v = new Vendedor(linha[1], linha[2], Double.parseDouble(linha[3]));
				arrayVendedor.add(v);
				break;
			case "002":
				Cliente c = new Cliente(linha[1], linha[2], linha[3]);
				arrayCliente.add(c);
				break;
			case "003":
				List<Item> sales = new ArrayList<>();
				Queue<String> values = parseData(linha[2]);
				while (!values.isEmpty()) {
					try {
						Item item = new Item(values.dequeue(), Integer.parseInt(values.dequeue()), Double.parseDouble(values.dequeue()));
						sales.add(item);
					} catch (InterruptedException e) {
						System.out.println("Thread interrompida!");
						e.printStackTrace();
					}
				}
				Venda venda = new Venda (linha[1], sales, linha[3]);
				arrayVenda.add(venda);
			}
		}
		System.out.println("Pronto!");
	}

	public void generateReport(ArrayList<Vendedor> arrayVendedor, ArrayList<Cliente> arrayCliente, ArrayList<Venda> arrayVenda) {

	}

	private Queue<String> parseData(String string) {
		Queue<String> values = new Queue<>();
		Pattern p = Pattern.compile("([0-9]*[.])?[0-9]+");
		Matcher m = p.matcher(string);
		while(m.find()) {
			values.enqueue(m.group());
		}
		return values;
	}
}
