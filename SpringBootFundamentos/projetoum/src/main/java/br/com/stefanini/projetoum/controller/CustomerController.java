package br.com.stefanini.projetoum.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.projetoum.entity.Customer;
import br.com.stefanini.projetoum.interfaces.ICustomerValidation;
import br.com.stefanini.projetoum.repository.CustomerRepository;
import br.com.stefanini.projetoum.utils.CustomerValidation;

@ResponseBody
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
		@PostMapping("/save")
		public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
			String message ="";
			try {
				Customer resp = customer;
				ICustomerValidation valida = new CustomerValidation();
				if(valida.isEmail(resp.getEmail()) && valida.isNameCustomer(resp.getNameCustomer())) {
					resp = customerRepository.save(resp);
				}else {
					throw new Exception("Dados Invalidos");
				}
					return ResponseEntity.status(200).body(resp);
			}catch(Exception ex){
				return ResponseEntity.status(500).body("Mensagem de error:"+ message);
			}
		}
		
		@GetMapping("/listagem")
		public List<Customer> findAll(){
			return customerRepository.findAll();
		}
}
