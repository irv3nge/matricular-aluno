package br.com.pedro.escola.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.pedro.escola.Aluno;
import br.com.pedro.escola.CPF;
import br.com.pedro.escola.Email;
import br.com.pedro.escola.Telefone;

public class RepositorioDeAlunos implements br.com.pedro.escola.RepositorioDeAlunos {
	
	private final Connection conecction;
	

	public RepositorioDeAlunos(Connection conecction) {
		this.conecction = conecction;
	}

	@Override
	public void matricular(Aluno aluno) {
		
		try {
			String sql = "INSERT INTO ALUNO VALUES(?,?,?)";
			PreparedStatement ps = conecction.prepareStatement(sql);
			ps.setString(1 , aluno.getCpf());
			ps.setString(2 , aluno.getNome());
			ps.setString(3 , aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(? , ?)";
			ps = conecction.prepareStatement(sql);
			for (Telefone telefone : aluno.getTelefones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
	    try {
	        String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
	        PreparedStatement ps = conecction.prepareStatement(sql);
	        ps.setString(1, cpf.getNumero());

	        ResultSet rs = ps.executeQuery();
	        boolean encontrou = rs.next();
	        if (!encontrou) {
	            throw new AlunoNaoEncontrado(cpf);
	        }

	        String nome = rs.getString("nome");
	        Email email = new Email(rs.getString("email"));
	        Aluno encontrado = new Aluno(cpf, nome, email);

	        Long id = rs.getLong("id");
	        sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
	        ps = conecction.prepareStatement(sql);
	        ps.setLong(1, id);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            String numero = rs.getString("numero");
	            String ddd = rs.getString("ddd");
	            encontrado.adcionarTelefone(ddd, numero);
	        }

	        return encontrado;
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	}


	@Override
	public List<Aluno> ListarAlunosMatriculados() {
		
		return null;
	}

}
