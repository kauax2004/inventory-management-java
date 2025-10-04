package interfaceGrafica;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import stock.Product;

@SuppressWarnings("serial")
public class CustomizeListProducts extends AbstractTableModel {
	private final String[] columns = {"ID", "NOME", "PREÇO DE COMPRA", "PREÇO DE VENDA", "QUANTIDADE"};
	ArrayList<Product> products;

    public CustomizeListProducts(ArrayList<Product> products) {
	this.products = products;
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = products.get(rowIndex);
		Object[] atribute = {product.getId(), product.getName(), product.getPurchasePrice(), product.getSalePrice(), product.getStockQuantity()};
		return atribute[columnIndex];
		}
}