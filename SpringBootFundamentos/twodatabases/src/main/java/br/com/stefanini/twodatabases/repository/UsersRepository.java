package br.com.stefanini.twodatabases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.twodatabases.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
