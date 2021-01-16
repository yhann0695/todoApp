package br.com.todoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.todoApp.exceptions.NegocioExceptions;
import br.com.todoApp.exceptions.NotFoundException;
import br.com.todoApp.model.Todo;
import br.com.todoApp.repository.ITodoRepository;

@Service
public class TodoService {

	@Autowired
	private ITodoRepository repository;

	@Transactional
	public Todo inserir(Todo todo) {
		this.validarDescricao(todo);
		return repository.save(todo);
	}

	@Transactional
	public Long remover(Long id) {
		this.validarId(id);
		repository.deleteById(id);
		return id;
	}
	
	@Transactional
	public List<Todo> consultarTodos() {
		List<Todo> todos = repository.findAll();
		this.validarLista(todos);
		return todos;
	}
	
	@Transactional
	public void marcarFeito(Long id) {
		Optional<Todo> todos = repository.findById(id);
		this.validarId(id);
		todos.ifPresent(t -> {
			boolean feito = t.getFeito() == Boolean.TRUE;
			t.setFeito(!feito);
			repository.save(t);
		});
		
	}
	
	// VALIDAÇÃO 
	
	private void validarLista(List<Todo> todos) {
		if(todos.isEmpty()) {
			throw new NotFoundException("Nenhum registro encontrado");
		}
		
	}

	private void validarId(Long id) {
		boolean isExiste = repository.existsById(id);
		if(isExiste) {
			throw new NegocioExceptions("Registro não encontrado");
		}
	}



	private void validarDescricao(Todo todo) {
		boolean isExiste = repository.findByDescricao(todo.getDescricao());
		if(isExiste) {
			throw new NegocioExceptions("Já existe uma tarefa com a mesma descrição");
		}
	}

}
