package interfaceGrafica;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import company.Account;
import company.Company;
import stock.Product;

@SuppressWarnings("serial")
public class MainInterface extends JFrame {
	Product product;

    public MainInterface(Account acc, Company company, ArrayList<Product> products) {
        setTitle("Gerenciamento de Produtos");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        

        JTabbedPane tabbedPane = new JTabbedPane();

        AddProducts addProductsPanel = new AddProducts(acc);
        CheckUpProducts consultarProdutoPanel = new CheckUpProducts(acc);
        AccountInformation  accountInformationPanel = new AccountInformation(company);
        
        ListProduct listProduct = new ListProduct(products);
        
        tabbedPane.addTab("Adicionar Produto", addProductsPanel);
        tabbedPane.addTab("Consultar Produto", consultarProdutoPanel);
        tabbedPane.addTab("Lista de Produtos", listProduct.createScrollList());
        tabbedPane.addTab("Informações da Conta", accountInformationPanel);

        add(tabbedPane, BorderLayout.CENTER);

        setVisible(false);
        setVisible(true);
    }
}