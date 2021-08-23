package br.com.stefanini.projetorelacionamento.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.projetorelacionamento.dto.response.ResponseException;
import br.com.stefanini.projetorelacionamento.entity.Address;
import br.com.stefanini.projetorelacionamento.entity.Users;
import br.com.stefanini.projetorelacionamento.repository.AddressRepository;
import br.com.stefanini.projetorelacionamento.repository.UsersRepository;
import br.com.stefanini.projetorelacionamento.service.UsersService;


@ResponseBody
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UsersService service;
	
	@GetMapping("/findall")
	public List<Users> findAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/findbyid/{id}")
	public ResponseEntity<?> findById(@PathParam("id")Long id){
		Users user;
		try {
			user = userRepository.findById(id).get();
			
			if(user == null) {
				throw new Exception("Usuario não encontrado:");
			}
			return ResponseEntity.status(200).body(user);
		}catch(Exception ex) {
			ResponseException resp = new ResponseException("status","erro na busca");
			return ResponseEntity.status(500).body(resp);
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Users users){
		try {
			Address address = users.getAddress(); //resgato o relacionamento
			Users user = userRepository.save(users); //gero a chave primaria
			address.setUser(user); //seto a chave primaria
			addressRepository.save(address); //salvo o relacionamento
			
			if(user == null) {
				throw new Exception("Usuario Invalido");
			}
			return ResponseEntity.status(200).body(user);
		}catch(Exception ex) {
			ResponseException response = new ResponseException("error","Usuario não gravado");
			return ResponseEntity.status(500).body(response);
		}
	}
	
	
	@PostMapping("/saved")
	public ResponseEntity<?> saved(@RequestBody Users users){
		try {
			Users resp = service.saveUsersAndAddress(users, users.getAddress());
			return ResponseEntity.status(200).body(resp);
		}catch(Exception ex) {
			ResponseException response = new ResponseException("error","Usuario não gravado");
			return ResponseEntity.status(500).body(response);
		}
	}
}
