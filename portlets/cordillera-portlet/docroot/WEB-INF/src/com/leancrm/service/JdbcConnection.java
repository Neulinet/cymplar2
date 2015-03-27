package com.leancrm.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase que crea  la conexciona la base de datos.
 * **/
public class JdbcConnection {

	private static String driver = "org.postgresql.Driver";
	private String host = "localhost:5432";
	private String passwd = "root";
	private String dbname = "leancrm_lportal4";
	private String dbuser = "postgres";
	private Connection connection;

	/**
	 * Retorna la conexion
	 * **/
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Lee la concexion a partir del archivo de configuracion database.properties
	 * Genera Excepcion y logea por Consola el error en caso de no poder conectarse
	 * **/
	public JdbcConnection() {
		super();
//		ConfigManager config = ConfigManager.getInstance();
//	    host = config.getDatabaseHost();
//	    passwd = config.getDatabasePassword();
//	    dbname = config.getDatabaseName();
//	    dbuser = config.getDatabaseUser();
	    
	    
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection("jdbc:postgresql://"+this.host+"/"+this.dbname, this.dbuser, this.passwd);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Valida el acceso a la base de datos
	 * @param url
	 * @param user
	 * @param password
	 * @return
	 */
	public static boolean ValidateConnection(String url, String user, String password) {
		try {
			Class.forName(driver);
			DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
