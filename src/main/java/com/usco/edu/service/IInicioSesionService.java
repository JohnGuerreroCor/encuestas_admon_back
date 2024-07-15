package com.usco.edu.service;

public interface IInicioSesionService {
	
	public String obtenerTokenInicioSesion(String atributos , String usuarioDb);
	
	public String urlTokenPeticion( String usuarioDb);

}
