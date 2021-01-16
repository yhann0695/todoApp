package br.com.todoApp.exceptions;

public class NegocioExceptions extends RuntimeException {

	
	private static final long serialVersionUID = -8521675025551305970L;

	public NegocioExceptions(String mensagem) {
		super(mensagem);
	}
}
