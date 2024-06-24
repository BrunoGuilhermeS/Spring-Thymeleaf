package br.com.academy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.academy.model.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer> {
	
	@Query("select p from Aluno p where p.status = 'ATIVO'")
	public List<Aluno> findByStatusAtivos();
	
	@Query("select p from Aluno p where p.status = 'INATIVO'")
	public List<Aluno> findByStatusInativos();
	
	@Query("select p from Aluno p where p.status = 'CANCELADO'")
	public List<Aluno> findByStatusCancelados();
	
	@Query("select p from Aluno p where p.status = 'TRANCADO'")
	public List<Aluno> findByStatusTrancados();
		
	public List<Aluno> findByNomeContainingIgnoreCase(String nome);
}
