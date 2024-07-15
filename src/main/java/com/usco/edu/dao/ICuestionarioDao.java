package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Cuestionario;

public interface ICuestionarioDao {
	
	List<Cuestionario> buscarTodos();

	List<Cuestionario> buscar(int uaa);

	Cuestionario buscarCuestionarioCodigo(Long long1);

	void actualizar(Cuestionario cuestionario, String userdb);

	void borrar(int codigo, String userdb);

	void crearInicio(Cuestionario cuestionario, String userdb);

	void crearFinalizacion(Cuestionario cuestionario, String userdb);

	void crearCompleto(Cuestionario cuestionario, String userdb);

	void crearVacio(Cuestionario cuestionario, String userdb);

}
