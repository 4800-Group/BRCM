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
import model.dataccess.jdbc.ConnectionFactory;


public class MaintainCustomerDataAccess {
    // singleton
    private static MaintainCustomerDataAccess instance;
	private MaintainCustomerDataAccess () {}
    public static MaintainCustomerDataAccess getInstance() {
        return instance = instance == null ? new MaintainCustomerDataAccess() : instance;
    }

	public Customer SearchCustomer(String broncoID) throws ClassNotFoundException, SQLException {
		
		// create session
		Session session = ConnectionFactory.getInstance().getSession();
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
        }
        return customer;
	}

}

