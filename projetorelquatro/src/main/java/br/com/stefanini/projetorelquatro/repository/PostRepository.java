package br.com.stefanini.projetorelquatro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.stefanini.projetorelquatro.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	
}
