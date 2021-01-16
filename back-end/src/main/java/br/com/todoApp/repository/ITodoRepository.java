package br.com.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.todoApp.model.Todo;

@Repository
public interface ITodoRepository extends JpaRepository<Todo, Long>{

	boolean findByDescricao(String descricao);

}
