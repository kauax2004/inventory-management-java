package interfaceGrafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import company.Account;
import company.Company;
import stock.Product;

@SuppressWarnings("serial")
public class SignUpCompany extends JFrame implements ActionListener {

    Account account;
    JTextField RazaoSocialBox;
    JTextField CnpjBox;
    JTextField EnderecoBox;
    JTextField QuantityEmployeeBox;
    JTextField BalanceYearBox;
    JTextField SetorBox;
    
    JTabbedPane options = new JTabbedPane();
    JPanel cadastroEmpresa = new JPanel();

    public SignUpCompany(Account acc) {

    	account = acc; 
    	configMenu();
    	add(BorderLayout.CENTER, options);
        options.addTab("Informações do cadastro", cadastroEmpresa);
        cadastroEmpresa.setBackground(Color.WHITE);
        options.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int option = options.getSelectedIndex();
                String title = options.getTitleAt(option);
                System.out.println(title);
            }
        });

        cadastroEmpresa.setLayout(null);
    
        // Add subtitle label
        JLabel subtitle = new JLabel("Dados de Empresa");
        subtitle.setBounds(0, 90, 1200, 50); // Adjust position and size as needed
        subtitle.setFont(new Font("Arial", Font.BOLD, 30));
        subtitle.setForeground(Color.WHITE);
        subtitle.setOpaque(true);
        subtitle.setBackground(Color.BLACK);
        subtitle.setHorizontalAlignment(JLabel.CENTER); // Center the text
        cadastroEmpresa.add(subtitle);

        JLabel labelRazaoSocial = new JLabel("Razão social: ");    
        labelRazaoSocial.setBounds(290, 230, 300, 30);
        labelRazaoSocial.setFont(new Font("Arial", Font.BOLD, 22));
        labelRazaoSocial.setBackground(new Color(90, 90, 90));
        cadastroEmpresa.add(labelRazaoSocial);

        RazaoSocialBox = new JTextField();
        RazaoSocialBox.setBounds(550, 230, 300, 30);
        cadastroEmpresa.add(RazaoSocialBox);

        JLabel labelCnpj = new JLabel("CNPJ: ");
        labelCnpj.setBounds(290, 290, 300, 30);
        labelCnpj.setFont(new Font("Arial", Font.BOLD, 22));
        cadastroEmpresa.add(labelCnpj);

        CnpjBox = new JTextField();
        CnpjBox.setBounds(550, 290, 300, 30);
        cadastroEmpresa.add(CnpjBox);

        JLabel labelEndereco = new JLabel("Endereço: ");
        labelEndereco.setBounds(290, 350, 300, 30);
        labelEndereco.setFont(new Font("Arial", Font.BOLD, 22));
        cadastroEmpresa.add(labelEndereco);

        EnderecoBox = new JTextField();
        EnderecoBox.setBounds(550, 350, 300, 30);
        cadastroEmpresa.add(EnderecoBox);

        JLabel labelQuantityEmployee = new JLabel("Numero de funcionários: ");
        labelQuantityEmployee.setBounds(290, 410, 300, 30);
        labelQuantityEmployee.setFont(new Font("Arial", Font.BOLD, 22));
        cadastroEmpresa.add(labelQuantityEmployee);

        QuantityEmployeeBox = new JTextField();
        QuantityEmployeeBox.setBounds(550, 410, 300, 30);
        cadastroEmpresa.add(QuantityEmployeeBox);

        JLabel labelBalanceYear = new JLabel("Balanço anual: ");
        labelBalanceYear.setBounds(290, 470, 300, 30);
        labelBalanceYear.setFont(new Font("Arial", Font.BOLD, 22));
        cadastroEmpresa.add(labelBalanceYear);

        BalanceYearBox = new JTextField();
        BalanceYearBox.setBounds(550, 470, 300, 30);
        cadastroEmpresa.add(BalanceYearBox);

        JLabel labelSetor = new JLabel("Setor: ");
        labelSetor.setBounds(290, 530, 300, 30);
        labelSetor.setFont(new Font("Arial", Font.BOLD, 22));
        cadastroEmpresa.add(labelSetor);

        SetorBox = new JTextField();
        SetorBox.setBounds(550, 530, 300, 30);
        cadastroEmpresa.add(SetorBox);

        JButton buttonConfirm = new JButton("CONFIRMA");
        buttonConfirm.setBounds(490, 630, 150, 50);
        buttonConfirm.setFont(new Font("Arial", Font.BOLD, 20));
        buttonConfirm.setForeground(new Color(255, 250, 250));
        buttonConfirm.setBackground(new Color(0, 80, 0));
        buttonConfirm.addActionListener(this);
        cadastroEmpresa.add(buttonConfirm);
    }
    
    private void configMenu() {
        setTitle("Menu de operações");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		 
		
		String razaoSocial = RazaoSocialBox.getText();
        String cnpj = CnpjBox.getText();
        String endereco = EnderecoBox.getText();
        int quantityEmployee = Integer.parseInt(QuantityEmployeeBox.getText());
        double balanceYear = Double.parseDouble(BalanceYearBox.getText());
        String setor = SetorBox.getText();

        String filename = String.format("company%s.txt", account.getEmail());
        File f = new File(filename);
        try (FileWriter fw = new FileWriter(f, true)) {
            @SuppressWarnings("unused")
			Company companyAdded = new Company(razaoSocial, cnpj, endereco, quantityEmployee, balanceYear, setor, account);
            fw.write(razaoSocial+" "+cnpj+" "+endereco+" "+quantityEmployee+" "+balanceYear+" "+setor+"\n");
            fw.close();
            JOptionPane.showMessageDialog(null, "Empresa adicionada com sucesso!");
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Erro de leitura/escrita: " + e1.getMessage());
        }
        
    	Company company = new Company(RazaoSocialBox.getText(), CnpjBox.getText(), EnderecoBox.getText(), 
    			Integer.parseInt(QuantityEmployeeBox.getText()), 
    			Double.parseDouble(BalanceYearBox.getText()), SetorBox.getText(), account);
		ArrayList<Product> products = new ArrayList<Product>();
        String filename1 = "prods"+ account.getEmail() +".txt";
        try {
            File f1 = new File(filename1);
            Scanner input1 = new Scanner(f1);
            while (input1.hasNext()) {
            	String id = input1.next();
            	String name = input1.next();
                String saleprice = input1.next();
                String purchaseprice = input1.next();
                String stockQuantity = input1.next();
                Product product = new Product(id, name, Double.parseDouble(saleprice), Double.parseDouble(purchaseprice), Integer.parseInt(stockQuantity));
                products.add(product);
            }
            input1.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Arquivo não encontrado!");
        }
        
        new MainInterface(account, company, products);
    }
}