package br.com.pedro.escola.matricular;

import br.com.pedro.escola.Aluno;
import br.com.pedro.escola.infra.RepositorioDeAlunos;
import br.com.pedro.escola.infra.RepositorioDeAlunosEmMemoria;

public class MatricularAluno {
	
	private final RepositorioDeAlunosEmMemoria repositorio;

	public MatricularAluno(RepositorioDeAlunosEmMemoria repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executa(MatricularAlunoDTO dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
	}
	
	

}
