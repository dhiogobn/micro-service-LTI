package br.edu.unifacisa.lti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unifacisa.lti.model.Usuario;
import br.edu.unifacisa.lti.repository.UsuarioRepository;

@SpringBootApplication
public class UsuarioServiceApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsuarioServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Usuario usuario = new Usuario("dhiogobn", "12312451", "dhiogobn@gmail.com", "dhiogo bandeira");
//		repository.save(usuario);
		
	}

}
