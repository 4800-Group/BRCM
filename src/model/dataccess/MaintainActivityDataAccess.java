package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import model.dataccess.connection.ConnectionFactory;
import model.entities.Activity;
import model.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MaintainActivityDataAccess {
    // singleton
    private static MaintainActivityDataAccess instance;
	private MaintainActivityDataAccess () {}
    public static MaintainActivityDataAccess getInstance() {
        return instance = instance == null ? new MaintainActivityDataAccess() : instance;
    }

    public void create(Activity activity) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Creating activity...");
            session.beginTransaction();
            session.save(activity);
            session.save(activity.getHistoricalPrices().get(0));
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

	public Activity search(int activityID) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        Activity activity = null;
        try {
            System.out.println("Searching activity...");
            session.beginTransaction();
            activity = session.get(Activity.class, activityID);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
        return activity;
	}


    public void update(Activity activity) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Updating activity...");
            session.beginTransaction();
            session.update(activity);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public void delete(Activity activity) throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        try {
            System.out.println("Deleting activity...");
            session.beginTransaction();
            session.delete(activity);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
    }

    public List<Activity> list() throws SQLException {
		Session session = ConnectionFactory.getInstance().getSession();
        List<Activity> result = null;
        try {
            System.out.println("Listing activities...");
            session.beginTransaction();
            result = session.createQuery("select a from Activity a", Activity.class).getResultList();
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
        }
        return result;
    }



}

