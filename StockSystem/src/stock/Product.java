package stock;

import java.util.Objects;

public class Product {
	private String name;
	private String id;
	private double salePrice;
	private double purchasePrice;
	private int stockQuantity;
	
	public Product(String id, String name, double salePrice, double purchasePrice, int stockQuantity) {
		this.name = name;
		this.id = id;
		this.purchasePrice = purchasePrice;
		this.stockQuantity = stockQuantity;
		this.salePrice = salePrice;
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(double saleprice) {
		this.salePrice = saleprice;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public void setPurchasePrice(double purchaseprice) {
		this.purchasePrice = purchaseprice;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public void entryStock(int entry) {
		stockQuantity += entry;
	}
	
	public void exitStock(int exit) {
		stockQuantity -= exit;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + ", saleprice=" + salePrice + ", stockQuantity=" + stockQuantity
				+ ", purchaseprice=" + purchasePrice + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, purchasePrice, salePrice, stockQuantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(purchasePrice) == Double.doubleToLongBits(other.purchasePrice)
				&& Double.doubleToLongBits(salePrice) == Double.doubleToLongBits(other.salePrice)
				&& stockQuantity == other.stockQuantity;
	}
	
	
}