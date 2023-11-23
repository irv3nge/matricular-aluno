package br.com.pedro.escola.matricular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.pedro.escola.Aluno;
import br.com.pedro.escola.CPF;
import br.com.pedro.escola.infra.RepositorioDeAlunos;
import br.com.pedro.escola.infra.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoPersistido() {
		
		RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		MatricularAluno useCase = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
		
		
		MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano"
				, "123.456.789-00",
				"fulano@gmail.com");
		useCase.executa(dados);
		
		Aluno encontrado =  repositorio.buscarPorCPF(new CPF("123.456.789-00"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.456.789-00", encontrado.getCpf());
		assertEquals("fulano@gmail.com", encontrado.getEmail());
	}

}
