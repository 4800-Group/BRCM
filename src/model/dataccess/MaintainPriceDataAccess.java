package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dataccess.connection.ConnectionFactory;
import model.entities.Customer;
import model.entities.HistoricalPrice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MaintainPriceDataAccess {
    // singleton
    private static MaintainPriceDataAccess instance;
	private MaintainPriceDataAccess () {}
    public static MaintainPriceDataAccess getInstance() {
        return instance = instance == null ? new MaintainPriceDataAccess() : instance;
    }

    public void create(HistoricalPrice price) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Creating customer...");
            session.beginTransaction();
            session.save(price);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

	public HistoricalPrice search(int priceID) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        HistoricalPrice price = null;
        try {
            System.out.println("Searching price...");
            session.beginTransaction();
            price = session.get(HistoricalPrice.class, priceID);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
        return price;
	}


    public void update(HistoricalPrice price) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Updating price...");
            session.beginTransaction();
            session.update(price);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public void delete(HistoricalPrice price) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Deleting price...");
            session.beginTransaction();
            session.delete(price);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }



}

