package br.gov.caixa.vistocaixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.caixa.vistocaixa.model.Tarefa;
import br.gov.caixa.vistocaixa.repositories.TarefaRepository;
import br.gov.caixa.vistocaixa.repositories.UserRepository;
import br.gov.caixa.vistocaixa.security.model.AuthenticatedUser;
import br.gov.caixa.vistocaixa.security.transfer.JwtUserDto;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TarefaController {

	@Autowired
	TarefaRepository repository;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/tarefas")
	public ResponseEntity<?> tarefas() {
		AuthenticatedUser auth = (AuthenticatedUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		JwtUserDto u = userRepository.findOne(auth.getId());
	
		return ResponseEntity.ok(u);
	}
	
	@PostMapping("/tarefa")
	public ResponseEntity<?> postTarefa(@RequestBody Tarefa tarefa) {
		repository.save(tarefa);

		return new ResponseEntity<Tarefa>(HttpStatus.OK);
	}
	
	@DeleteMapping("/tarefa")
	public ResponseEntity<?> deleteTarefa(@RequestBody Long id) {
		repository.delete(id);
		
		return new ResponseEntity<Tarefa>(HttpStatus.OK);
	}
	
	@PutMapping("/tarefa")
	public ResponseEntity<?> editTarefa(@RequestBody Tarefa tarefa) {
		repository.save(tarefa);
		
		return new ResponseEntity<Tarefa>(HttpStatus.OK);
	}
}
