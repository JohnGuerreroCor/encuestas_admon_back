package com.usco.edu.restController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usco.edu.entities.Pregunta;
import com.usco.edu.exception.ModelNotFoundException;
import com.usco.edu.service.IPreguntaService;

@RestController
@RequestMapping(path = "api/pregunta")
public class PreguntaRestController {

	@Autowired
	private IPreguntaService service;

	@GetMapping(path = "find")
	public List<Pregunta> find() {

		return service.find();

	}

	@GetMapping(path = "find-codigo/{codigo}")
	public Pregunta findByCodigo(@PathVariable Long codigo) throws Exception {

		Pregunta pregunta = service.findByCodigo(codigo);
		if (pregunta == null) {
			throw new ModelNotFoundException("PREGUNTA NO ENCONTRADA");
		}

		return pregunta;

	}

	@PostMapping(path = "create/{user}")
	public int create(@RequestBody Pregunta pregunta, @PathVariable String user) {

		return service.create(pregunta, user);

	}

	@PutMapping(path = "update/{user}")
	public int update(@RequestBody Pregunta pregunta, @PathVariable String user) {

		return service.update(pregunta, user);
	}

	@GetMapping("remove/{codigo}/{user}")
	public int remove(@PathVariable int codigo, @PathVariable String user) {

		return service.delete(codigo, user);
	}

	@GetMapping("find-cues/{cues}")
	public List<Pregunta> findCuest(@PathVariable int cues) {

		return service.findCues(cues);
	}

	@GetMapping("find-dependencia/{codigo}")
	public List<Pregunta> findByDependencia(@PathVariable int codigo) {
		return service.findByDependencia(codigo);
	}

	@GetMapping("find-cuest/{cues}")
	public List<Pregunta> findCuest2(@PathVariable int cues) {

		return service.findByCue2(cues);
	}

	@GetMapping("find-admin/{cues}")
	public List<Pregunta> findCuesAdmin(@PathVariable int cues) {

		return service.findByCueAdmin(cues);
	}

	@GetMapping("pre-relacion/{cues}")
	public List<Pregunta> findPreguntasForRelacion(@PathVariable int cues) {

		return service.findByCuestAndTipoRespuestaRadiobOrSelect(cues);
	}

	@PostMapping("subir-imagen-pregunta/{user}/{perCodigo}/{uaa}")
	public void subirImagenPregunta(@PathVariable String user, @PathVariable Long perCodigo, @PathVariable int uaa,
			@RequestPart MultipartFile archivo, HttpServletRequest request, @RequestParam String json) {

		ObjectMapper objectMapper = new ObjectMapper();
		Pregunta pregunta;
		try {
			pregunta = objectMapper.readValue(json, Pregunta.class);
			pregunta.setDescripcion(service.subirImagenPregunta(archivo, perCodigo, uaa, user, request));
			service.create(pregunta, user);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@GetMapping("mirar-imagen/{codigo}/{user}")
	public ResponseEntity<InputStreamResource> mirarImagenPregunta(@PathVariable Long codigo, @PathVariable String user,
			HttpServletResponse response) throws Exception {
		ByteArrayInputStream stream = service.mirarImagenPregunta(codigo, user, response);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=\" ImagenPregunta.png\"");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));

	}

}
