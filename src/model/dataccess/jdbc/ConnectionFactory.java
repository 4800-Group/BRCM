package model.dataccess.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.entities.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
	
    // singleton implementation
    private static ConnectionFactory instance;
	private SessionFactory factory;

	// private static final String URL = "jdbc:postgresql://localhost:5432/BRCM";
	// private static final String USER = "postgres";
	// private static final String PWD = "123";

	private ConnectionFactory () {
        factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Visit.class)
					.addAnnotatedClass(Activity.class)
					.addAnnotatedClass(HistoricalPrice.class)
					.addAnnotatedClass(Address.class)
					.addAnnotatedClass(VisitActivity.class)
					.buildSessionFactory();
	}
    public static ConnectionFactory getInstance() {
        return instance = instance == null ? new ConnectionFactory() : instance;
    }

	public Session getSession() throws SQLException {
		return factory.getCurrentSession();
		// Class.forName("org.postgresql.Driver");
		// return DriverManager.getConnection(ConnectionFactory.URL, ConnectionFactory.USER, ConnectionFactory.PWD);
	}	

	public void close() {
		factory.close();
	}


}
