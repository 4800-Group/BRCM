package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Customer;
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

	public Customer SearchCustomer(String broncoID) throws ClassNotFoundException, SQLException {
        SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
        Customer customer = null;
        try {
            session.beginTransaction();
            customer = session.get(Customer.class, broncoID);
            System.out.println(customer);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
        return customer;
	}

}

