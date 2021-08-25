package br.com.stefanini.projetorelquatro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.stefanini.projetorelquatro.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	public Author findByEmail(String email);
	
	@Query(value="select a.id, a.name, a.email from author a where a.name= :name", nativeQuery=true)
	public List<Author> findByNameExist(@Param("name")String name);
}
