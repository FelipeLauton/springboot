package br.com.stefanini.projetorelacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.projetorelacionamento.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	public Address findByCity(String city);
}
