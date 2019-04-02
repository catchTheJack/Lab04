package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?useTimezone=true&serverTimezone=UTC&user=root&password=TDP2019!";

	static private Connection connection = null;

	public static Connection getConnection() {

		try {
			if (connection == null) {
				connection = DriverManager.getConnection(jdbcURL);
			}
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcURL, e);
		}
	}

}
