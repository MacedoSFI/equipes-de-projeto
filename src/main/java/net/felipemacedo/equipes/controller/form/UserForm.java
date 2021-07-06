package net.felipemacedo.equipes.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import net.felipemacedo.equipes.model.User;

public class UserForm {
	
	@NotEmpty @Length(min=5, max=24)
	private String username;

	private String password;
	private String email;
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public User converter() {// se aqui tivesse um atributo de classe, ex. converter(HabilidadeRepo habRepo){ ...
		return new User(username, email, password); //^^^ Habilidade hab = habRepo.findById(idHab); ...
	}
}