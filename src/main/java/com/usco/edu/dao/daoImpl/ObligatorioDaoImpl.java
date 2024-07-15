package com.usco.edu.dao.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IObligatorioDao;
import com.usco.edu.entities.WebParametro;
import com.usco.edu.resultSetExtractor.WebParametroSetExtractor;
import com.usco.edu.util.AuditoriaJdbcTemplate;

@Repository
public class ObligatorioDaoImpl implements IObligatorioDao{
	
	@Autowired
	@Qualifier("JDBCTemplateEncuestasConsulta")
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private AuditoriaJdbcTemplate jdbcComponent;

	@Override
	public List<WebParametro> obtenerParametrosMatriculaPregrado() {
		
		String sql = "select * from web_parametro wp where wp.wep_codigo in (419,433);";
		return namedJdbcTemplate.query(sql, new WebParametroSetExtractor());
		
	}

	@Override
	public List<WebParametro> obtenerParametrosSGD() {
		
		String sql = "select * from web_parametro wp where wp.wep_codigo in (435,436);";
		return namedJdbcTemplate.query(sql, new WebParametroSetExtractor());
		
	}

	@Override
	public List<WebParametro> obtenerParametrosNotasPregrado() {
		
		String sql = "select * from web_parametro wp where wp.wep_codigo in (457,458);";
		return namedJdbcTemplate.query(sql, new WebParametroSetExtractor());
		
	}

	@Override
	public List<WebParametro> obtenerParametrosEvaluacionDocente() {
		
		String sql = "select * from web_parametro wp where wp.wep_codigo in (520,521);";
		return namedJdbcTemplate.query(sql, new WebParametroSetExtractor());
		
	}

	@Override
	public int actualizarParametroEncuestaMatriculaPregrado(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:encuesta WHERE wep_codigo=433;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("encuesta", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEstadoMatriculaPregrado(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:estado WHERE wep_codigo=419;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("estado", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEncuestaSGD(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:encuesta WHERE wep_codigo=436;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("encuesta", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEstadoSGD(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:estado WHERE wep_codigo=435;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("estado", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEncuestaNotasPregrado(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:encuesta WHERE wep_codigo=458;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("encuesta", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEstadoNotasPregrado(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:estado WHERE wep_codigo=457;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("estado", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEncuestaEvaluacionDocente(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:encuesta WHERE wep_codigo=521;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("encuesta", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int actualizarParametroEstadoEvaluacionDocente(WebParametro webParametro, String userdb) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE dbo.web_parametro SET wep_valor=:estado WHERE wep_codigo=520;";

		try {
			MapSqlParameterSource parameter = new MapSqlParameterSource();
			parameter.addValue("estado", webParametro.getWebValor());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void cerrarConexion(Connection con) {
		if (con == null)
			return;

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
