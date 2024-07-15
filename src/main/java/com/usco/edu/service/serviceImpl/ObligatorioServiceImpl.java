package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IObligatorioDao;
import com.usco.edu.entities.WebParametro;
import com.usco.edu.service.IObligatotrioService;

@Service
public class ObligatorioServiceImpl implements IObligatotrioService {
	
	@Autowired
	private IObligatorioDao obligatorioDao;

	@Override
	public List<WebParametro> obtenerParametrosMatriculaPregrado() {
		
		return obligatorioDao.obtenerParametrosMatriculaPregrado();
		
	}

	@Override
	public List<WebParametro> obtenerParametrosSGD() {
		
		return obligatorioDao.obtenerParametrosSGD();
		
	}

	@Override
	public List<WebParametro> obtenerParametrosNotasPregrado() {
		
		return obligatorioDao.obtenerParametrosNotasPregrado();
		
	}

	@Override
	public List<WebParametro> obtenerParametrosEvaluacionDocente() {
		
		return obligatorioDao.obtenerParametrosEvaluacionDocente();
		
	}

	@Override
	public int actualizarParametroEncuestaMatriculaPregrado(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEncuestaMatriculaPregrado(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEstadoMatriculaPregrado(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEstadoMatriculaPregrado(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEncuestaSGD(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEncuestaSGD(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEstadoSGD(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEstadoSGD(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEncuestaNotasPregrado(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEncuestaNotasPregrado(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEstadoNotasPregrado(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEstadoNotasPregrado(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEncuestaEvaluacionDocente(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEncuestaEvaluacionDocente(webParametro, userdb);
		
	}

	@Override
	public int actualizarParametroEstadoEvaluacionDocente(WebParametro webParametro, String userdb) {
		
		return obligatorioDao.actualizarParametroEstadoEvaluacionDocente(webParametro, userdb);
		
	}

	
}
