package br.com.pedro.escola;

public class Email {
	private String endereco;
	

	public String getEndereco() {
		return endereco;
	}


	public Email(String endereco) {
		if(endereco == null || 
				endereco.matches("[A-Za-z0-9\\\\._-]+@[A-Za-z]+\\\\.[A-Za-z]+")) {
			throw new IllegalArgumentException("Email Invalido!");
		}
		
		this.endereco = endereco;
	}
}


	



