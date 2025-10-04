package interfaceGrafica;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import stock.Product;

public class ListProduct {
	ArrayList<Product> products;
		
	public ListProduct(ArrayList<Product> products) {
		this.products = products;
	}

	public JScrollPane createScrollList() {      //implementaçao da lista feita dentro da funçao da lista JTable, colocando dentro de um tela com rolagem
		JTable lista = new JTable(new CustomizeListProducts(products));
		return new JScrollPane(lista);										//criando, de fato, a lista
	}
}