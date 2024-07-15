package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Cuestionario;

public interface ICuestionarioService {
	
	List<Cuestionario> buscarTodos();

	List<Cuestionario> buscar(int uaa);

	Cuestionario buscarCuestionarioCodigo(Long codigo);

	int crear(Cuestionario cuestionario, String userdb);

	int actualizar(Cuestionario cuestionario, String userdb);

	int borrar(int codigo, String userdb);

}
