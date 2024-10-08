package com.usco.edu.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.usco.edu.entities.Pregunta;

public interface IPreguntaService {

	List<Pregunta> find();

	List<Pregunta> findCues(int cues);

	Pregunta findByCodigo(Long codigo);

	int create(Pregunta pregunta, String userdb);

	int update(Pregunta pregunta, String userdb);

	int delete(int codigo, String userdb);

	List<Pregunta> findByDependencia(int cues);

	List<Pregunta> findByCue2(int cues);

	List<Pregunta> findByCueAdmin(int cues);

	List<Pregunta> findByCuestAndTipoRespuestaRadiobOrSelect(int cues);

	String subirImagenPregunta(MultipartFile file, Long perCodigo, int uaa, String userdb, HttpServletRequest request);

	ByteArrayInputStream mirarImagenPregunta(long archivoCodigo, String userdb, HttpServletResponse response);

}
