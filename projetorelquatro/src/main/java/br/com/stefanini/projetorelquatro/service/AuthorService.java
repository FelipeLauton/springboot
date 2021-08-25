package br.com.stefanini.projetorelquatro.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stefanini.projetorelquatro.entity.Author;
import br.com.stefanini.projetorelquatro.entity.Post;
import br.com.stefanini.projetorelquatro.interfaces.IAuthorService;
import br.com.stefanini.projetorelquatro.repository.AuthorRepository;
import br.com.stefanini.projetorelquatro.repository.PostRepository;

@Service
public class AuthorService implements IAuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Transactional(rollbackOn= {Exception.class})
	public Object createAuthor(Author author) throws Exception {
		Set<Post> posts = author.getPosts();
		Author resp = authorRepository.save(author);
		if(resp==null) {
			throw new Exception("Autor não foi gravado...");
		}
		for(Post p: posts) {
			p.setAuthor(resp);
			postRepository.save(p);
		}
		return resp;
	}

	
}
