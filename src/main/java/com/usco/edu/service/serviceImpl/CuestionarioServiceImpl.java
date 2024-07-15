package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usco.edu.dao.ICuestionarioDao;
import com.usco.edu.entities.Cuestionario;
import com.usco.edu.service.ICuestionarioService;

@Service
public class CuestionarioServiceImpl implements ICuestionarioService {

	@Autowired
	private ICuestionarioDao dao;

	@Transactional(readOnly = true)
	
	@Override
	public List<Cuestionario> buscarTodos() {
		
		return dao.buscarTodos();
		
	}
	
	@Override
	public List<Cuestionario> buscar(int uaa) {

		return dao.buscar(uaa);
	}

	@Override
	public Cuestionario buscarCuestionarioCodigo(Long codigo) {

		try {
			return dao.buscarCuestionarioCodigo(codigo);

		} catch (Exception e) {

			return null;

		}

	}

	@Override
	public int crear(Cuestionario cuestionario, String userdb) {

		try {

			if (cuestionario.getInicio() == null && cuestionario.getFin() == null) {

				dao.crearVacio(cuestionario, userdb);
				return 1;
			} else {
				if (cuestionario.getFin() == null) {
					dao.crearInicio(cuestionario, userdb);
					return 1;
				} else {
					if (cuestionario.getInicio() == null) {
						dao.crearFinalizacion(cuestionario, userdb);
						return 1;
					} else {
						dao.crearCompleto(cuestionario, userdb);
						return 1;
					}
				}
			}

		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public int actualizar(Cuestionario cuestionario, String userdb) {

		try {
			dao.actualizar(cuestionario, userdb);
			return 1;
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public int borrar(int codigo, String userdb) {

		try {
			dao.borrar(codigo, userdb);
			return 1;

		} catch (Exception e) {
			return 0;
		}

	}

}
