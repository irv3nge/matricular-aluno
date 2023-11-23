package br.com.pedro.escola;

public interface CifradorDeSenha {
	
	String cifrarSenha(String senha);
	
	boolean validarSenhaCifra(String senhaCifrada , String senha);

}
