package company;

import stock.Stock;

public class Company {
	protected String name;
	protected String cnpj;
	protected String endereco;
	private int quantityEmployee;
	private double balanceYear;
	private String setor;
	private Account account;
	@SuppressWarnings("unused")
	private Stock stock;

	public Company(String name, String cnpj, String endereco, int quantityEmployee, double balanceYear, String setor,
			Account account) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.quantityEmployee = quantityEmployee;
		this.balanceYear = balanceYear;
		this.setor = setor;
		this.account = account;
		stock = new Stock();
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", cnpj=" + cnpj + ", endereco=" + endereco + ", quantityEmployee="
				+ quantityEmployee + ", account=" + account + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getQuantityEmployee() {
		return quantityEmployee;
	}

	public void setQuantityEmployee(int quantityEmployee) {
		this.quantityEmployee = quantityEmployee;
	}

	public double getBalanceYear() {
		return balanceYear;
	}

	public String getSetor() {
		return setor;
	}
	
	
	
}