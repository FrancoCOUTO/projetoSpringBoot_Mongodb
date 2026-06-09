package com.francocouto.projetoMongo.dto;

import java.io.Serializable;
import java.time.Instant;


public class ComentarioDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	private String text;
	private Instant data;
	
	private AutorDTO autor;
	
	public ComentarioDto() {
		
	}

	public ComentarioDto(String text, Instant data, AutorDTO autor) {
		this.text = text;
		this.data = data;
		this.autor = autor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}

	
	
	

}
