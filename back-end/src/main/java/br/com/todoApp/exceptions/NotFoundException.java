package br.com.todoApp.exceptions;

public class NotFoundException extends RuntimeException {


	private static final long serialVersionUID = -5427482441982781076L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}
}
