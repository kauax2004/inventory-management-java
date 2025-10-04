package interfaceGrafica;

import javax.swing.JLabel;
import javax.swing.JPanel;

import company.Company;

@SuppressWarnings("serial")
public class AccountInformation extends JPanel {

    JPanel accountInformations = new JPanel();

    @SuppressWarnings("unused")
	private Company company;
    
    public AccountInformation(Company company) {
        this.company = company;

        setLayout(null);

        JLabel cnpj = new JLabel("CNPJ da empresa: " + company.getCnpj());
        accountInformations.add(cnpj);
        cnpj.setBounds(440, 150, 300, 30);
        add(cnpj);

        JLabel addres = new JLabel("Endereço da empresa: " + company.getEndereco());
        accountInformations.add(addres);
        addres.setBounds(440, 200, 300, 30);
        add(addres);

        JLabel numberOfEmployees = new JLabel("Número de empregados: " + company.getQuantityEmployee());
        accountInformations.add(numberOfEmployees);
        numberOfEmployees.setBounds(440, 250, 300, 30);
        add(numberOfEmployees);

        JLabel companyName = new JLabel("Nome da empresa: " + company.getName());
        accountInformations.add(companyName);
        companyName.setBounds(440, 300, 3000, 30);
        add(companyName);
        
        setVisible(false);
        setVisible(true);
    }

}