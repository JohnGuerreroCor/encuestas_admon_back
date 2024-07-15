package com.usco.edu.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IInicioSesionDao;
import com.usco.edu.service.IInicioSesionService;

@Service
public class InicioSesionServiceImpl implements IInicioSesionService {
	
	@Autowired
	private IInicioSesionDao inicioSesionDao;

	@Override
	public String obtenerTokenInicioSesion(String atributos, String usuarioDb) {
		return inicioSesionDao.obtenerTokenInicioSesion(atributos, usuarioDb);
	}

	@Override
	public String urlTokenPeticion(String usuarioDb) {
		return inicioSesionDao.urlTokenPeticion(usuarioDb);
	}
}
