package model;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	private String id;
	private List<Item> item = new ArrayList<>();
	private String vendedor;
	
	public Venda() {
		
	}
	
	public Venda(String id, List<Item> item, String vendedor) {
		super();
		this.id = id;
		this.item = item;
		this.vendedor = vendedor;
	}
	
	public Venda(String id, String vendedor) {
		super();
		this.id = id;
		this.vendedor = vendedor;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
}
