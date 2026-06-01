package com.francocouto.projetoMongo.recursos.execoes;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant date;
	private Integer cod;
	private String erro;
	private String pacote;
	private String msg;
	
	public StandardError() {
		
	}

	public StandardError(Instant date, Integer cod, String erro, String pacote, String msg) {
		this.date = date;
		this.cod = cod;
		this.erro = erro;
		this.pacote = pacote;
		this.msg = msg;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getPacote() {
		return pacote;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
