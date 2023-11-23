package br.com.pedro.escola.infra;

import br.com.pedro.escola.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AlunoNaoEncontrado (CPF cpf) {
		super("Aluno nao encontrado com CPF: " + cpf.getNumero());
	}

}
