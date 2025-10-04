package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import company.Account;
import stock.Product;
import stock.Stock;

@SuppressWarnings("serial")
public class CheckUpProducts extends JPanel implements ActionListener {

    JCheckBox checkBoxId;
    JCheckBox checkBoxNome;
    Product produtoPesquisa;
    Account account;
    JTextField consulta;

    public CheckUpProducts(Account acc) {
    	account = acc; 

        setLayout(null);
        
        JLabel subtitle3 = new JLabel("Consulta de Produtos");
        subtitle3.setBounds(0,100, 1200,35); // Adjust position and size as needed
        subtitle3.setFont(new Font("Arial", Font.BOLD, 20)); 
        subtitle3.setOpaque(true);
        subtitle3.setHorizontalAlignment(JLabel.CENTER); 
        subtitle3.setBackground(Color.LIGHT_GRAY);
        subtitle3.setForeground(Color.BLACK);
        add(subtitle3);
       
        JLabel titulo = new JLabel("Escolha uma referência para pesquisa:");
        titulo.setBounds(94, 288, 500, 30);
        titulo.setForeground(Color.BLACK);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));


        checkBoxId = new JCheckBox("  BUSCAR POR ID");
        checkBoxNome = new JCheckBox("  BUSCAR POR NOME");

        checkBoxId.setBounds(90, 320, 300, 35);
        checkBoxNome.setBounds(90, 350, 300, 35);

        checkBoxId.setBackground(Color.LIGHT_GRAY);
        checkBoxId.setFont(new Font("Arial", Font.PLAIN, 14));
        checkBoxId.setForeground(Color.WHITE);
        checkBoxId.setBorder(new LineBorder(Color.BLACK, 1, true));

        checkBoxNome.setBackground(Color.LIGHT_GRAY);
        checkBoxNome.setFont(new Font("Arial", Font.PLAIN, 14));
        checkBoxNome.setForeground(Color.WHITE);
        checkBoxNome.setBorder(new LineBorder(Color.BLACK, 1, true));

        add(titulo);
        add(checkBoxId);
        add(checkBoxNome);

        JLabel labelref = new JLabel("Referencia: ");
        labelref.setBounds(420, 335, 300, 30);
        labelref.setFont(new Font("Arial", Font.BOLD, 22));
        add(labelref);

        consulta = new JTextField();
        consulta.setBounds(550, 335, 300, 30);
        add(consulta);

        JButton buttonConsulta = new JButton("ENTER");
        buttonConsulta.setBounds(920, 335, 120, 30);
        buttonConsulta.setFont(new Font("Arial", Font.BOLD, 15));
        buttonConsulta.setForeground(new Color(255, 250, 250));
        buttonConsulta.setBackground(new Color(0, 80, 0));
        add(buttonConsulta);
        buttonConsulta.addActionListener(this);
        
        setVisible(false);
        setVisible(true);
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Stock stock = new Stock();
        String filename = "prods"+ account.getEmail() +".txt";
        try {
            File f = new File(filename);
            Scanner input = new Scanner(f);
            while (input.hasNext()) {
                String name = input.next();
                String id = input.next();
                String saleprice = input.next();
                String purchaseprice = input.next();
                String stockQuantity = input.next();
                Product product = new Product(name, id, Double.parseDouble(saleprice), Double.parseDouble(purchaseprice), Integer.parseInt(stockQuantity));
                stock.addProducts(product);
            }
            input.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Arquivo não encontrado!");
        }
        
        JLabel subtitle = new JLabel(stock.infoProd(consulta.getText()));
        subtitle.setBounds(80, 520, 1000, 25); // Adjust position and size as needed
        subtitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        subtitle.setOpaque(true);
        subtitle.setHorizontalAlignment(JLabel.CENTER); 
        subtitle.setBackground(Color.LIGHT_GRAY);
        subtitle.setForeground(Color.BLACK);
        add(subtitle);
        
        JLabel subtitle2 = new JLabel("                  NOME                               ID                           	    VALOR                                QUANTIDADE       ");
        subtitle2.setBounds(80,480, 1000,25); // Adjust position and size as needed
        subtitle2.setFont(new Font("Arial", Font.BOLD, 20)); 
        subtitle2.setOpaque(true);
        subtitle2.setHorizontalAlignment(JLabel.CENTER); 
        subtitle2.setBackground(Color.LIGHT_GRAY);
        subtitle2.setForeground(Color.BLACK);
        add(subtitle2);
        
        System.out.println(stock.infoProd(consulta.getText()));
        
        setVisible(false);
        setVisible(true);
    }
}
