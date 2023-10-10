package com.AtividadeNovo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AtividadeNovo.entities.Usuario;
import com.AtividadeNovo.services.UsuarioService;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscaUsuarioControlId(@PathVariable Long id){
		Usuario usuario = usuarioService.buscaUsuarioId(id);
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
			}
		else {
			return ResponseEntity.notFound().build();		
		}

}
@GetMapping("/")
public ResponseEntity<List<Usuario>>buscaTodosUsuariosControl(){
	List <Usuario> Usuarios = usuarioService.buscaTodosUsuarios();
	return ResponseEntity.ok(Usuarios);
}
}