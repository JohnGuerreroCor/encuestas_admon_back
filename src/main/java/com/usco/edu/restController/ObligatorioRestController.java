package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.WebParametro;
import com.usco.edu.service.IObligatotrioService;

@RestController
@RequestMapping(path = "api/obligatorio")
public class ObligatorioRestController {
	
	@Autowired
	private IObligatotrioService obligatotrioService;
	
	@GetMapping(path = "parametros-matricula-pregrado")
	public List<WebParametro> obtenerParametrosMatriculaPregrado() {

		return obligatotrioService.obtenerParametrosMatriculaPregrado();

	}
	
	@GetMapping(path = "parametros-sgd")
	public List<WebParametro> obtenerParametrosSGD() {

		return obligatotrioService.obtenerParametrosSGD();

	}
	
	@GetMapping(path = "parametros-notas-pregrado")
	public List<WebParametro> obtenerParametrosNotasPregrado() {

		return obligatotrioService.obtenerParametrosNotasPregrado();

	}
	
	@GetMapping(path = "parametros-evalauacion-docente")
	public List<WebParametro> obtenerParametrosEvaluacionDocente() {

		return obligatotrioService.obtenerParametrosEvaluacionDocente();

	}
	
	@PutMapping(path = "actualizar-parametro-encuesta-matricula-pregrado/{user}")
	public int actualizarParametroEncuestaMatriculaPregrado(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEncuestaMatriculaPregrado(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-estado-matricula-pregrado/{user}")
	public int actualizarParametroEstadoMatriculaPregrado(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEstadoMatriculaPregrado(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-encuesta-sgd/{user}")
	public int actualizarParametroEncuestaSGD(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEncuestaSGD(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-estado-sgd/{user}")
	public int actualizarParametroEstadoSGD(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEstadoSGD(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-encuesta-notas-pregrado/{user}")
	public int actualizarParametroEncuestaNotasPregrado(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEncuestaNotasPregrado(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-estado-notas-pregrado/{user}")
	public int actualizarParametroEstadoNotasPregrado(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEstadoNotasPregrado(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-encuesta-evalauacion-docente/{user}")
	public int actualizarParametroEncuestaEvaluacionDocente(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEncuestaEvaluacionDocente(webParametro, user);
		
	}
	
	@PutMapping(path = "actualizar-parametro-estado-evalauacion-docente/{user}")
	public int actualizarParametroEstadoEvaluacionDocente(@RequestBody WebParametro webParametro, @PathVariable String user) {
		
		return obligatotrioService.actualizarParametroEstadoEvaluacionDocente(webParametro, user);
		
	}

}
