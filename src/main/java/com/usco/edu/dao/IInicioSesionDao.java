package com.usco.edu.dao;

public interface IInicioSesionDao {
	
	public String obtenerTokenInicioSesion(String atributos, String usuarioDb);
	
	public String urlTokenPeticion(String usuarioDb);
	
	public String obtenerSegundaClaveReal(String segundaClave);

}
