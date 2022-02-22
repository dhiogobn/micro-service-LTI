package br.edu.unifacisa.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifacisa.lti.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
