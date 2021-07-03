package net.felipemacedo.equipes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import net.felipemacedo.equipes.model.Habilidade;
import net.felipemacedo.equipes.model.Projeto;

public class ProjetoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private List<Habilidade> habilidades;
	
	public ProjetoDto(Projeto projeto) {
		this.id = projeto.getId();
		this.titulo = projeto.getTitulo();
		this.descricao = projeto.getDescricao();
		this.habilidades = projeto.getHabilidades();
		
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public static List<ProjetoDto> converter(List<Projeto> projetos) {
		return projetos
				.stream()//devolve uma lista de ProjetosDto usa stream p n fazer um loop manual
				.map(ProjetoDto::new)//chama o construtor que recebe o próprio projeto como parâmetro
				.collect(Collectors.toList()); //transforma em uma lista
	}
	
}
