package br.com.academy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Email é obrigatório")
	@Email(message = "Email deve ser válido")
	private String email;
	
	@NotBlank(message = "Usuário deve ser preenchido")
	@Size(min = 3, max = 20, message = "Digite entre 3 a 20 caracteres.")
	private String user;
	
	@NotBlank(message = "Senha é obrigatório")
	@Size(min = 6, message = "Senha deve ter no minimo 6 caracteres")
	private String senha;
	
	/*Getters and Setters*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
