package com.usco.edu.service.serviceImpl;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.usco.edu.dao.IDocumentoDao;
import com.usco.edu.dao.IPreguntaDao;
import com.usco.edu.dto.RespuestaSubirArchivo;
import com.usco.edu.dto.RespuestaVerArchivo;
import com.usco.edu.entities.Documento;
import com.usco.edu.entities.Pregunta;
import com.usco.edu.feing.EnviarArchivoClient;
import com.usco.edu.service.IPreguntaService;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	@Autowired
	private IPreguntaDao dao;

	@Autowired
	private IDocumentoDao documentoDao;

	@Autowired
	private EnviarArchivoClient enviarArchivo;

	@Transactional(readOnly = true)
	@Override
	public List<Pregunta> find() {

		return dao.find();
	}

	@Override
	public Pregunta findByCodigo(Long codigo) {

		Pregunta pregunta = dao.findByCodigo(codigo);
		return pregunta;

	}

	@Override
	public int create(Pregunta pregunta, String userdb) {

		try {

			dao.create(pregunta, userdb);
			return 1;

		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}

	}

	@Override
	public int update(Pregunta pregunta, String userdb) {

		dao.update(pregunta, userdb);
		return 1;

	}

	@Override
	public int delete(int codigo, String userdb) {

		try {
			dao.delete(codigo, userdb);
			return 1;

		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public List<Pregunta> findCues(int cues) {

		return dao.findByCue(cues);
	}

	@Override
	public List<Pregunta> findByDependencia(int codigo) {

		return dao.findByDependencia(codigo);
	}

	@Override
	public List<Pregunta> findByCue2(int cues) {

		return dao.findByCue2(cues);
	}

	@Override
	public List<Pregunta> findByCueAdmin(int cues) {

		return dao.findByCueAdmin(cues);
	}

	@Override
	public List<Pregunta> findByCuestAndTipoRespuestaRadiobOrSelect(int cues) {

		return dao.findByCueandSelectOrRadioB(cues);
	}

	@Override
	public String subirImagenPregunta(MultipartFile file, Long perCodigo, int uaa, String userdb,
			HttpServletRequest request) {

		String err = "";
		System.out.println("MENSAJE: "
				+ isValido(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf("."))));
		if (!file.isEmpty()) {

			if (isValido(file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf(".")))) {

				Documento documento = new Documento();
				documento.setDocNombreArchivo(file.getOriginalFilename());
				documento.setPerCodigo("" + perCodigo);
				documento.setDocCliente("Encuesta Admon");
				documento.setDocContenido("Pregunta imágen");
				documento.setDocExtension("imagen");
				documento.setDocIp(request.getRemoteAddr());
				documento.setDocSesion(request.getSession().getId());
				documento.setModCodigo(77);// CAMBIAR PARA PRODUCCION
				documento.setTdocCodigo(110);// CAMBIAR PARA PRODUCCION
				documento.setUaaCodigo(uaa);

				String Key = documentoDao.getKeyDocumento(
						documento.getModCodigo().toString() + documento.getUaaCodigo() + documento.getPerCodigo(),
						userdb);

				System.out.println("datos: " + documento.getModCodigo().toString() + documento.getUaaCodigo()
						+ documento.getPerCodigo());
				ObjectMapper objectMapper = new ObjectMapper();
				RespuestaSubirArchivo respuesta = new RespuestaSubirArchivo();
				try {
					respuesta = enviarArchivo.subirArchivo(file, Key, objectMapper.writeValueAsString(documento));
					System.out.println(respuesta.getMensaje());
					System.out.println(respuesta.getIdDocumento());
					err = respuesta.getMensaje();
					if (!respuesta.isEstado()) {

						System.out.println("Ocurrio un error: " + respuesta.getMensaje());
					}

				} catch (Exception e) {

					System.out.println("Ocurrio un error: " + e);
					return null;
				}
				System.out.println("Creado" + respuesta.getMensaje());
				return respuesta.getIdDocumento() + "";

			} else {

				System.out.println("Ocurrio un error" + err);
				return null;
			}

		} else {
			System.out.println("Ocurrio un error" + err);
			return null;
		}

	}

	@Override
	public ByteArrayInputStream mirarImagenPregunta(long archivoCodigo, String userdb, HttpServletResponse response) {

		String Key = documentoDao.getKeyDocumento(archivoCodigo + "", userdb);
		RespuestaVerArchivo respuesta = new RespuestaVerArchivo();

		try {
			respuesta = enviarArchivo.mostrarArchivo(archivoCodigo, Key);

			byte[] archivoBytes = Base64.getDecoder().decode(respuesta.getBase64());
			return new ByteArrayInputStream(archivoBytes);

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public boolean isValido(String nombre) {
		String expresion = "^([[a-zA-Z][0-9]_]{2,150})$";
		try {
			Pattern p = Pattern.compile(expresion);
			Matcher matcher = p.matcher(nombre);
			return matcher.matches();
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

	}

}
