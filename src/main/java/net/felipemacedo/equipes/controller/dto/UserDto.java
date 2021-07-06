package net.felipemacedo.equipes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import net.felipemacedo.equipes.model.Projeto;
import net.felipemacedo.equipes.model.User;

public class UserDto {
	
	private Long id;
	private String username;
	private String password;
	private String email;
	
	public UserDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public static List<UserDto> converter(List<User> users) {
		return users
				.stream()//devolve uma lista de ProjetosDto usa stream p n fazer um loop manual
				.map(UserDto::new)//chama o construtor que recebe o próprio projeto como parâmetro
				.collect(Collectors.toList()); //transforma em uma lista
	}

}
