package cl.mobilLoyalty.MisBencinerasServer.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public abstract class ConnectionDAO {

	Logger logger = Logger.getLogger(ConnectionDAO.class);

	public Connection getConnectionMySql() {
		try {
			return getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			logger.error("Obteniendo conexion JDBC..." + e);
			return getConnectionMySqlJDBC();
		}
	}

	/**
	 * 
	 * @return
	 * @throws DataException
	 */
	public Connection getConnection() {
		Context initContext;
		DataSource ds = null;
		try {

			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/misBencinerasServer");

			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (NamingException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @throws DataException
	 */
	public Connection getConnectionMySqlJDBC() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		/*
		 * 190.8.125.232
		 */
		String url = "jdbc:mysql://190.8.125.232:3306/bencineras";
		try {
			conn = DriverManager
					.getConnection(url, "bencinaserver", "centos");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e);
		}
		return conn;
	}

	/**
	 * 
	 * @param stmt
	 */
	protected void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

	/**
	 * 
	 * @param stmt
	 * @param rs
	 */
	protected void close(Statement stmt, ResultSet rs) {

		close(rs);
		close(stmt);

	}

	/**
	 * 
	 * @param stmt
	 * @param rs
	 * @param conn
	 */
	protected void close(Statement stmt, ResultSet rs, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);

	}
	
	protected void close( ResultSet rs,Statement stmt, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);

	}

	protected void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		close(rs);
		close(ps);
		close(conn);

	}

	/**
	 * 
	 * @param conn
	 */
	protected void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

	/**
	 * 
	 * @param ps
	 * @param conn
	 */
	protected void close(PreparedStatement ps, Connection conn) {
		close(ps);
		close(conn);
	}

	/**
	 * 
	 * @param rs
	 */
	protected void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

}