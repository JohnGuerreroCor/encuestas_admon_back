package com.usco.edu.dao;

import com.usco.edu.entities.Usuario;
import com.usco.edu.entities.Role;

public interface IUsuarioDao {

	public Usuario buscarUsuario(String usuarioDb);
	
	public boolean validarUsuario(String usuarioDb);

	public Role roles(String usuarioDb);

}
