package br.edu.unifacisa.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifacisa.lti.model.Usuario;
import br.edu.unifacisa.lti.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	
	public void cadastrarUsuario(Usuario usuario) {
		repository.save(usuario);
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = repository.findAll();
		return usuarios;
	}
	
	public Usuario getUsuarioById(long id) {
		Usuario usuario = repository.findById(id).get();
		return usuario;
	}
	
	public Usuario editUsuario(Usuario usuarioAtualizado, long id) {
		Usuario usuario = repository.findById(id).get();
		usuario.setSenha(usuarioAtualizado.getSenha());
		usuario.setNickname(usuarioAtualizado.getNickname());
		repository.save(usuario);
		system.out.println("git");
		return usuario;
	}
	
	public void deletarUsuario(long id) {
		repository.deleteById(id);
	}
}
