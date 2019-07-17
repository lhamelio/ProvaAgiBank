package model;

public class Item {
	private int id;
	private String itemid;
	private int quantity;
	private double price;
	
	public Item() {
		
	}
	public Item(String itemid, int quantity, double price) {
		super();
		this.itemid = itemid;
		this.quantity = quantity;
		this.price = price;
	}
	public Item(String itemid, int quantity, double price, Venda venda) {
		super();
		this.itemid = itemid;
		this.quantity = quantity;
		this.price = price;
	}
	public Item(String itemid, double price) {
		super();
		this.itemid = itemid;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalSale() {
		return price * quantity;
	}
	
	
}
