package br.com.academy.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.Exceptions.CryptoExistException;
import br.com.academy.Exceptions.EmailExistsException;
import br.com.academy.Exceptions.UserExistsException;
import br.com.academy.dao.UsuarioDao;
import br.com.academy.model.Usuario;
import br.com.academy.util.Util;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioDao repositorioUsuario;
	
	public void salvarUsuario(Usuario user) throws Exception {

		try {
			if(repositorioUsuario.findByEmail(user.getEmail()) == null) {
				throw new EmailExistsException("Digite em Email válido");
			}
			if(repositorioUsuario.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: " + user.getEmail());
			}
			if(repositorioUsuario.findByUsuario(user.getUser()) == null) {
				throw new UserExistsException("Preencha o campo de usuário");
			}
			if(repositorioUsuario.findByUsuario(user.getUser()) != null) {
				throw new UserExistsException("Já existe um usuario cadastrado para: " + user.getUser());
			}
			
			user.setSenha(Util.md5(user.getSenha()));
			repositorioUsuario.save(user);
			
		} catch (NoSuchAlgorithmException e) {
			
			throw new CryptoExistException("Erro na criptografia da senha");
			
		}

	}
	
	public Usuario loginUser(String user, String senha) throws ServiceExc {
		
		Usuario userLogin = repositorioUsuario.buscarLogin(user, senha);
		return userLogin;
		
	}
	
}
