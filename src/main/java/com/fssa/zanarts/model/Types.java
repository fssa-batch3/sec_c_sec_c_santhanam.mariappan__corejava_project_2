package com.fssa.zanarts.model;

public enum Types {
	MANDANA, WATERCOLOUR, SKETCH, REALISM, HYPERREALISM;
	
	public String getArtTypes() {
		return this.name();
	}
}
