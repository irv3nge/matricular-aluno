package br.com.pedro.escola.matricular;

import br.com.pedro.escola.Aluno;
import br.com.pedro.escola.CPF;
import br.com.pedro.escola.Email;

public class MatricularAlunoDTO {
	
	private String nomeAluno;
	private String nomecpfAluno;
	private String emailAluno;
	
	public MatricularAlunoDTO(String nomeAluno, String nomecpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.nomecpfAluno = nomecpfAluno;
		this.emailAluno = emailAluno;
	}
	
	public Aluno criarAluno() {
		return new Aluno (new CPF(nomecpfAluno) ,
				nomeAluno ,
				new Email(emailAluno));
	}
	
	

}
