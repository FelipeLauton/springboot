package br.com.stefanini.projetorelacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.stefanini.projetorelacionamento.entity.Address;
import br.com.stefanini.projetorelacionamento.entity.Users;
import br.com.stefanini.projetorelacionamento.repository.AddressRepository;
import br.com.stefanini.projetorelacionamento.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Transactional(rollbackFor= {RuntimeException.class})
	public Users saveUsersAndAddress(Users u, Address a) {
		Address address = a; 
		Users user = userRepository.save(u); 
		address.setUser(user); 
		addressRepository.save(address);
		return user;
	}
	
	public UsersService() {
		
	}
}
