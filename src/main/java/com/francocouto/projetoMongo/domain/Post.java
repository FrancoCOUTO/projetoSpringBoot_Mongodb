package com.francocouto.projetoMongo.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.francocouto.projetoMongo.dto.AutorDTO;
import com.francocouto.projetoMongo.dto.ComentarioDto;

@Document
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Instant date;
	private String titulo;
	private String corpo;
	
	private AutorDTO autor;
	private List<ComentarioDto> comentario = new ArrayList<>(); 
	
	public Post() {
		
	}
	
	public Post(String id, Instant date, String titulo, String corpo, AutorDTO autor) {
		this.id = id;
		this.date = date;
		this.titulo = titulo;
		this.corpo = corpo;
		this.autor = autor;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	public List<ComentarioDto> getComentario() {
		return comentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
