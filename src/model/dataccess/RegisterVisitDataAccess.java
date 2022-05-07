package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dataccess.connection.ConnectionFactory;
import model.entities.Activity;
import model.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.entities.*;

public class RegisterVisitDataAccess {
    // singleton
    private static RegisterVisitDataAccess instance;
	private RegisterVisitDataAccess () {}
    public static RegisterVisitDataAccess getInstance() {
        return instance = instance == null ? new RegisterVisitDataAccess() : instance;
    }

    public void register(Visit visit) throws SQLException{
        Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Registering visit...");
            session.beginTransaction();
            session.save(visit);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }
}
