package br.com.pedro.escola;

import br.com.pedro.escola.infra.RepositorioDeAlunos;
import br.com.pedro.escola.infra.RepositorioDeAlunosEmMemoria;
import br.com.pedro.escola.matricular.MatricularAluno;
import br.com.pedro.escola.matricular.MatricularAlunoDTO;

public class MatricularAlunoPorLinhaDeComando {
	public static void main(String[] args) {
		String nome = "Fulano";
		String cpf = "123.456.789-00";
		String email =  "fulano@gmail.com";
		
		
		MatricularAluno matricular =  new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		
		matricular.executa(new MatricularAlunoDTO(nome, nome, email));
		
		
		
		
		
	}

}
