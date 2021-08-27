package br.com.stefanini.projetoredireciona.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.stefanini.projetoredireciona.entity.Usuario;
import br.com.stefanini.projetoredireciona.repository.UsuarioRepository;

@ResponseBody
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Usuario usuario){
		try {
			Usuario resp = usuarioRepository.save(usuario);
			return ResponseEntity.status(200).body(resp);
		}catch(Exception ex) {
			return ResponseEntity.status(500).body("error:"+ex.getMessage());
		}
	}
	
	@RequestMapping(value="/logar",method=RequestMethod.POST)
	public RedirectView controllervendedor(@RequestBody Usuario usuario, HttpServletRequest request) {
		try {
		Usuario resp = usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
		
			if(resp==null) {
				throw new Exception("Login invalido");
			}
			String redirectURL = request.getScheme() + "://localhost:1237/api/vendedor";
			return new RedirectView(redirectURL);
		}catch(Exception ex) {
			String redirectURL = request.getScheme() + "://localhost:1237/usuario/message";
			return new RedirectView(redirectURL);
		}
	}
	
	@GetMapping("/message")
	public ResponseEntity<?> message(){
		return ResponseEntity.status(200).body("Error Login");
	}
}
