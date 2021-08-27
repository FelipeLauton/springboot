package br.com.stefanini.twodatabases.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.twodatabases.database.UsersEventDao;
import br.com.stefanini.twodatabases.entity.Users;
import br.com.stefanini.twodatabases.model.UsersEvent;
import br.com.stefanini.twodatabases.repository.UsersRepository;

@ResponseBody 
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UsersRepository repository;
	
	@GetMapping("/list")
	public ResponseEntity<?> findAll(){
		try {
			return ResponseEntity.status(200).body(new UsersEventDao().findAll());
		}catch(Exception ex) {
			return ResponseEntity.status(500).body("error: "+ ex.getMessage());
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Users users){
		try {
			Users resp = repository.save(users);
			if(resp==null) {
				throw new Exception("nao consegui");
			}
			UsersEvent event = new UsersEvent(String.valueOf(resp.getId()),
					"save","ok",resp.toString());
			new UsersEventDao().save(event);
			
			return ResponseEntity.status(200).body(users);
		}catch(Exception ex) {
			return ResponseEntity.status(500).body("error: "+ ex.getMessage());
		}
	}
	
	 
}
