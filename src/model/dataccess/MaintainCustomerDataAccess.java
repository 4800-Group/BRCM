package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dataccess.connection.ConnectionFactory;
import model.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MaintainCustomerDataAccess {
    // singleton
    private static MaintainCustomerDataAccess instance;
	private MaintainCustomerDataAccess () {}
    public static MaintainCustomerDataAccess getInstance() {
        return instance = instance == null ? new MaintainCustomerDataAccess() : instance;
    }

    public void create(Customer customer) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Creating customer...");
            session.beginTransaction();
            session.save(customer);
            Address a = customer.getAddress();
            System.out.println(a);
            session.save(a);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

	public Customer search(String broncoID) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        Customer customer = null;
        try {
            System.out.println("Searching customer...");
            session.beginTransaction();
            customer = session.get(Customer.class, broncoID);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
        return customer;
	}


    public void update(Customer customer) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Updating customer...");
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public void delete(Customer customer) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Deleting customer");
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }
}

