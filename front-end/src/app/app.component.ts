import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Todo } from './model/Todo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public mode: string = 'list';
  public todos: Todo[] = [];
  public title: string = 'Minhas tarefas';
  public formulario: FormGroup;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.createForm();
    this.carregar();
  }

  public createForm(): void {
    this.formulario = this.formBuilder.group({
      descricao: ['', Validators.compose([
        Validators.minLength(3),
        Validators.maxLength(60),
        Validators.required
      ])]
    });
  }


  public add(): void  {
    const descricao = this.formulario.controls['descricao'].value;
    const id = this.todos.length + 1;
    this.todos.push(new Todo(id, descricao, false));
    this.salvar();
    this.limpar();
  }

  public limpar() {
    this.formulario.reset();
  }

  public remove(todo: Todo): void {
    const index = this.todos.indexOf(todo);
    if (index !== -1) {
      this.todos.splice(index, 1);
    }
  }

  public markAsDone(todo: Todo): void {
    todo.done = true;
    this.salvar();
  }

  public markAsUndone(todo: Todo): void {
    todo.done = false;
    this.salvar();
  }

  public salvar(): void {
    const data = JSON.stringify(this.todos);
    localStorage.setItem('todos', data);
    this.mode = 'list';
  }

  public carregar() {
    const data = localStorage.getItem('todos');
    if(data) {
      this.todos = JSON.parse(data);
    } else {
       this.todos = [];
    }
  }

  public changeMode(mode: string) {
    this.mode = mode;
  }

}
