package interfaceGrafica;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import company.Account;
import company.Company;
import configuration.Security;
import stock.Product;

@SuppressWarnings("serial")
public class Screen extends JFrame implements ActionListener, Security{
	
	JTextField emailBox;
	JPasswordField passwordBox;
	JFrame stockScreen;
	Timer timer;
	
	public Screen() {
		
		stockScreen = new JFrame();
		stockScreen.setSize(1200,800);
		stockScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stockScreen.setLocationRelativeTo(null);
		stockScreen.setLayout(null);

		JLabel subtitle = new JLabel("Stock System");
		subtitle.setBounds(0, 90, 1200, 50);
		subtitle.setFont(new Font("Arial", Font.BOLD, 30));
		subtitle.setForeground(Color.WHITE);
		subtitle.setOpaque(true);
		subtitle.setBackground(Color.BLACK);
		subtitle.setHorizontalAlignment(JLabel.CENTER);
		stockScreen.add(subtitle);

		//button SIGN UP
		JButton buttonUp = new JButton("SIGN UP");
		buttonUp.setBounds(510,420,100,30);
		buttonUp.setFont(new Font("Arial", Font.BOLD, 15));
		buttonUp.setForeground(new Color(255,250,250));
		buttonUp.setBackground(new Color(00,80,00));
		buttonUp.addActionListener(this);
		stockScreen.add(buttonUp);

		//button SIGN IN
		JButton buttonIn = new JButton("SIGN IN");
		buttonIn.setBounds(660,420,100,30);
		buttonIn.setFont(new Font("Arial", Font.BOLD, 15));
		buttonIn.setForeground(new Color(255,250,250));
		buttonIn.setBackground(new Color(00,80,00));
		buttonIn.addActionListener(this :: enterIn);
		stockScreen.add(buttonIn);

		//TEXTOEmail
		JLabel labelEmail = new JLabel("Email: ");
		labelEmail.setBounds(380,250, 300,30);
		labelEmail.setFont(new Font("Arial", Font.BOLD, 22));
		stockScreen.add(labelEmail);

		//TEXTOsenha
		JLabel labelSenha = new JLabel("Senha: ");
		labelSenha.setBounds(380,350, 300,30);
		labelSenha.setFont(new Font("Arial", Font.BOLD, 22));
		stockScreen.add(labelSenha);

		//caixaEmail
		emailBox = new JTextField();
		emailBox.setBounds(490,250, 300,30);
		stockScreen.add(emailBox);

		//caixaSenha
		passwordBox = new JPasswordField();
		passwordBox.setBounds(490,350, 300,30);
		stockScreen.add(passwordBox);

		stockScreen.setVisible(true);
	}
	
	@Override
	public boolean isPasswordValid(String password) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[A-Za-z0-9]{8,}$";
        return password.matches(regex);
	}

	@Override
	public boolean isEmailValid(String email) {
		return email.matches("^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!isEmailValid(emailBox.getText())) {
			Error errorEmail = new Error();
			errorEmail.showEmailSignUpError(stockScreen);
		}
		else if(!isPasswordValid(new String(passwordBox.getPassword()))) {
			Error errorPassword = new Error();
			errorPassword.showPasswordSignUpError(stockScreen);
		}
		
		else {
			String filename = "DadosConta.txt";                     
			
			File f = new File(filename);                    
			try {
				FileWriter fw = new FileWriter(f,true);
				fw.write(emailBox.getText() + " " + new String(passwordBox.getPassword()) + "\n");
				fw.close();
			}
			catch(IOException e1){
				System.out.println("Erro de leitura/escrita.");
			}
			Account acc = new Account(emailBox.getText(),new String(passwordBox.getPassword()));
			new SignUpCompany(acc);
		}                                                                                            
		
		
	}
	
	Account accountSign;
	
	private void enterIn(ActionEvent actionevent1) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		Scanner input = new Scanner(System.in);
		String filename = "DadosConta.txt";
		boolean accountFound = false;
		
		try {
			File f = new File(filename);
			input = new Scanner(f);
			while(input.hasNext()) {
				String email1 = input.next();
				String password1 = input.next();
				Account account = new Account(email1, password1);
				accounts.add(account);
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
		}		

		for(Account account : accounts) {
		    if(account.getEmail().equalsIgnoreCase(emailBox.getText()) && account.getPassword().equalsIgnoreCase(new String(passwordBox.getPassword()))) {
		    	accountSign = new Account(emailBox.getText(),new String(passwordBox.getPassword()));
		    	accountFound = true;
		        break;
		    }
		}
		
		if(accountFound==true) {
			new CheckUpProducts(accountSign);
		} 
		else {
		    Error error = new Error();
		    error.showSignInError(stockScreen);
		}
		
		
		Account account = new Account(emailBox.getText(),new String(passwordBox.getPassword()));
		ArrayList<Company> companys = new ArrayList<Company>();
		String filename2 = "company"+ account.getEmail() +".txt";
        try {
            File f2 = new File(filename2);
            Scanner input2 = new Scanner(f2);
            while (input2.hasNext()) {
            	String razaoSocial = input2.next();
            	String cnpj = input2.next();
                String endereco = input2.next();
                String quantityEmployee = input2.next();
                String balanceYear = input2.next();
                String setor = input2.next();
                Company company = new Company(razaoSocial, cnpj, endereco, Integer.parseInt(quantityEmployee), Double.parseDouble(balanceYear), setor, account);
                companys.add(company);
            }
            input2.close();
        }catch (FileNotFoundException e1) {
            System.out.println("Arquivo não encontrado!");
        }
		
		Company company = new Company(companys.get(0).getName(), companys.get(0).getCnpj(), companys.get(0).getEndereco(), companys.get(0).getQuantityEmployee(), companys.get(0).getBalanceYear(), companys.get(0).getSetor(), account);
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