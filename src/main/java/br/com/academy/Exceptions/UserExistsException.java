package br.com.academy.Exceptions;

public class UserExistsException extends Exception {
	
	public UserExistsException (String message) {
		super(message);
	}
	private static final long serialVersionUID = 1L;
}
