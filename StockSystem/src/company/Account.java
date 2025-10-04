package company;

import java.util.Objects;

import stock.Stock;

public class Account {
	private String email;
	private String password;
	private Stock stock;
	
	public Account(String email, String password) {
		
		this.email = email;
		this.password = password;
		this.stock = new Stock();
		
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Stock getStock() {
		return stock;
	}
	
	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, password, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(stock, other.stock);
	}
	
	
}