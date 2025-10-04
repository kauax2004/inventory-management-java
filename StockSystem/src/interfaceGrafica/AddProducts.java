package interfaceGrafica;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import company.Account;
import stock.Product;

@SuppressWarnings("serial")
public class AddProducts extends JPanel {

    
    Account account;
    
    @SuppressWarnings("unused")
	public AddProducts(Account acc) {
        account = acc;

        setLayout(null);
        setBackground(Color.WHITE);

        JLabel textProductName = new JLabel("Nome do produto: ");
        textProductName.setBounds(237, 200, 150, 30);
        add(textProductName);

        JTextField productName = new JTextField();
        productName.setBounds(387, 200, 400, 30);
        add(productName);

        JLabel textIdProduct = new JLabel("Id do produto: ");
        textIdProduct.setBounds(237, 250, 150, 30);
        add(textIdProduct);

        JTextField idProduct = new JTextField();
        idProduct.setBounds(387, 250, 400, 30);
        add(idProduct);

        JLabel textStockQuantity = new JLabel("Quantidade: ");
        textStockQuantity.setBounds(237, 300, 150, 30);
        add(textStockQuantity);

        JTextField quantity = new JTextField();
        quantity.setBounds(387, 300, 400, 30);
        add(quantity);

        JLabel textSalePrice = new JLabel("Preço de venda: ");
        textSalePrice.setBounds(237, 350, 150, 30);
        add(textSalePrice);

        JTextField sPrice = new JTextField();
        sPrice.setBounds(387, 350, 400, 30);
        add(sPrice);
        
        JLabel textPurchasePrice = new JLabel("Preço de compra: ");
        textPurchasePrice.setBounds(237, 400, 150, 30);
        add(textPurchasePrice);

        JTextField pPrice = new JTextField();
        pPrice.setBounds(387, 400, 400, 30);
        add(pPrice);

        JButton adicionar = new JButton("Adicionar produto");
        adicionar.setBounds(480, 500, 200, 40);
        add(adicionar);
        
        setVisible(false);
        setVisible(true);

        adicionar.addActionListener(e -> {
            String name = productName.getText();
            String id = idProduct.getText();
            int stockQuantity = Integer.parseInt(quantity.getText());
            double salePrice = Double.parseDouble(sPrice.getText());
            double purchasePrice = Double.parseDouble(pPrice.getText()); 

            String filename = String.format("prods%s.txt", account.getEmail());
            File f = new File(filename);
            try (FileWriter fw = new FileWriter(f, true)) {
                Product productAdded = new Product(id, name, salePrice, purchasePrice, stockQuantity);
                fw.write(id+" "+name+" "+salePrice+" "+purchasePrice+" "+stockQuantity+ "\n");
                fw.close();
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso");
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "Erro de leitura/escrita: " + e1.getMessage());
            }
        });
    }
}