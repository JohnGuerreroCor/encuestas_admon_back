package com.usco.edu.service;

import com.usco.edu.entities.Usuario;
import com.usco.edu.entities.Role;

public interface IUsuarioService {

	public Usuario buscarUsuario(String usuarioDb);

	public Role roles(String usuarioDb);
}
