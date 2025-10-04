package stock;

import java.util.ArrayList;


public class Stock {
	private ArrayList<Product> products;
	
	public Stock() {
		this.products = new ArrayList<Product>();
	}

	public void addProducts(Product product) {
		products.add(product);
	}
	
	public void removeProducts(Product product) {
		products.remove(product);
	}
	
	public Product indexList(int index) {
		return products.get(index);
	}
	
	public String infoProd(String referencia){
		for(int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(referencia) || products.get(i).getId().equals(referencia)) {
				return products.get(i).getName() +"              |               "+ products.get(i).getId() 
			+"              |               "
			+ products.get(i).getPurchasePrice()+"              |               "+products.get(i).getStockQuantity(); 
			}
		}
		return "Produto não identificado";
	}
	
	public String calcNatValue() {
		double sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += products.get(i).getSalePrice() - products.get(i).getPurchasePrice();
		}
		return String.valueOf(sum);
	}
	
	public String calcBruteValue() {
		double sum = 0;
		for (int i = 0; i < products.size(); i++) {
			sum += products.get(i).getPurchasePrice();
		}
		return String.valueOf(sum);
	}

	public int quantityProducts() {
		return products.size();
	}
}