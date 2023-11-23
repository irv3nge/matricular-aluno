package br.com.pedro.escola.infra;

import java.util.ArrayList;
import java.util.List;

import br.com.pedro.escola.Aluno;
import br.com.pedro.escola.CPF;
import br.com.pedro.escola.RepositorioDeAlunos;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {
	private List<Aluno> matriculados = new ArrayList<>();

	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);

	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontrado(cpf));
	}

	@Override
	public List<Aluno> ListarAlunosMatriculados() {
		return this.matriculados;
	}
	

}
