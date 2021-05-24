package com.ifms.entities.enums;

public enum Combustivel {
	GASOLINA(1, "Gasolina"), 
	ETANOL(2, "Etanol"), 
	FLEX(3, "Flex"), 
	GNV(4, "GNV"), 
	DIESEL(5, "Diesel");
	
	private int id;
	private String combustivel;
	
	private Combustivel(int id, String combustivel) {
		this.id = id;
		this.combustivel = combustivel;
	}

	public int getId() {
		return id;
	}

	public String getCombustivel() {
		return combustivel;
	}




}
