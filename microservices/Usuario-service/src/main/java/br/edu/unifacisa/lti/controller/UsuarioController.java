package br.edu.unifacisa.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifacisa.lti.model.Usuario;
import br.edu.unifacisa.lti.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "endPoint de Usuário")
@RestController
@RequestMapping(value = "/usuario-service")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Operation(summary = "Cadastra um usuário")
	@PostMapping
	public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){
		service.cadastrarUsuario(usuario);
		return ResponseEntity.ok(usuario);
	}
	
	@Operation(summary = "Lista todos os usuários")
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		return ResponseEntity.ok(service.listarUsuarios());
	}
	
	@Operation(summary = "Obtem um usuário por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obterUsuarioPorId(@PathVariable long id){
		return ResponseEntity.ok(service.getUsuarioById(id));
	}
	
	@Operation(summary = "Exclui um usuario por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<Usuario> deletarUsuarioPorId(@PathVariable long id){
		Usuario usuario = service.getUsuarioById(id);
		service.deletarUsuario(id);
		return ResponseEntity.ok(usuario);
	}
	
	@Operation(summary = "Atualiza os dados do usuário pelo ID")
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario, @PathVariable long id){
		service.editUsuario(usuario, id);
		return ResponseEntity.ok(usuario);
	}
}
