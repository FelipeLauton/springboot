package br.com.stefanini.projetorelacionamento.controller;

import java.util.List;

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
import br.com.stefanini.projetorelacionamento.repository.AddressRepository;

@ResponseBody
@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressRepository addressRepository;
	
	@GetMapping("/findall")
	public List<Address> findAllAddress(){
		return addressRepository.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Address address){
		try {
			
			addressRepository.save(address);
			
			if(address == null) {
				throw new Exception("Endereço Nao Gravado");
			}
			return ResponseEntity.status(200).body(address);
		}catch(Exception ex) {
			ResponseException response = new ResponseException("error","Usuario não gravado");
			return ResponseEntity.status(200).body(response);
		}
	}
}
