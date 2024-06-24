package br.com.academy.Enums;

public enum Status {
	ATIVO("Ativo"),
	INATIVO("Inativo"),
	CANCELADO("Cancelado"),
	TRANCADO("Trancado");
	
	private String status;
	
	private Status (String status) {
		this.status = status;
	}
}
