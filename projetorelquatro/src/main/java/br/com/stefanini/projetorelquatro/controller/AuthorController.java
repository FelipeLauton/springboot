package br.com.stefanini.projetorelquatro.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.projetorelquatro.entity.Author;
import br.com.stefanini.projetorelquatro.entity.Post;
import br.com.stefanini.projetorelquatro.repository.AuthorRepository;
import br.com.stefanini.projetorelquatro.repository.PostRepository;

@ResponseBody
@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/findall")
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Author author){
		try {
			Set<Post> posts = author.getPosts();
			Author resp = authorRepository.save(author);
			for(Post p :posts) {
				p.setAuthor(resp);
				postRepository.save(p);
			}
			if(resp==null) {
				throw new Exception("Erro de gravação");
			}
			
		return ResponseEntity.status(200).body(resp);
		
		}catch(Exception ex) {
		return ResponseEntity.status(500).body("Error"+ex.getMessage());
		}
	}
}
