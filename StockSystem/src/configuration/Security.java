package configuration;

public interface Security {
	boolean isPasswordValid(String password);
	boolean isEmailValid(String email);
	
}