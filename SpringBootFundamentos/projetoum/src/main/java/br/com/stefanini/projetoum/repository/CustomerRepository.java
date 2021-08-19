package br.com.stefanini.projetoum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.projetoum.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
}
