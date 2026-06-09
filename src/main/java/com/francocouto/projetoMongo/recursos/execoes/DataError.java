package com.francocouto.projetoMongo.recursos.execoes;

public class DataError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DataError(String msg) {
		super(msg);
	}

}
