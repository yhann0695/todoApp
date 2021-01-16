package br.com.todoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todoApp.model.Todo;
import br.com.todoApp.service.TodoService;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Todo> inserir(@RequestBody Todo todo) {
		return ResponseEntity.ok(todoService.inserir(todo));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Long> remover(@PathVariable Long id) {
		return ResponseEntity.ok(todoService.remover(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Todo>> consultarTodos() {
		return ResponseEntity.ok(todoService.consultarTodos());
	}
	
	@PatchMapping(value = "/{id}/feito")
	public ResponseEntity<Void> marcarFeito(@PathVariable Long id) {
		todoService.marcarFeito(id);
		return ResponseEntity.ok().build();
				
	}

}
