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

public class RegisterActivityDataAccess {
    // singleton
    private static RegisterActivityDataAccess instance;
	private RegisterActivityDataAccess () {}
    public static RegisterActivityDataAccess getInstance() {
        return instance = instance == null ? new RegisterActivityDataAccess() : instance;
    }

    public void register(VisitActivity va) throws SQLException{
        Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Registering activity...");
            session.beginTransaction();
            session.save(va);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }
}

