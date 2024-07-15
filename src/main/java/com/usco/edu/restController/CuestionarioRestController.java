package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Cuestionario;
import com.usco.edu.service.ICuestionarioService;

@RestController
@RequestMapping(path = "api/cuestionario")
public class CuestionarioRestController {

	@Autowired
	private ICuestionarioService service;
	
	@GetMapping(path = "buscar-todo")
	public List<Cuestionario> buscarTodos() {

		return service.buscarTodos();

	}

	@GetMapping(path = "buscar/{uaa}")
	public List<Cuestionario> buscar(@PathVariable int uaa) {

		return service.buscar(uaa);

	}

	@GetMapping(path = "buscar-cuestionario-codigo/{codigo}")
	public Cuestionario buscarCuestionarioCodigo(@PathVariable Long codigo) {

		return service.buscarCuestionarioCodigo(codigo);

	}

	@PostMapping(path = "crear/{user}")
	public int crear(@RequestBody Cuestionario cuestionario, @PathVariable String user) {

		return service.crear(cuestionario, user);

	}

	@PutMapping(path = "actualizar/{user}")
	public int actualizar(@RequestBody Cuestionario cuestionario, @PathVariable String user) {

		return service.actualizar(cuestionario, user);
	}

	@GetMapping(path = "borrar/{codigo}/{user}")
	public int borrar(@PathVariable int codigo, @PathVariable String user) {

		return service.borrar(codigo, user);
	}

}
