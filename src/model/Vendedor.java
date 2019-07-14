package model;
public class Vendedor{

	private String cpf;
	private String name;
	private double salary;
	
	public Vendedor() {
		
	}
	
	public Vendedor(String cpf, String name, double salary) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
