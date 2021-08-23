package br.com.stefanini.projetorelacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.projetorelacionamento.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	public Users findByEmail(String email);
		
}
