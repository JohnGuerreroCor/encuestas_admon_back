package com.usco.edu.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IUsuarioDao;
import com.usco.edu.entities.Role;
import com.usco.edu.entities.Usuario;
import com.usco.edu.rowMapper.UsuarioRowMapper;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@Autowired
	@Qualifier("JDBCTemplateEncuestasLogin")
	public JdbcTemplate jdbcTemplate;

	@Override
	public Usuario buscarUsuario(String username) {

		String sql = "select top 1 *, GETDATE() as horaInicioSesion from usuario_encuestas_admin_login ueal "
				+ "inner join uaa u on u.uaa_codigo = ueal.uaa_codigo "
				+ "inner join sede s on s.sed_codigo = u.sed_codigo "
				+ "inner join persona p on p.per_codigo = ueal.per_codigo where ueal.us = ? "
				+ "order by ueal.gru_codigo desc ";
		return jdbcTemplate.queryForObject(sql, new Object[] { username }, new UsuarioRowMapper());

	}

	@Override
	public Role roles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarUsuario(String username) {
		int result = 0;
		String sql = "select  COUNT(us.us) from usuario_encuestas_admin_login us "
				+ "inner join uaa u on u.uaa_codigo = us.uaa_codigo "
				+ "inner join sede s on s.sed_codigo = u.sed_codigo "
				+ "inner join persona p on p.per_codigo = us.per_codigo " + "where  us = ? ";
		result = jdbcTemplate.queryForObject(sql, new Object[] { username }, Integer.class);
		return result > 0 ? true : false;
	}

} 
