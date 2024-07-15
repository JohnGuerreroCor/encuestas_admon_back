package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.WebParametro;

public interface IObligatorioDao {
	
	List<WebParametro> obtenerParametrosMatriculaPregrado();
	
	List<WebParametro> obtenerParametrosSGD();
	
	List<WebParametro> obtenerParametrosNotasPregrado();
	
	List<WebParametro> obtenerParametrosEvaluacionDocente();
	
	int actualizarParametroEncuestaMatriculaPregrado(WebParametro webParametro, String userdb);
	
	int actualizarParametroEstadoMatriculaPregrado(WebParametro webParametro, String userdb);
	
	int actualizarParametroEncuestaSGD(WebParametro webParametro, String userdb);
	
	int actualizarParametroEstadoSGD(WebParametro webParametro, String userdb);
	
	int actualizarParametroEncuestaNotasPregrado(WebParametro webParametro, String userdb);
	
	int actualizarParametroEstadoNotasPregrado(WebParametro webParametro, String userdb);
	
	int actualizarParametroEncuestaEvaluacionDocente(WebParametro webParametro, String userdb);
	
	int actualizarParametroEstadoEvaluacionDocente(WebParametro webParametro, String userdb);

}